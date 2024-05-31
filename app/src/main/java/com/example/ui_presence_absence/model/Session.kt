package com.example.ui_presence_absence.model

/**
 * A global map to store all sessions.
 */
val allSessions = mutableMapOf<String, Session>()

/**
 * Represents a session with its details.
 *
 * @property id The unique identifier for the session.
 * @property title The title of the session.
 * @property date The date of the session.
 */
class Session(
    var id: String,
    var title: String,
    var date: String
) {

    val presentStudents = mutableListOf<Student>()

    init {
        allSessions.put(id, this)
    }

    /**
     * Adds a student to the list of present students for the session.
     *
     * @param student The student to add.
     */
    fun addStudent(student: Student) {
        presentStudents.add(student)
    }

    /**
     * Gets the number of present students for the session.
     *
     * @return The number of present students.
     */
    fun getNumberOfPresentStudents(): Int {
        return this.presentStudents.size
    }
}

/**
 * Retrieves a session by its ID.
 *
 * @param sessionId The ID of the session to retrieve.
 * @return The session object if found, otherwise null.
 */
fun getSession(sessionId: String): Session? {
    return allSessions.get(sessionId)
}
