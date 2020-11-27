package com.example.noteit

import androidx.lifecycle.LiveData

class NotesRepository(private val notedao: NotesDao) {


    val allNotes:LiveData<List<Note>> = notedao.getAllNotes()

    suspend fun insert(note:Note){
        notedao.insert(note)
    }

    suspend fun delete(note: Note){
        notedao.delete(note)
    }

}