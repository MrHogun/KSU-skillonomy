class Human(var firstName: String, var lastName: String, var age: Int) {

  //методы получения ИФ и возраста
  def getFirstName: String = firstName
  def getLastName: String = lastName
  def getAge: Int = age

  override def toString: String = s"$firstName $lastName $age"
}
