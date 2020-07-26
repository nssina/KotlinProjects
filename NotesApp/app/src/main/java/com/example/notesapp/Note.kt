package com.example.notesapp

class Note {

    var noteId: Int? = null
    var noteDes: String? = null
    var noteName: String? = null

    constructor(noteId: Int, noteDes: String, noteName: String) {
        this.noteId = noteId
        this.noteDes = noteDes
        this.noteName = noteName
    }


}