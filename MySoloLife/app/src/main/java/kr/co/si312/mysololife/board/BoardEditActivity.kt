package kr.co.si312.mysololife.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kr.co.si312.mysololife.R
import kr.co.si312.mysololife.databinding.ActivityBoardEditBinding
import kr.co.si312.mysololife.utils.FBRef
import java.lang.Exception

class BoardEditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardEditBinding
    private lateinit var key:String
    private val TAG = BoardEditActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBoardEditBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        key = intent.getStringExtra("key").toString()
        getBoardData(key)
        getImageData(key)

    }

    private fun getImageData(key: String){

        // Reference to an image file in Cloud Storage
        val storageReference = Firebase.storage.reference.child(key + ".png")

        // ImageView in your Activity
        val imageViewFromFB = binding.imageArea

        storageReference.downloadUrl.addOnCompleteListener(OnCompleteListener { task ->
            if (task.isSuccessful){

                Glide.with(this)
                    .load(task.result)
                    .into(imageViewFromFB)
            } else {

            }
        })
    }

    private fun getBoardData(key : String){

        val postListener = object : ValueEventListener{
            override fun onDataChange(datasnapshot: DataSnapshot) {

                val dataModel = datasnapshot.getValue(BoardModel::class.java)
                binding.TitleArea.setText(dataModel?.title)
                binding.ContentArea.setText(dataModel?.content)

            }

            override fun onCancelled(databaseError: DatabaseError) {
                //Getting Post failed, log a message
                Log.w(TAG,"loadPost:onCancelled",databaseError.toException())
            }
        }

        FBRef.boardRef.child(key).addValueEventListener(postListener)
    }
}