package com.example.timescheduler

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore

class NoteDo {
    private val db = FirebaseFirestore.getInstance()
    val noteCollection = db.collection("Notes")
    private val auth = Firebase.auth

    fun addnote(text: String){
        val currentUserId = auth.currentUser!!.uid
        val note = Note(text,currentUserId)
        noteCollection.document().set(note)

    }
}


