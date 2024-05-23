package com.example.ui_presence_absence.model
import kotlin.collections.mutableListOf


val allLessons = mutableMapOf<String, Lesson>()

class Lesson(val id: String, val lessonName: String, val master: Master, lessonUnit: Int){

    private var allSessions = mutableMapOf<String, Session>()

    init {
        allLessons.put(id, this)
    }

    fun addSession(date:String, session: Session) {
        this.allSessions.put(this.lessonName + '-' + date, session)
    }
}