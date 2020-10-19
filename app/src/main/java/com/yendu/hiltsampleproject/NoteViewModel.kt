package com.yendu.hiltsampleproject

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yendu.hiltsampleproject.pojo.Note
import com.yendu.hiltsampleproject.repositories.NoteRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class NoteViewModel @ViewModelInject constructor(private val noteRepository: NoteRepository):ViewModel(){

      fun insertNote(note: Note){
            viewModelScope.launch {
               noteRepository.insertNote(note);
            }
     }
    fun deleteNote(note:Note){
        viewModelScope.launch {
            noteRepository.deleteNote(note);
        }
    }

    fun getNotes():LiveData<List<Note>>{

       return noteRepository.getNotes();
    }

    fun deleteNotes(){
        viewModelScope.launch {
            noteRepository.deleteNotes()
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel();
    }

}