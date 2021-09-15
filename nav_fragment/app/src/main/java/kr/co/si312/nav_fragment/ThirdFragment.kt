package kr.co.si312.nav_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


class ThirdFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third, container, false)


        view.findViewById<Button>(R.id.button1).setOnClickListener {
            it.findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }

        view.findViewById<Button>(R.id.button2).setOnClickListener {
            it.findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
        }

        return view
    }


}