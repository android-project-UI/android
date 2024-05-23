package com.example.ui_presence_absence.model

class Student(val studentId: String, val fullName: String, val image: String,
              val presencePercentage: Double)
{
    private var allStudent = mutableMapOf<String, Student>()

    init {
        allStudent.put(studentId, this)
    }


    fun getStudent(studentId: String): Student? {
        return this.allStudent[studentId]
    }
}