object Tokenization {
  val initialTokens: Int = 50000 //базовое кол-во токенов
  val initialCourseCost: Int = 12000 //цена за курс
  val discountThreshold: Int = 60 //порог скидки
  val discountPer10Points: Int = 1000 //скидка за каждые 10 балов

  //расчет цены курса в зависимости от оценки
  def calculateCourseCost(grade: Int): Int = {
    if (grade < discountThreshold) {
      initialCourseCost
    } else {
      val discount = ((grade - discountThreshold) / 10) * discountPer10Points
      val newCost = initialCourseCost - discount
      math.max(0, newCost)
    }
  }

  //бонусное кол-во токенов за оценку
  def applyBonus(tokens: Int, grade: Int): Int = {

    val bonusThreshold = 90 //требуемая оценка для бонуса
    val bonusAmount = 2000 //кол-во токенов бонуса
    if (grade > bonusThreshold) {
      tokens + bonusAmount
    } else {
      tokens
    }
  }
}
