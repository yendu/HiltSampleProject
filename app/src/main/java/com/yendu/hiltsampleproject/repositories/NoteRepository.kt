package com.yendu.hiltsampleproject.repositories

import androidx.lifecycle.LiveData
import androidx.room.RoomDatabase
import com.yendu.hiltsampleproject.NoteDao
import com.yendu.hiltsampleproject.SampleDatabase
import com.yendu.hiltsampleproject.pojo.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
){

    fun getNotes():LiveData<List<Note>>{

        return noteDao.getNotes()
    }

     suspend fun insertNote(note:Note){
        withContext(Dispatchers.IO){
            noteDao.insertNote(note);
        }

    }

    suspend fun deleteNotes(){
        withContext(Dispatchers.IO){
            noteDao.deleteAllNotes();
        }

    }

    suspend fun deleteNote(note:Note){
        withContext(Dispatchers.IO){
            noteDao.deleteNote(note);
        }

    }



}