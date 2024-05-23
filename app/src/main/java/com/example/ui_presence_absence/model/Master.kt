package com.example.ui_presence_absence.model



private var allMasters = mutableMapOf<String, Master>()
class Master(var id: String, var name: String, var image: String, var username: String,
             var password: String, var sessions: List<Session>)
{

    init {
        allMasters.put(id, this)
    }
}