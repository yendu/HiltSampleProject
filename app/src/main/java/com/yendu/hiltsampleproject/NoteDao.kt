package com.yendu.hiltsampleproject

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yendu.hiltsampleproject.pojo.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes:List<Note>);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note:Note);

    @Query("DELETE from note")
    fun deleteAllNotes()

    @Delete
    fun deleteNote(note:Note);

    @Query("SELECT * from note")
    fun getNotes(): LiveData<List<Note>>
}