package kr.co.si312.sogating.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class FirebaseAuthUtils {

    companion object{

        private lateinit var auth : FirebaseAuth

        fun getUid() : String {

            auth = FirebaseAuth.getInstance()

            return auth.currentUser?.uid.toString()
        }
    }
}