package com.yendu.hiltsampleproject

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yendu.hiltsampleproject.pojo.Note

@Database(entities = [Note::class],version = 1,exportSchema = false)
abstract  class SampleDatabase : RoomDatabase() {

    abstract fun getNoteDao():NoteDao;



}