package com.example.ui_presence_absence.model

import kotlin.collections.mutableListOf

/**
 * A global map to store all lessons.
 */
val allLessons = mutableMapOf<String, Lesson>()

/**
 * Represents a lesson with its details.
 *
 * @property id The unique identifier for the lesson.
 * @property lessonName The name of the lesson.
 * @property master The master/teacher of the lesson.
 * @property lessonUnit The unit/credit of the lesson.
 * @property time The schedule time of the lesson.
 */
class Lesson(
    val id: String,
    val lessonName: String,
    var master: Master,
    val lessonUnit: Int,
    val time: String
) {

    private var allSessions = mutableMapOf<String, Session>()
    private var allStudents = mutableListOf<Student>()

    init {
        allLessons.put(id, this)
    }

    /**
     * Adds a session to the lesson.
     *
     * @param date The date of the session.
     * @param session The session object.
     */
    fun addSession(date: String, session: Session) {
        this.allSessions.put(this.lessonName + '-' + date, session)
    }

    /**
     * Adds a student to the lesson.
     *
     * @param student The student object.
     */
    fun addStudent(student: Student) {
        this.allStudents.add(student)
    }

    /**
     * Gets the number of sessions for the lesson.
     *
     * @return The number of sessions.
     */
    fun getNumberOfSessions(): Int {
        return allSessions.size
    }

    /**
     * Gets the number of students in the lesson.
     *
     * @return The number of students.
     */
    fun getNumberOfStudents(): Int {
        return allStudents.size
    }

    /**
     * Gets all students in the lesson.
     *
     * @return A list of all students.
     */
    fun getAllStudents(): MutableList<Student> {
        return this.allStudents
    }

    /**
     * Gets all sessions of the lesson.
     *
     * @return A collection of all sessions.
     */
    fun getAllSessions(): MutableCollection<Session> {
        return this.allSessions.values
    }
}

/**
 * Gets all lessons taught by a specific master.
 *
 * @param master The master whose lessons are to be retrieved.
 * @return A list of lessons taught by the specified master.
 */
fun getLessonOfMaster(master: Master): MutableList<Lesson> {
    val lessons = mutableListOf<Lesson>()

    for (lesson in allLessons.values)
        if (lesson.master == master)
            lessons.add(lesson)

    return lessons
}

/**
 * Gets a lesson by its ID.
 *
 * @param lessonId The ID of the lesson to retrieve.
 * @return The lesson object if found, otherwise null.
 */
fun getLesson(lessonId: String): Lesson? {
    return allLessons.get(lessonId)
}

/**
 * Creates sample lessons, masters, and students, and assigns students to lessons.
 */
fun createLesson() {
    val master1 = getMaster("9910")
    val master2 = getMaster("9911")
    val master3 = getMaster("9912")

    val s1 = getStudent("993623030")
    val s2 = getStudent("993623031")
    val s3 = getStudent("993623032")
    val s4 = getStudent("993623033")
    val s5 = getStudent("993623034")
    val s6 = getStudent("993623035")
    val s7 = getStudent("993623036")
    val s8 = getStudent("993623037")
    val s9 = getStudent("993623038")
    val s10 = getStudent("993623039")
    val s11 = getStudent("993623040")
    val s12 = getStudent("993623041")
    val s13 = getStudent("993623042")
    val s14 = getStudent("993623043")
    val s15 = getStudent("993623044")
    val s16 = getStudent("993623045")

    val l1 = master1?.let { Lesson("1", "ساختمان های داده", it, 3, "شنبه 10-12, یکشنبه 8-10") }
    val l2 = master2?.let { Lesson("2", "مبانی هوش مصنوعی", it, 3, "دوشنبه 10-12, شنبه 8-10") }
    val l3 = master3?.let { Lesson("3", "ریزپردازنده", it, 3, "چهارشنبه 10-12") }

    if (l1 != null) {
        s1?.let { l1.addStudent(it) }
        s3?.let { l1.addStudent(it) }
        s6?.let { l1.addStudent(it) }
        s16?.let { l1.addStudent(it) }
        s7?.let { l1.addStudent(it) }
        s2?.let { l1.addStudent(it) }
        s15?.let { l1.addStudent(it) }
    }

    if (l2 != null) {
        s1?.let { l2.addStudent(it) }
        s2?.let { l2.addStudent(it) }
        s3?.let { l2.addStudent(it) }
        s4?.let { l2.addStudent(it) }
        s5?.let { l2.addStudent(it) }
        s6?.let { l2.addStudent(it) }
        s7?.let { l2.addStudent(it) }
        s8?.let { l2.addStudent(it) }
        s9?.let { l2.addStudent(it) }
    }

    if (l3 != null) {
        s2?.let { l3.addStudent(it) }
        s4?.let { l3.addStudent(it) }
        s6?.let { l3.addStudent(it) }
        s8?.let { l3.addStudent(it) }
        s10?.let { l3.addStudent(it) }
        s12?.let { l3.addStudent(it) }
        s14?.let { l3.addStudent(it) }
        s16?.let { l3.addStudent(it) }
        s1?.let { l3.addStudent(it) }
        s3?.let { l3.addStudent(it) }
        s5?.let { l3.addStudent(it) }
        s7?.let { l3.addStudent(it) }
        s9?.let { l3.addStudent(it) }
    }
}
