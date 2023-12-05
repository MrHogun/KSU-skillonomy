import Console._
import scala.util.Random

class Student(firstName: String, lastName: String, age: Int, var groupNumber: String, var courses: List[Course], var tokens: Int) extends Human(firstName, lastName, age) {

  val courseCost: Int = Tokenization.calculateCourseCost(randomGrade)
  val randomGrade: Int = generateRandomGrade()
  val gradeLevel: String = getGradeLevel(randomGrade)

  //создание отдельной оценки для каждого курса
  val courseGrades: Map[Course, Int] = generateCourseGrades()

  //генерация оценки
  private def generateCourseGrades(): Map[Course, Int] = {
    courses.map(course => course -> generateRandomGrade()).toMap
  }

  def generateRandomGrade(): Int = Random.nextInt(100) + 1

  //определение уровня оценки
  def getGradeLevel(grade: Int): String = grade match {
    case g if g >= 90 => "A (excellent)"
    case g if g >= 80 => "B (very good)"
    case g if g >= 65 => "C (good)"
    case g if g >= 55 => "D (satisfactory)"
    case g if g >= 50 => "E (sufficient)"
    case g if g >= 35 => "FX (unsatisfactory)"
    case _ => "F (unacceptable)"
  }

  //расчет стипендии
  def calculateScholarship(): (Int, String) = {
    val minScoreForScholarship = 60
    val baseScholarship = 1000
    val addAmountPer10Points = 200

    if (randomGrade >= minScoreForScholarship) {
      val scholarshipScore = (randomGrade - minScoreForScholarship).max(0)
      val scholarshipAmount = baseScholarship + (scholarshipScore / 10) * addAmountPer10Points

      (scholarshipAmount, "Received")
    } else {
      (0, "Not Received")
    }
  }

  //вычисление остатка точенов
  val tokensAfterCourses: Int = tokens - courses.length * courseCost

  override def toString: String = {
    val (scholarshipAmount, scholarshipStatus) = calculateScholarship()

    s"${YELLOW}---Student Info---${RESET}\n" + //информация студента
      s"${CYAN}Student:${RESET} ${super.toString}\n" +
      s"${CYAN}Group Number:${RESET} $groupNumber\n\n" +
      s"${CYAN}Courses:${RESET} ${courses.mkString(", ")}\n\n" +
      s"${YELLOW}---Grades---${RESET}\n" +
      courseGrades.map { case (course, grade) =>
        s"${course.name}: $grade (${getGradeLevel(grade)})"
      }.mkString("\n") +
      s"\n${YELLOW}---Scholarship---${RESET}\n" + //стипендия
      s"Scholarship Amount: $scholarshipAmount UAH\n" +
      s"Scholarship Status: $scholarshipStatus\n\n" +
      s"${YELLOW}---Tokens---${RESET}\n" + //токены
      s"Tokens: ${Tokenization.applyBonus(tokensAfterCourses, randomGrade)}\n" +
      courses.map { course =>
        val discount = if (courseGrades(course) >= Tokenization.discountThreshold) {
          ((courseGrades(course) - Tokenization.discountThreshold) / 10) * Tokenization.discountPer10Points
        } else {
          0
        }
        s"Discount on ${course.name}: -$discount Tokens" //скидки на курсы
      }.mkString("\n")
  }
}