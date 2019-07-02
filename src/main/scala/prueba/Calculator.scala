package prueba

import scala.annotation.tailrec

object Calculator extends App{

  val areasTuple = List((1,2),(2,3),(4,5), (6,7))

  def area(width:Int = 1, height:Int = 1) = width * height

  def getAreasString(list: List[(Int,Int)]) = {
    list.map{ case (height,width) => (s"Heigth = $height", s"Width = $width",
      s"Area = ${Calculator.area(height,width)}")}
  }

  def sum(a:Int, b:Int):Int = a+b
  def substract(a:Int, b:Int):Int = a-b

  def factorial(a:Int): Int = if(a <= 1) 1 else a * factorial(a-1)

  def binaryFactorial: Int => String = factorial _ andThen toBinary

  def toBinary: Int => String = toBase (2)

  def toOctal: Int => String = toBase (8)

  def toHexa: Int => String = toBase (16)

  def toBase: Int => Int => String = toBaseImpl ("")

  @tailrec
  def toBaseImpl(initialString: String)(base:Int)(number:Int):String = {
    if(number equals 0) initialString
    else toBaseImpl (stringNumber(number % base).concat(initialString)) (base) (number/base)
  }

  def stringNumber(n:Int):String = {
    val hashMap = (10 to 35).map( n  => n -> ('a' + n - 10 ).toChar.toString).toMap

    if (n < 10 && n >= 0) n.toString
    else hashMap.getOrElse(n,"")
  }

  def toBinaryPiola (n:Int): String = if(!n.equals(0)) toBinaryPiola(n/2) + (n%2) else ""

  def printNumber:Int => Unit = print _ compose toBase (10)

  def testToBaseString(referenceNumber: Int) = {
    assert(toBinary(referenceNumber)  equals  Integer.toBinaryString(referenceNumber))
    assert(toOctal(referenceNumber)   equals  Integer.toOctalString(referenceNumber))
    assert(toHexa(referenceNumber)    equals  Integer.toHexString(referenceNumber))
    assert(toBase (36) (389)          equals  "at")
    assert(toBase (36) (Integer.MAX_VALUE) equals "zik0zj")
  }

  testToBaseString(123456789)
  println(toBinary (Integer.MAX_VALUE))
  println(toOctal (Integer.MAX_VALUE))
  println(Integer.MAX_VALUE)
  println(toHexa (Integer.MAX_VALUE))
  print(toBase (36) (Integer.MAX_VALUE))

}
