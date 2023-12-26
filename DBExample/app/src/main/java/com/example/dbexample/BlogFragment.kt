package com.example.dbexample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BlogFragment : Fragment()  {

    private lateinit var recyclerView: RecyclerView
    private lateinit var blogAdapter: BlogAdapter
    private val blogs: MutableList<Blog> = mutableListOf(
        Blog("Blog 1", "This is the content of Blog 1."),
        Blog("Blog 2", "Here's the content of Blog 2."),
        Blog("Blog 3", "This is the content of Blog 3."),
        Blog("Blog 4", "Here's the content of Blog 4."),
        Blog("Blog 5", "This is the content of Blog 5."),
        Blog("Blog 6", "Here's the content of Blog 6."),
        Blog("Blog 7", "This is the content of Blog 7.")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_blogs, container, false)
        recyclerView = view.findViewById(R.id.blogs_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        print("+++++++++++++++")
        blogAdapter = BlogAdapter(blogs)
        recyclerView.adapter = blogAdapter

        Log.i("Taaaag","+++++++++++++++"+blogs)
        return view
    }
}
