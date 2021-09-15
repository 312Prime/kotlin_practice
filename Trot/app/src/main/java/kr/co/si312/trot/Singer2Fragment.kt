package kr.co.si312.trot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController

class Singer2Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_singer2,container,false)
        // Inflate the layout for this fragment

        val image1 = view.findViewById<ImageView>(R.id.image1)
        image1.setOnClickListener {
            it.findNavController().navigate(R.id.action_singer2Fragment_to_singer1Fragment)
        }
        val image3 = view.findViewById<ImageView>(R.id.image3)
        image3.setOnClickListener {
            it.findNavController().navigate(R.id.action_singer2Fragment_to_singer3Fragment)
        }
        return view
    }


}