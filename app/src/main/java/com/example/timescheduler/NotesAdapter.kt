package com.example.timescheduler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private var note: List<Noter>,context: Context):
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
    class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val titleTextView:TextView=itemView.findViewById(R.id.TitleTextView)
        val contentTextView:TextView=itemView.findViewById(R.id.contentTextView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = note.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
       val note = note[position]
        holder.titleTextView.text=note.title
        holder.contentTextView.text=note.content
    }
    fun refreshData(newNotes: List<Noter>){
        note = newNotes
        notifyDataSetChanged()
    }
}