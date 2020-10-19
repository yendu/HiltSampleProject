package com.yendu.hiltsampleproject

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yendu.hiltsampleproject.pojo.Note
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


     lateinit var viewModel: NoteViewModel;

    @Inject
    lateinit var adapter:NotesAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel=ViewModelProvider(this).get(NoteViewModel::class.java);
        recyclerview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerview.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerview.adapter=adapter;
        viewModel.getNotes().observe(this, Observer {
            if(it.isNotEmpty()){
                adapter.submitList(it);
            }
        })
        button.setOnClickListener {
            if(editText.text.toString().isNotEmpty()){
                viewModel.insertNote(Note(title = editText.text.toString()))
                editText.setText("")
            }
        }




    }

}