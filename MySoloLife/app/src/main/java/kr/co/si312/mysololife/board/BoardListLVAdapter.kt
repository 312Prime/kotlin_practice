package kr.co.si312.mysololife.board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kr.co.si312.mysololife.R

class BoardListLVAdpter(val boardList : MutableList<BoardModel>) :BaseAdapter() {
    override fun getCount(): Int {
        return boardList.size
    }

    override fun getItem(position: Int): Any {
        return boardList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView

        if (view == null) {

            view = LayoutInflater.from(parent?.context).inflate(R.layout.board_list_item, parent,false)
        }
        return view!!
    }
}