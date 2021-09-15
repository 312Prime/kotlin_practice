package kr.co.si312.listview_second_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter (val List : MutableList<ListViewModel>) : BaseAdapter()
{
    override fun getCount(): Int {
        return List.size
    }

    override fun getItem(p0: Int): Any {
        return List[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var convertView = p1
        if (p1 == null){
            convertView = LayoutInflater.from(p2?.context).inflate(R.layout.listviewitem,p2,false)
        }
        val title = convertView!!.findViewById<TextView>(R.id.listviewItem)
        val title2 = convertView!!.findViewById<TextView>(R.id.listviewItem2)
        title.text = List[p0].text1
        title2.text = List[p0].text2
        return  convertView!!
    }
}