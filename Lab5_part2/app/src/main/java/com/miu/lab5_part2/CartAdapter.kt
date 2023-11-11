package com.miu.lab5_part2
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(var context: Context,
                  var carts: ArrayList<Cart>,
                  var product_images:IntArray,
                  var product_logos:IntArray,
) : RecyclerView.Adapter<CartAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: CartAdapter.MyViewHolder, position: Int) {
        holder.product_name.text = carts[position].product_id.product_name
        holder.product_description.text = carts[position].product_id.product_desc
        holder.product_qty.text = "${carts[position].product_qty}"
        val product_total_price = carts[position].product_qty * carts[position].product_price
        holder.product_total_price.text = "$${product_total_price}"
        holder.product_img.setImageResource(product_images[carts[position].product_id.product_img])
        holder.product_logo.setImageResource(product_logos[carts[position].product_id.product_logo])
    }
    override fun getItemCount() = carts.count()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val rlayout: RelativeLayout
        val product_name : TextView
        val product_description : TextView
        val product_qty : TextView
        val product_total_price : TextView
        val product_img: ImageView
        val product_logo: ImageView

        init {
            rlayout = itemView.findViewById(R.id.playout) as RelativeLayout
            product_name = itemView.findViewById(R.id.product_name) as TextView
            product_description = itemView.findViewById(R.id.product_description) as TextView
            product_qty = itemView.findViewById(R.id.product_qty) as TextView
            product_total_price = itemView.findViewById(R.id.product_total_price) as TextView
            product_img = itemView.findViewById(R.id.product_image) as ImageView
            product_logo = itemView.findViewById(R.id.product_logo) as ImageView
        }
    }
}