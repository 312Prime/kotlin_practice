package kr.co.si312.mysololife.Fragments

import android.os.Binder
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kr.co.si312.mysololife.R
import kr.co.si312.mysololife.contentsList.BookmarkRVAdapter
import kr.co.si312.mysololife.contentsList.ContentsModel
import kr.co.si312.mysololife.databinding.FragmentBookmarkBinding
import kr.co.si312.mysololife.databinding.FragmentTipBinding
import kr.co.si312.mysololife.utils.FBAuth
import kr.co.si312.mysololife.utils.FBRef
import java.util.stream.Stream

class BookmarkFragment : Fragment() {

    private lateinit var binding: FragmentBookmarkBinding

    private val TAG = BookmarkFragment::class.java.simpleName

    val bookmarkIdList = mutableListOf<String>()
    val items = ArrayList<ContentsModel>()
    val itemkeyList = ArrayList<String>()

    lateinit var rvAdapter: BookmarkRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentBookmarkBinding.inflate(layoutInflater)

        //1.전체 카테고리에 있는 컨텐츠 데이터들을 다 가져옴
        //2.사용자가 북마크한 정보를 다 가져옴
        getBookmarkData()
        //3.전체 컨텐츠 중에서, 사용자가 북마크한 정보만 보여줌
        rvAdapter = BookmarkRVAdapter(requireContext(), items, itemkeyList, bookmarkIdList)
        val rv : RecyclerView = binding.bookmarkRV
        rv.adapter = rvAdapter
        rv.layoutManager = GridLayoutManager(requireContext(),2)




        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_bookmarkFragment_to_homeFragment)
        }
        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_bookmarkFragment_to_talkFragment)
        }
        binding.tipTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_bookmarkFragment_to_tipFragment)
        }
        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_bookmarkFragment_to_storeFragment)
        }

        return binding.root
    }
    private fun getBookmarkData(){

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (dataModel in dataSnapshot.children) {

                    Log.e(TAG, dataModel.toString())
                    bookmarkIdList.add(dataModel.key.toString())
                }

                getCategoryData()
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ContentsListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.bookmarkRef.child(FBAuth.getUid()).addValueEventListener(postListener)
    }

    private fun getCategoryData(){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (dataModel in dataSnapshot.children) {

                    Log.d(TAG,dataModel.toString())
                    val item = dataModel.getValue(ContentsModel::class.java)
                    //3.전체 컨텐츠 중에서, 사용자가 북마크한 정보만 보여줌
                   if (bookmarkIdList.contains(dataModel.key.toString())) {
                       items.add(item!!)
                       itemkeyList.add(dataModel.key.toString())
                   }
                }
                rvAdapter.notifyDataSetChanged()
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ContentsListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.category1.addValueEventListener(postListener)
        FBRef.category2.addValueEventListener(postListener)
    }
}