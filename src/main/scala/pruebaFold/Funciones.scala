package pruebaFold

object Funciones extends App{

  // Ejercicio 1
  def toPhrase: List[String] => String =
    _.reduceLeft{(accum,elem) => accum + ", " + elem}

  // Ejercicio 2
  def reverseCaserito[A]: List[A] => List[A] =
    _.foldLeft(Nil:List[A]){(accum,element) => element :: accum}

  // Ejercicio 3
  def partitionCaserito[A] (condition: A => Boolean) (list:List[A]):(List[A], List[A]) =
    (list.filter(condition), list.filterNot(condition))

  // Ejercicio 4
  def compressCaserito[A]: List[A] => List[A] =
    _.foldRight(Nil:List[A]){(elem, accum) => if(accum.nonEmpty && (accum.head equals elem)) accum else elem :: accum}

  def test(): Unit ={

    val stringsList = List("Hola","Manola","Chupame","Las","Bolas")

    // Ejercicio 1
    val phrase = toPhrase(stringsList)
    println(phrase)
    assert(phrase equals "Hola, Manola, Chupame, Las, Bolas")

    // Ejercicio 2
    val reversedList = reverseCaserito(stringsList)
    println(reversedList)
    assert(reversedList equals List("Bolas","Las","Chupame","Manola","Hola"))

    // Ejercicio 3
    val intList = (1 to 10).toList
    val condition = {x:Int => x%2 == 0}
    val partitedList = partitionCaserito (condition) (intList)
    println(partitedList)
    assert(partitedList equals (List(2,4,6,8,10),List(1,3,5,7,9)))
    assert(partitedList equals intList.partitionCaserito(condition))

    // Ejercicio 4
    val repetedList = List('a', 'a', 'b', 'b', 'c','a','a')
    val withoutRepetedList = compressCaserito(repetedList)
    println(withoutRepetedList)
    assert(withoutRepetedList  equals  List('a','b','c','a'))
    assert(withoutRepetedList  equals repetedList.compressCaserito)
  }

  // Ejercicios en una clase implicita
  // Cris no le des bola
  implicit class listaOp[A](list:List[A]) {

    // Ejercicio 2
    def reverseCaserito: List[A] =
      list.foldRight(Nil:List[A]){(element,accum) => accum.appended(element)}

    // Ejercicio 3
    def partitionCaserito (condition: A => Boolean):(List[A], List[A]) =
      (list.filter(condition), list.filterNot(condition))

    // Ejercicio 4
    def compressCaserito: List[A] =
      list.foldLeft(Nil:List[A]){(accum, elem) => if(accum.nonEmpty && (accum.last equals elem)) accum else accum.appended(elem)}
  }

  test()
}
