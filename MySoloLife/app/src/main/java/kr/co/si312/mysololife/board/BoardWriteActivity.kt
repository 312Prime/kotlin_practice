package kr.co.si312.mysololife.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import kr.co.si312.mysololife.R
import kr.co.si312.mysololife.contentsList.BookmarkModel
import kr.co.si312.mysololife.databinding.ActivityBoardWriteBinding
import kr.co.si312.mysololife.utils.FBAuth
import kr.co.si312.mysololife.utils.FBRef

class BoardWriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardWriteBinding
    private val TAG = BoardWriteActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBoardWriteBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.writeButton.setOnClickListener {

            val title = binding.TitleArea.text.toString()
            val content = binding.ContentArea.text.toString()
            val uid = FBAuth.getUid()
            val time = FBAuth.getTime()

            Log.d(TAG,title)
            Log.d(TAG,content)

            FBRef.boardRef
                .push()
                .setValue(BoardModel(title,content,uid,time))

            Toast.makeText(this,"게시글 작성 완료",Toast.LENGTH_SHORT).show()
        }

    }
}