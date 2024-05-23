package com.example.ui_presence_absence.model



private var allMasters = mutableMapOf<String, Master>()
class Master(var id: String, var name: String, var image: String, var username: String,
             var password: String)
{
    init {
        allMasters.put(id, this)
    }
}

fun getMaster(id: String): Master? {
    return allMasters.get(id)
}