import Console._

object Main extends App {
  //создание студентов
  val students = (1 to 6).map { i =>
    val (firstName, lastName) = RandomGenerator.generateRandomName() //создание ИФ
    val age = RandomGenerator.generateRandomAge(15, 21) //ограничение возраста
    val groupNumber = s"Group${i % 3 + 1}" //кол-во груп
    val courses = RandomGenerator.generateRandomCourses() //присвоение курса
    val tokens = Tokenization.initialTokens //токены
    new Student(firstName, lastName, age, groupNumber, courses, tokens) //создание нового студента
  }

  //создание преподавателей
  val teacherCourses = List(
      List("Mathematics", "Programming", "English"),
      List("Programming", "English", "Mathematics"),
      List("English", "Mathematics", "Programming")
    )
    val teachers = (1 to 3).map { i =>
      val (firstName, lastName) = RandomGenerator.generateRandomName()
      val age = RandomGenerator.generateRandomAge(25, 50)
      val groupNumber = s"Group$i"
      val teachingCourses = teacherCourses(i - 1).map(new Course(_))
      new Teacher(firstName, lastName, age, groupNumber, teachingCourses)
    }
  teachers.foreach(teacher => {
    teacher.tokens = 0 //базовое кол-во токенов
  })

  //запись студентов на курсы и расчет стоимости
  students.foreach(student => {
    student.tokens = Tokenization.initialTokens
    student.courses.foreach(course => {
      val teacherInGroup = teachers.find(_.groupNumber == student.groupNumber)
      teacherInGroup.foreach { teacher =>
        val courseCost = Tokenization.calculateCourseCost(student.courseGrades(course))
        val discount = if (student.courseGrades(course) >= Tokenization.discountThreshold) {
          ((student.courseGrades(course) - Tokenization.discountThreshold) / 10) * Tokenization.discountPer10Points
        } else {
          0
        }
        val discountedCost = courseCost - discount
        teacher.tokens -= discountedCost
        student.tokens -= discountedCost
      }
    })
  })

  //вывод студентов
  println(s"${GREEN}---======= Students =======---${RESET}")
  students.foreach(student => {
    println(s"${YELLOW}================================${RESET}")
    println(student)
  })

  println("")

  //вывод информации преподавателей
  println(s"${GREEN}---======= Teachers =======---${RESET}")
  teachers.foreach(teacher => {
    println(s"${YELLOW}================================${RESET}")
    println(teacher)
    println(s"${YELLOW}---Tokens---${RESET}")
    println(s"Tokens: ${teacher.tokens}")

    println("")
  })

  //группы
  val studentsByGroup = students.groupBy(_.groupNumber) //создание групп за номером
  val sortedGroups = studentsByGroup.toSeq.sortBy { case (groupNumber, _) => groupNumber } //сортировака груп
  //вывод групп
  sortedGroups.foreach { case (groupNumber, studentsInGroup) =>
    val teacherInGroup = teachers.find(_.groupNumber == groupNumber)

    println("")
    println(s"${RED}-----======= $groupNumber =======-----${RESET}")

    teacherInGroup.foreach { teacher =>
      println(s"${YELLOW}================================${RESET}")
      println(teacher)
    }

    println("")

    println(s"${CYAN}Students:${RESET}")
    studentsInGroup.foreach(student => {
      println(s"${BLUE}-----------------------${RESET}")
      println(s"${BLUE}${student.getFirstName} ${student.getLastName} ${student.getAge}${RESET}")
    })

    println("")
  }
}