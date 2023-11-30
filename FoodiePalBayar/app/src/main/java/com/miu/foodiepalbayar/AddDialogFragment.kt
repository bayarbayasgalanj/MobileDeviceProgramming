package com.miu.foodiepalbayar
import android.app.Activity.RESULT_OK
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AddDialogFragment : DialogFragment() {
    interface AddRecipeListener {
        fun onRecipeAdded(recipe: Recipe)
    }
    interface AddMealListener {
        fun onMealAdded(meal: Meal)
    }
    interface AddBlogListener {
        fun onBlogAdded(blog: Blog)
    }

    private var layoutId: Int = R.layout.dialog_add_meal
    var listener: AddRecipeListener? = null
    var listenerMeal: AddMealListener? = null
    var listenerBlog: AddBlogListener? = null

    companion object {
        private const val PICK_IMAGE_REQUEST = 1

        fun newInstance(layoutId: Int): AddDialogFragment {
            val fragment = AddDialogFragment()
            val args = Bundle()
            args.putInt("layoutId", layoutId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            layoutId = it.getInt("layoutId")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = MaterialAlertDialogBuilder(requireContext())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(layoutId, null)
        try {
            val spinnerWeekday = view.findViewById<Spinner>(R.id.spinnerWeekday)
            val weekdays = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, weekdays)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerWeekday.adapter = adapter
        } catch (e: Exception) {
            e.printStackTrace()
        }
        builder.setView(view)
            .setTitle(if (layoutId == R.layout.dialog_add_recipe) "Add New Recipe" else "Add New Meal")
            .setPositiveButton("Add") { dialog, id ->
                if (layoutId == R.layout.dialog_add_recipe) {
                    val title = view.findViewById<EditText>(R.id.editTextRecipeTitle).text.toString()
                    val cookingTime = view.findViewById<EditText>(R.id.editTextCookingTime).text.toString()
                    val ratingBar = view.findViewById<RatingBar>(R.id.recipe_rating)
                    val rating = ratingBar.rating

                    // Get the selected image URI from the ImageView's tag
                    val imageView = view.findViewById<ImageView>(R.id.recipe_image)
                    val imageUri: Uri? = imageView.tag as? Uri

                    // If an image is selected, you can use imageUri to work with the image
                    val newRecipe = Recipe(title, R.drawable.image_placeholder, cookingTime, rating)

                    listener?.onRecipeAdded(newRecipe)
                } else if (layoutId == R.layout.dialog_add_meal) {
                    val spinner = view.findViewById<Spinner>(R.id.spinnerWeekday)
                    val mealplan = view.findViewById<EditText>(R.id.editTextMealplan).text.toString()
                    val selectedWeekday = spinner.selectedItem.toString() // Get the selected weekday from the Spinner
                    val newMeal = Meal(selectedWeekday, mealplan)
                    listenerMeal?.onMealAdded(newMeal)
                } else if (layoutId == R.layout.dialog_add_blog) {
                    val title = view.findViewById<EditText>(R.id.editTextTitle).text.toString()
                    val article = view.findViewById<EditText>(R.id.editTextArticle).text.toString()
                    val newBlog = Blog(title, article)
                    listenerBlog?.onBlogAdded(newBlog)
                }
            }
            .setNegativeButton("Cancel") { dialog, id ->
                dialog.cancel()
            }

        return builder.create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectImageButton = view.findViewById<Button>(R.id.select_image_button)
        selectImageButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Get the selected image URI from the Intent
            val imageUri: Uri? = data.data

            // Display the selected image in the ImageView
            val imageView = view?.findViewById<ImageView>(R.id.recipe_image)
            imageView?.setImageURI(imageUri)

            // Store the selected image URI in the ImageView's tag
            imageView?.tag = imageUri
        }
    }
}
