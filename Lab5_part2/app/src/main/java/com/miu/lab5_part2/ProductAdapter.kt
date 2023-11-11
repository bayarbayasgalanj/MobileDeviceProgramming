package com.miu.lab5_part2
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    var context: Context,
    var products: ArrayList<Product>,
    var product_images: IntArray,
    var product_logos: IntArray,
) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    var onAddButtonClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(view)
    }
    @Override
    override fun onBindViewHolder(holder: ProductAdapter.MyViewHolder, position: Int) {
        holder.product_name.text = products[position].product_name
        holder.product_description.text = products[position].product_desc
        holder.product_cost.text = "$${products[position].product_price}"
        holder.product_img.setImageResource(product_images[products[position].product_img])
        holder.product_logo.setImageResource(product_logos[products[position].product_logo])
        holder.rlayout.setOnClickListener{
            val intent = Intent(context, DetailActivity::class.java)
            var res = products[position].product_name
            Toast.makeText(context," $res clicked", Toast.LENGTH_LONG).show()
            intent.putExtra("image", product_images[products[position].product_img])
            intent.putExtra("name",  products[position].product_name)
            intent.putExtra("desc", products[position].product_desc)
            intent.putExtra("price", "$${products[position].product_price}")
            context.startActivity(intent)
        }

        holder.addButton.setOnClickListener {
//            insert Cart object across the app
            val product = products[position]
            val cartItem = Cart(
                product_id = product,
                product_qty = 1,  // Assuming quantity is 1 for simplicity
                product_price = product.product_price,
                product_price_total = product.product_price // Assuming total price equals unit price for one item
            )

            CartManager.addToCart(cartItem)
            Toast.makeText(context, "${product.product_name} added to cart", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount() = products.count()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val rlayout: RelativeLayout
        val product_name : TextView
        val product_description : TextView
        val product_cost : TextView
        val product_img: ImageView
        val product_logo: ImageView
        val addButton: Button
        init {
            rlayout = itemView.findViewById(R.id.playout) as RelativeLayout
            product_name = itemView.findViewById(R.id.product_name) as TextView
            product_description = itemView.findViewById(R.id.product_description) as TextView
            product_cost = itemView.findViewById(R.id.product_cost) as TextView
            product_img = itemView.findViewById(R.id.product_image) as ImageView
            product_logo = itemView.findViewById(R.id.product_logo) as ImageView
            addButton = itemView.findViewById(R.id.addButton) as Button
        }
    }
}