package com.miu.foodiepalbayar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BlogFragment : Fragment(), AddDialogFragment.AddBlogListener  {

    private lateinit var recyclerView: RecyclerView
    private lateinit var blogAdapter: BlogAdapter
    private val blogs: MutableList<Blog> = mutableListOf(
        Blog("Chocolate Cake", "45 mins"),
        Blog("Pasta","30 mins")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_blogs, container, false)
        recyclerView = view.findViewById(R.id.blogs_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        blogAdapter = BlogAdapter(blogs)
        recyclerView.adapter = blogAdapter
        return view
    }

    override fun onBlogAdded(blog: Blog) {
        blogs.add(blog)
        blogAdapter.notifyItemInserted(blogs.size - 1)
    }

}
