import scala.util.Random

object RandomGenerator {
  //заготовленные имена фамилии и курсы для генерации людей
  val firstNames = List("Oleksandr", "Iryna", "Vasyl", "Olha", "Ivan", "Natalia", "Petro", "Maria", "Andrii", "Kateryna")
  val lastNames = List("Kovalenko", "Petrenko", "Ivanenko", "Sydorenko", "Hryhorenko", "Melnik", "Shevchenko", "Kozlovskyi", "Tkachenko", "Lysenko")
  val courses = List("Mathematics", "Programming", "English")

  //генерация имени и фамилии
  def generateRandomName(): (String, String) = {
    val firstName = firstNames(Random.nextInt(firstNames.length))
    val lastName = lastNames(Random.nextInt(lastNames.length))
    (firstName, lastName)
  }

  //генерация возраста
  def generateRandomAge(min: Int, max: Int): Int = {
    Random.nextInt(max - min + 1) + min
  }

    //генерация курсов
  def generateRandomCourses(): List[Course] = {
    val numCourses = Random.nextInt(courses.length) + 1
    courses.take(numCourses).map(new Course(_))
  }
}
