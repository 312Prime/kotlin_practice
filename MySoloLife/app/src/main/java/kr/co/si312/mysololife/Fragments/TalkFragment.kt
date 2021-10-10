package kr.co.si312.mysololife.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kr.co.si312.mysololife.R
import kr.co.si312.mysololife.databinding.FragmentTalkBinding
import kr.co.si312.mysololife.databinding.FragmentTipBinding

class TalkFragment : Fragment() {
        private lateinit var binding: FragmentTalkBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        }
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            binding = FragmentTalkBinding.inflate(layoutInflater)

            binding = FragmentTalkBinding.inflate(layoutInflater)

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

            return binding.root
        }
    }
