package prueba

class Person (
               val firstName: String,
               val lastName: String,
               val age: Int){

  def name = s"$firstName $lastName"
  def itIsTrueThat(f: Person => Boolean): Boolean = f(this)

  override def toString = s"Nombre: $firstName $lastName\nEdad: $age"
}

object Person extends App{
  def generatePeople = {
    List(
      new Person("José", "Martinez", 70),
      new Person("Gonzalo", "Peletik", 23),
      new Person("Tomas", "Fernandez", 22),
      new Person("Nacho", "Y Alan <3", 31)
    )

  }
  val mirtha = new Person("Mirtha", "Legrand", Integer.MAX_VALUE)
  def isOlderThan(n: Int)(p:Person): Boolean = p.age > n
  val isOlderThan30 = isOlderThan(30) _
  def isOlderThan50 = isOlderThan(50) _

  val people = generatePeople

  people.filter(person => person.itIsTrueThat((x:Person) => x.age > 30 )).foreach(person => println(person))

  println(mirtha.itIsTrueThat(isOlderThan30))
  println(mirtha.itIsTrueThat(isOlderThan50))
}
