package com.example.ui_presence_absence.model


val allSessions = mutableMapOf<String, Session>()
class Session(var id: String, var title: String, var date: String){

    val presentStudents = mutableListOf<Student>()

    init {
        allSessions.put(id, this)
    }

    fun addStudent(student: Student){
        presentStudents.add(student)
    }
}

fun getSession(sessionId: String): Session? {
    return allSessions.get(sessionId)
}