package pruebaFold

class PersonWhoLikeDonuts(val weigth:Int){

  def eatDonut(donut: PersonWhoLikeDonuts.Donut): PersonWhoLikeDonuts = {
    new PersonWhoLikeDonuts(weigth + donut.fat)
  }

  def eatDonutsLeft(donuts: List[PersonWhoLikeDonuts.Donut]): PersonWhoLikeDonuts = {
    donuts.foldLeft(this){(person,donut) => new PersonWhoLikeDonuts(person.weigth + donut.fat)}
  }

  def eatDonutsRight(donuts: List[PersonWhoLikeDonuts.Donut]): PersonWhoLikeDonuts = {
    donuts.foldRight(this){(donut,person) => new PersonWhoLikeDonuts(person.weigth + donut.fat)}
  }

  def eatDonutsLeft2(donuts: List[PersonWhoLikeDonuts.Donut]): Int ={
    donuts.foldLeft(weigth){(acc, donut) => acc + donut.fat}
  }

  def eatDonutsRight2(donuts: List[PersonWhoLikeDonuts.Donut]): Int ={
    donuts.foldRight(weigth){(donut,acc) => acc + donut.fat}
  }
}

object PersonWhoLikeDonuts extends App{

  class Donut (val fat:Int) {}

  def testEatingDonuts():Unit = {
    val donuts = (2 to 8).map(n => new Donut(n)).toList
    val homer = new PersonWhoLikeDonuts(100)
    assert(homer.eatDonutsLeft(donuts).weigth   equals 135)
    assert(homer.eatDonutsRight(donuts).weigth  equals 135)
    assert(homer.eatDonutsLeft2(donuts)         equals 135)
    assert(homer.eatDonutsRight2(donuts)        equals 135)
  }

  testEatingDonuts()

}
