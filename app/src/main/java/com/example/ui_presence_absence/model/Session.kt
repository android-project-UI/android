package com.example.ui_presence_absence.model


val allSessions = mutableMapOf<String, Session>()
class Session(var id: String, var title: String, var description: String, var date: String,
              var owner: Master,var presentStudents:List<Student>){

    init {
        allSessions.put(id, this)
    }
}

fun getSession(sessionId: String): Session? {
    return allSessions.get(sessionId)
}