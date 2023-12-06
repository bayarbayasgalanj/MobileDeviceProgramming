package com.miu.foodiepalbayar
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BlogAdapter(private val blogs: List<Blog>) : RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    class BlogViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewTitle: TextView = view.findViewById(R.id.blog_title)
        val textViewArticle: TextView = view.findViewById(R.id.blog_article)
        val shareButton: ImageButton = view.findViewById(R.id.share_button) // Corrected to ImageButton
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_blog, parent, false)
        return BlogViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val currentItem = blogs[position]
        holder.textViewTitle.text = currentItem.title
        holder.textViewArticle.text = currentItem.article

        // Set up the share button click listener
        holder.shareButton.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "${currentItem.title}\n\n${currentItem.article}")
                type = "text/plain"
            }
            it.context.startActivity(Intent.createChooser(shareIntent, "Share blog via"))
        }
    }

    override fun getItemCount() = blogs.size
}
