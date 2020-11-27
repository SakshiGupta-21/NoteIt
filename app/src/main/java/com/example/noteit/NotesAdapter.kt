package com.example.noteit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(val context:Context,val listener:INoteAdapter): RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    val allNotes =  ArrayList<Note>()
    inner class NoteViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){

        val textview = itemView.findViewById<TextView>(R.id.text)
        val deleteButton = itemView.findViewById<ImageView>(R.id.deleteButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notes,parent,false))
        viewHolder.deleteButton.setOnClickListener {
            listener.onItemClick(allNotes[viewHolder.adapterPosition])
        }
        return  viewHolder
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textview.text= currentNote.text

    }

   fun updateList(newList: List<Note>){
       allNotes.clear()
       allNotes.addAll(newList)
       notifyDataSetChanged()
   }

}
interface INoteAdapter{
    fun onItemClick(note: Note)
}
