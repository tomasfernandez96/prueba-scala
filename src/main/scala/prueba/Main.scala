package prueba

object Main extends App {

  def flip[A,B,C](f:(A,B) => C): (B,A) => C = (b,a) => f(a,b)

  println(Calculator.substract(10,5))
  println(flip(Calculator.substract).apply(10,5))

  def f = () => "Hola"

  println(f())
  println(f)


}
