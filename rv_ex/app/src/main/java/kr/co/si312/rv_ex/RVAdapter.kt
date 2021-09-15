package kr.co.si312.rv_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(val items: MutableList<String>) : RecyclerView.Adapter<RVAdapter.ViewHolder>(){

    //
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)

        return  ViewHolder(view)
    }
    //터치 구현
    interface ItemClick {
        fun onClick(view : View, position: Int)
    }
    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {

        if (itemClick != null){
            holder.itemView.setOnClickListener { v->
                itemClick?.onClick(v,position)
            }
        }

        holder.bindItems(items[position])

    }
    //전체 리사이클러 뷰의 개수
    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemViwew : View) : RecyclerView.ViewHolder(itemViwew){

        fun bindItems(item : String){
            val rv_text = itemView.findViewById<TextView>(R.id.rvItem)
            rv_text.text = item
        }
    }
}