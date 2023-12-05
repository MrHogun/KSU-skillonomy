import scala.util.Random

class Teacher(firstName: String, lastName: String, age: Int, var groupNumber: String, var teachingCourses: List[Course]) extends Human(firstName, lastName, age) {

  var tokens: Int = 0 //базовое кол-во токенов у преподователя

  //присвоение курса преподавателю
  def getRandomTeachingCourse: Course = {
    val randomIndex = Random.nextInt(teachingCourses.length)
    teachingCourses(randomIndex)
  }
  override def toString: String = s"Teacher: ${super.toString}\nGroup Number: $groupNumber\nTeaching Courses: ${getRandomTeachingCourse}"
}
