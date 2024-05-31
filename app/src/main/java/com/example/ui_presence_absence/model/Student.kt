package com.example.ui_presence_absence.model

/**
 * A global map to store all students.
 */
private var allStudent = mutableMapOf<String, Student>()

/**
 * Represents a student with their details.
 *
 * @property studentId The unique identifier for the student.
 * @property fullName The full name of the student.
 * @property image The image/URL of the student's picture.
 * @property presencePercentage The presence percentage of the student.
 */
class Student(
    val studentId: String,
    val fullName: String,
    val image: String,
    val presencePercentage: Double
) {
    init {
        allStudent.put(studentId, this)
    }
}

/**
 * Retrieves a student by their ID.
 *
 * @param studentId The ID of the student to retrieve.
 * @return The student object if found, otherwise null.
 */
fun getStudent(studentId: String): Student? {
    return allStudent[studentId]
}

/**
 * Creates sample students and adds them to the global students map.
 */
fun createStudents() {
    val s1 = Student("993623030", "امیر فیض", "user.png", 0.2)
    val s2 = Student("993623031", "کاظم هرندی", "user.png", 0.9)
    val s3 = Student("993623032", "محمد ایرانپور", "user.png", 0.95)
    val s4 = Student("993623033", "محدثه امیری", "user.png", 0.1)
    val s5 = Student("993623034", "تینا بازغی", "user.png", 0.8)
    val s6 = Student("993623035", "مریم امیرجلالی", "user.png", 0.8)
    val s7 = Student("993623036", "کیکاووس یاکیده", "user.png", 1.0)
    val s8 = Student("993623037", "ناصر طهماسب", "user.png", 1.0)
    val s9 = Student("993623038", "شهلا ناظریان", "user.png", 1.0)
    val s10 = Student("993623039", "کلنوش آصفی", "user.png", 0.45)
    val s11 = Student("993623040", "پیروز آشفته", "user.png", 0.6)
    val s12 = Student("993623041", "محمدعلی نجاح", "user.png", 1.0)
    val s13 = Student("993623042", "دیبا پورشانظری", "user.png", 1.0)
    val s14 = Student("993623043", "علی رهبر", "user.png", 1.0)
    val s15 = Student("993623044", "سوگل مشایخی", "user.png", 0.5)
    val s16 = Student("993623045", "علی وارسته", "user.png", 0.75)
}