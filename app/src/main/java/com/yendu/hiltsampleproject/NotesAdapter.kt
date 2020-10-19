package com.yendu.hiltsampleproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yendu.hiltsampleproject.pojo.Note
import javax.inject.Inject


class NotesAdapter @Inject constructor() : ListAdapter<Note, NotesAdapter.NoteViewHolder>(diffUtil){



    inner class NoteViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        private val textView:TextView=itemView.findViewById(R.id.note_item_text);
        fun bind(note:Note){
            textView.text=note.title;
        }
    }
    companion object{
        val diffUtil:DiffUtil.ItemCallback<Note> = object : DiffUtil.ItemCallback<Note>(){
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem==newItem
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
               return oldItem.id==newItem.id
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.note_item_view,parent,false);
        return NoteViewHolder(view);
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note=getItem(holder.adapterPosition);
        holder.bind(note);

    }
}