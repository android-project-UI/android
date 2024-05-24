import com.example.ui_presence_absence.model.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class TestClass {

    @Test
    fun `test addStudent`() {
        val session = Session("1", "Test Session", "2024-05-24")
        val student = Student("1", "John Doe", "user.png", 0.8)
        session.addStudent(student)
        assertEquals(1, session.presentStudents.size)
    }
    @Test
    fun `test studentProperties`() {
        val student = Student("993623030", "John Doe", "user.png", 0.8)
        assertEquals("993623030", student.studentId)
        assertEquals("John Doe", student.fullName)
        assertEquals("user.png", student.image)
        assertEquals(0.8, student.presencePercentage, 0.001) // 0.001 is delta for double comparison
    }
    @Test
    fun `test getLessonOfMaster`() {
        val master = Master("1", "Master", "image.png", "username", "password", "group")
        val lesson = Lesson("1", "Test Lesson", master, 3, "Monday")
        allLessons["1"] = lesson // Assuming allLessons is accessible
        val lessons = getLessonOfMaster(master)
        assertEquals(1, lessons.size)
    }
    @Test
    fun `test getSession`() {
        val session = Session("1", "Test Session", "2024-05-24")
        allSessions["1"] = session // Assuming allSessions is accessible
        val retrievedSession = getSession("1")
        assertNotNull(retrievedSession)
    }
    @Test
    fun `test createMaster`() {
        createMaster() // Assuming you have a function to create masters
        val master = getMaster("9910")
        assertNotNull(master)
        assertEquals("محمد برزوئی", master?.name)
        assertEquals("user", master?.image)
        assertEquals("9910", master?.username)
        assertEquals("9910", master?.password)
        assertEquals("شبکه های کامپیوتری", master?.group)
    }

}
