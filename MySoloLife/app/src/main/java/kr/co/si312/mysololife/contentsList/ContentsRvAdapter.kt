package kr.co.si312.mysololife.contentsList

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.co.si312.mysololife.R

class ContentsRvAdapter(val context : Context, val items : ArrayList<ContentsModel>) : RecyclerView.Adapter<ContentsRvAdapter.Viewholder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContentsRvAdapter.Viewholder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.contents_rv_item,parent,false)
        return Viewholder(v)
    }


    interface ItemClick{
        fun onClick(view : View, position: Int)
    }
    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: ContentsRvAdapter.Viewholder, position: Int) {

        if (itemClick != null) {
            holder.itemView.setOnClickListener{ v->
                itemClick?.onClick(v,position)
            }
        }

        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class Viewholder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(item : ContentsModel){
            val contentTitle = itemView.findViewById<TextView>(R.id.textArea)
            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)

            contentTitle.text = item.title

            Glide.with(context)
                .load(item.imageUrl)
                .into(imageViewArea)


        }
    }


}