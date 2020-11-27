package com.example.noteit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):AndroidViewModel(application) {

    val allNotes:LiveData<List<Note>>
    val repository:NotesRepository
    init {

        var dao = NotesDatabase.getDatabase(application).getNoteDao()
         repository= NotesRepository(dao)

        allNotes= repository.allNotes

    }

    fun deleteNote(note: Note)= viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }
    fun insertNote(note: Note)= viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }

}