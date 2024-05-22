package com.example.ui_presence_absence.model

data class Session(
    var id: Int,
    var title: String,
    var description: String,
    var date: String,
    var owner: Master,
    var presentStudents:List<Student>
)