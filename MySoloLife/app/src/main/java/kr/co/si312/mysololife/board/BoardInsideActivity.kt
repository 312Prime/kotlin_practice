package kr.co.si312.mysololife.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kr.co.si312.mysololife.R
import kr.co.si312.mysololife.databinding.ActivityBoardInsideBinding
import kr.co.si312.mysololife.utils.FBRef

class BoardInsideActivity : AppCompatActivity() {

    private val TAG = BoardInsideActivity::class.java.simpleName
    private lateinit var binding: ActivityBoardInsideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBoardInsideBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


//          첫번째 방법
//        val title = intent.getStringExtra("title").toString()
//        val content = intent.getStringExtra("content").toString()
//        val time = intent.getStringExtra("time").toString()
//
//        binding.TitleArea.text = title
//        binding.TextArea.text = content
//        binding.TimeArea.text = time

//          두번째 방법
        val key = intent.getStringExtra("key")

        getBoardData(key.toString())
    }

    private fun getBoardData(key : String){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val dataModel= dataSnapshot.getValue(BoardModel::class.java)
                Log.d(TAG,dataModel!!.title)

                binding.TitleArea.text = dataModel!!.title
                binding.TextArea.text = dataModel!!.content
                binding.TimeArea.text = dataModel!!.time
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ContentsListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.boardRef.child(key).addValueEventListener(postListener)

    }


}