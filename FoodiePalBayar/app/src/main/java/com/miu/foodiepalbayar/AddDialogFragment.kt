package com.miu.foodiepalbayar

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AddDialogFragment : DialogFragment() {
    interface AddRecipeListener {
        fun onRecipeAdded(recipe: Recipe)
    }
    interface AddMealListener {
        fun onMealAdded(meal: Meal)
    }
    private var layoutId: Int = R.layout.dialog_add_recipe
    var listener: AddRecipeListener? = null
    var listenerMeal: AddMealListener? = null

    companion object {
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

        builder.setView(view)
            .setTitle(if (layoutId == R.layout.dialog_add_recipe) "Add New Recipe" else "Add New Meal")
            .setPositiveButton("Add") { dialog, id ->
                if (layoutId == R.layout.dialog_add_recipe) {
                    val title = view.findViewById<EditText>(R.id.editTextRecipeTitle).text.toString()
                    val imageResource = 0 // Placeholder for actual image resource ID
                    val cookingTime = "Some Time" // Placeholder for actual cooking time
                    val rating = 5.0f // Placeholder for actual rating

                    val newRecipe = Recipe(title, imageResource, cookingTime, rating)
                    listener?.onRecipeAdded(newRecipe)
                } else if (layoutId == R.layout.dialog_add_meal) {
                    val weekday = view.findViewById<EditText>(R.id.editTextWeekday).text.toString()
                    val mealplan = view.findViewById<EditText>(R.id.editTextMealplan).text.toString()
                    val newMeal = Meal(weekday, mealplan)
                    listenerMeal?.onMealAdded(newMeal)
                }
            }
            .setNegativeButton("Cancel") { dialog, id ->
                dialog.cancel()
            }

        return builder.create()
    }
}
