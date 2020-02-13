package kotlinStudy

//상속 가능한 클래스를 선언하기 위해 open 사용
open class Bird(var name: String, var wing: Int, var beak: String, var color: String){
    fun fly() = println("Fly Wing: $wing")
    open fun sing(vol : Int) = println("Sing a song : $vol")
}

//부 생성자를 사용하는 상속
class Parrot (name: String,
      wing: Int,
      beak: String,
      color: String,//마지막 인자만 var로 선언되어 프로퍼티가 추가되었음을 알 수 있음
      var language: String = "natural") : Bird(name, wing, beak, color){

    fun speak() = println("I can speak $language!")
    override fun sing(vol: Int) {
        println("I'm a Parrot! The volume level is $vol")
        speak() //달라진 내용 클래스 안의 메소드를 다른 메소드에서도 사용할 수 있음
    }
}

fun main() {
    val coco = Bird("myBird",2,"short","yellogreen")
    val parrot = Parrot("myParrot",2718,"short","multiple","korean")
    println("Coco: ${coco.name}, ${coco.wing}, ${coco.beak}, ${coco.color}")
    println("Parrot: ${parrot.name},${parrot.wing},${parrot.beak},${parrot.color},${parrot.language}")
    parrot.sing(5) //달라진 메서드 실행 가능
}