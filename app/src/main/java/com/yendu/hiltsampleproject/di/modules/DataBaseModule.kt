package com.yendu.hiltsampleproject.di.modules

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yendu.hiltsampleproject.NoteDao
import com.yendu.hiltsampleproject.SampleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun getApplicationDatabase(@ApplicationContext context: Context):SampleDatabase{
       return Room.databaseBuilder(context,SampleDatabase::class.java,"notes").build();
    }

    @Singleton
    @Provides
    fun getDatabaseDao(sampleDatabase: SampleDatabase):NoteDao{
        return sampleDatabase.getNoteDao();
    }


}