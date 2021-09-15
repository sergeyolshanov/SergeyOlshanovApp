package com.example.notes.sergeyolshanovapp.module.app_notes.main_note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.sergeyolshanovapp.R
import com.example.notes.sergeyolshanovapp.module.app_notes.model.AppNote

class MainNoteAdapter: RecyclerView.Adapter<MainNoteAdapter.MainNoteHolder>() {

    private var mListNotes = emptyList<AppNote>()

    class MainNoteHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameNote: TextView = view.findViewById(R.id.item_note_name)
        val textNote: TextView = view.findViewById(R.id.item_note_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainNoteHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MainNoteHolder(view)
    }

    override fun onBindViewHolder(holder: MainNoteHolder, position: Int) {
        holder.nameNote.text = mListNotes[position].name
        holder.textNote.text = mListNotes[position].text
    }

    override fun getItemCount(): Int {
        return mListNotes.size
    }

    fun setList(list: List<AppNote>){
        mListNotes = list
        notifyDataSetChanged()
    }

}