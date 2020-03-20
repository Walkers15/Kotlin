package kotlinStudy

open class Animal(val size: Int){
    fun feed() = println("feeding..")
}

class Cat(val jump: Int): Animal(50)
class Spider(val poison : Boolean): Animal(1)

//형식 매개변수(T)를 Animal로 제한
class Box<out T: Animal>(val element: T){
    fun getAnimal(): T = element //out은 반환 자료형에만 사용할 수 있음
//  fun set(new: T){ //오류! T는 in 위치에 사용할 수 없음
//      element = new
//  }
}

fun main() {
    val c1: Cat = Cat(10)
    val s1: Spider = Spider(true)

    var a1: Animal = c1 //클래스의 상위 자료형으로 변환, OK
    a1 = s1 //OK
    println(a1.size) //a1은 spider가 되었으므로 출력값은 1

    val c2: Box<Animal> = Box<Cat>(Cat(10)) //공변성(out), Cat은 Animal의 하위 자료형
    println(c2.element.size)

  /*  val c3: Box<Cat> = Box<Animal>(10) //하-상 관계는 인스턴스화 불가
    val c4: Box<Any> = Box<Int>(10) 자료형 제한(out T: Animal) 때문에 Animal과 하위 클래스 이외에는 인스턴스화 불가능*/

}