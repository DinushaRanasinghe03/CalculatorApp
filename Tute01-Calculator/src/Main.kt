fun main(){
    println("Enter number 1=")
     val number1= readln()

    println("Enter number 2=")
    val number2= readln()

    println("Enter Operation=")
    val operator= readln()

    println("Output = ${calculate(number1.toFloat(),number2.toFloat(),operator)}")
}
fun calculate(n1:Float, n2:Float, o:String):Float{
    return when(o){
        "+"->n1+n2
        "-"->n1-n2
        "*"->n1*n2
        "/"->n1/n2
        else->-1.0f
    }
}