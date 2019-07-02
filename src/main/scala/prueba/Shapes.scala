package prueba

object Shapes extends App{

  new SquareAbs("Red").draw()
  new SquareTrait("Blue").draw()

  abstract class ShapeAbs(val color:String){
    def draw():Unit = println(color)
  }
  trait ShapeTrait {
    def color: String
    def draw(): Unit = println(s"Color is: $color")
  }
  class SquareAbs(color:String) extends ShapeAbs(color) {
  }
  class SquareTrait(val color: String) extends ShapeTrait {
  }

}
