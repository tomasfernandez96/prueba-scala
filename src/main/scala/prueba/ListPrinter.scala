package prueba

class ListPrinter {

  def printHead(list: List[Any] = List("Pelotudo", "Cargame", "Una Lista")): Unit = {
    if(list.isEmpty) return
    println(list.head)
    printHead(list.tail)
  }

  def printFunction(string: String, expression: Any) = {
    println(s"Se ejecuta el metodo: $string $expression")
  }

  override def toString: String = "ListPrinter: {}"

}
