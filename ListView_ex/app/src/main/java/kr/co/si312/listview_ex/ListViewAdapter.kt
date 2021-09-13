package kr.co.si312.listview_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.text.FieldPosition

class ListViewAdapter(val List : MutableList<ListViewModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return  List.size
    }

    override fun getItem(p0: Int): Any {
        return List[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        var convertView = convertView

        if(convertView == null){
            convertView = LayoutInflater.from(p2?.context).inflate(R.layout.listview_item,p2,false)
        }

        val title = convertView!!.findViewById<TextView>(R.id.listviewItem)
        val content = convertView!!.findViewById<TextView>(R.id.listviewItem2)
        title.text = List[position].title
        content.text = List[position].content
        //List[0] -> ListViewModel("a","b")
        //List[1] -> ListViewModel("c","d")
        //List[2] -> ListViewModel("e","f")
        return convertView!!
    }
}