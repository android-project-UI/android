package com.example.ui_presence_absence.model

var allStudent = mutableMapOf<String, Student>()
class Student(val studentId: String, val fullName: String, val image: String,
              val presencePercentage: Double)
{
    init {
        allStudent.put(studentId, this)
    }
}

fun getStudent(studentId: String): Student? {
    return allStudent[studentId]
}