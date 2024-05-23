package com.example.ui_presence_absence.model



private var allMasters = mutableMapOf<String, Master>()
class Master(var id: String, var name: String, var image: String, var username: String,
             var password: String, var group: String)
{
    init {
        allMasters.put(id, this)
    }
}

fun getMaster(id: String): Master? {
    return allMasters.get(id)
}

fun createMaster(){
    val m1 = Master("9910", "محمد برزوئی", "user", "9910", "9910",
        group = "شبکه")

    val m2 = Master("9911", "پروین شیخ الاسلام", "user", "9911", "9911",
        group = "هوش مصنوعی")

    val m3 = Master("9912", "مریم جمالی", "user", "9912", "9912",
        group = "نرم افزار")
}