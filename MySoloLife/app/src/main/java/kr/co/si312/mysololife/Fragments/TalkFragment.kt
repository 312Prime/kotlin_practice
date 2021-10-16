package kr.co.si312.mysololife.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kr.co.si312.mysololife.R
import kr.co.si312.mysololife.board.BoardListLVAdpter
import kr.co.si312.mysololife.board.BoardModel
import kr.co.si312.mysololife.board.BoardWriteActivity
import kr.co.si312.mysololife.contentsList.ContentsModel
import kr.co.si312.mysololife.databinding.FragmentTalkBinding
import kr.co.si312.mysololife.databinding.FragmentTipBinding
import kr.co.si312.mysololife.utils.FBAuth
import kr.co.si312.mysololife.utils.FBRef

class TalkFragment : Fragment() {
        private lateinit var binding: FragmentTalkBinding
        private val TAG = TalkFragment::class.java.simpleName
       private val boardDataList = mutableListOf<BoardModel>()
    private lateinit var boardLVAdapter : BoardListLVAdpter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        }
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            binding = FragmentTalkBinding.inflate(layoutInflater)

//            val boardList = mutableListOf<BoardModel>()
//            boardList.add(BoardModel("a","b","c","d"))
            boardLVAdapter = BoardListLVAdpter(boardDataList)

            binding.boardListView.adapter = boardLVAdapter

            binding.writeBtn.setOnClickListener {
                val intent = Intent(context,BoardWriteActivity::class.java)
                startActivity(intent)
            }

            binding.homeTap.setOnClickListener {
                it.findNavController().navigate(R.id.action_talkFragment_to_homeFragment)
            }
            binding.tipTap.setOnClickListener {
                it.findNavController().navigate(R.id.action_talkFragment_to_tipFragment)
            }
            binding.bookmarkTap.setOnClickListener {
                it.findNavController().navigate(R.id.action_talkFragment_to_bookmarkFragment)
            }
            binding.storeTap.setOnClickListener {
                it.findNavController().navigate(R.id.action_talkFragment_to_storeFragment)
            }

            getFBBoardData()

            return binding.root
        }

    private fun getFBBoardData(){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                boardDataList.clear()

                for (dataModel in dataSnapshot.children) {

                    Log.d(TAG,dataModel.toString())

                    val item = dataModel.getValue(BoardModel::class.java)
                    boardDataList.add(item!!)
                }

                boardLVAdapter.notifyDataSetChanged()
                Log.d(TAG,boardDataList.toString())

            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ContentsListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
       FBRef.boardRef.addValueEventListener(postListener)
    }

}
