package com.miu.foodiepalbayar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AboutMeFragment : Fragment() {

    private val culinaryDetails = mutableListOf<CulinaryDetail>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about_me, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Display initial details
        updateDetails()
    }

    private fun addNewDetail() {
        // For simplicity, add a new hardcoded detail
        val newDetail = CulinaryDetail("New Recipe", "Description for the new recipe.")
        culinaryDetails.add(newDetail)

        // Update the UI to display the new detail
        updateDetails()
    }

    private fun updateDetails() {
        // Clear existing details
        val detailsContainer: LinearLayout? = view?.findViewById(R.id.detailsContainer)
        detailsContainer?.removeAllViews()

        // Add details to the UI
        culinaryDetails.forEach { detail ->
            val detailView = layoutInflater.inflate(R.layout.item_culinary_detail, null)
            detailView.findViewById<TextView>(R.id.tvDetailTitle).text = detail.title
            detailView.findViewById<TextView>(R.id.tvDetailDescription).text = detail.description

            detailsContainer?.addView(detailView)
        }
    }
}
