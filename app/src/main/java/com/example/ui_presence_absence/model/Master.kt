package com.example.ui_presence_absence.model

/**
 * A global map to store all masters.
 */
private var allMasters = mutableMapOf<String, Master>()

/**
 * Represents a master/teacher with their details.
 *
 * @property id The unique identifier for the master.
 * @property name The name of the master.
 * @property image The image/URL of the master's picture.
 * @property username The username for the master's account.
 * @property password The password for the master's account.
 * @property group The group/department the master belongs to.
 */
class Master(
    var id: String,
    var name: String,
    var image: String,
    var username: String,
    var password: String,
    var group: String
) {
    init {
        allMasters.put(id, this)
    }
}

/**
 * Retrieves a master by their ID.
 *
 * @param id The ID of the master to retrieve.
 * @return The master object if found, otherwise null.
 */
fun getMaster(id: String): Master? {
    return allMasters.get(id)
}

/**
 * Creates sample masters and adds them to the global masters map.
 */
fun createMaster() {
    val m1 = Master(
        "9910", "محمد برزوئی", "user", "9910", "9910",
        group = "شبکه های کامپیوتری"
    )

    val m2 = Master(
        "9911", "پروین شیخ الاسلام", "user", "9911", "9911",
        group = "هوش مصنوعی"
    )

    val m3 = Master(
        "9912", "مریم جمالی", "user", "9912", "9912",
        group = "نرم افزار"
    )
}
