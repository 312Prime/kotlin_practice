package kr.co.si312.mysololife.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kr.co.si312.mysololife.R
import kr.co.si312.mysololife.databinding.ActivityBoardInsideBinding
import kr.co.si312.mysololife.utils.FBRef
import java.lang.Exception

class BoardInsideActivity : AppCompatActivity() {

    private val TAG = BoardInsideActivity::class.java.simpleName
    private lateinit var binding: ActivityBoardInsideBinding
    private lateinit var key : String

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBoardInsideBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.boardSettingIcon.setOnClickListener {
            showDialog()
        }

        key = intent.getStringExtra("key").toString()

        getBoardData(key)
        getImageData(key)
    }

    private fun showDialog(){

        val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog,null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("게시글 수정/삭제")

        val alertDialog = mBuilder.show()
        alertDialog.findViewById<Button>(R.id.editBtn)?.setOnClickListener {
            Toast.makeText(this,"aa",Toast.LENGTH_SHORT).show()
        }
        alertDialog.findViewById<Button>(R.id.deleteBtn)?.setOnClickListener {
            FBRef.boardRef.child(key).removeValue()
            finish()
            Toast.makeText(this,"삭제되었습니다",Toast.LENGTH_SHORT).show()
        }
    }

    private fun getImageData(key: String){

        // Reference to an image file in Cloud Storage
        val storageReference = Firebase.storage.reference.child(key + ".png")

// ImageView in your Activity
        val imageViewFromFB = binding.getImageArea

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
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                try {
                    val dataModel= dataSnapshot.getValue(BoardModel::class.java)

                    binding.TitleArea.text = dataModel!!.title
                    binding.TextArea.text = dataModel!!.content
                    binding.TimeArea.text = dataModel!!.time

                } catch (e: Exception){
                    Log.d(TAG,"삭제완료")
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ContentsListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.boardRef.child(key).addValueEventListener(postListener)

    }


}