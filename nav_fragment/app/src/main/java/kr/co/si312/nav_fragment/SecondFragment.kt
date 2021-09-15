package kr.co.si312.nav_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


class SecondFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)


        view.findViewById<Button>(R.id.button1).setOnClickListener {
            it.findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }

        view.findViewById<Button>(R.id.button3).setOnClickListener {
            it.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }

        return view
    }


}