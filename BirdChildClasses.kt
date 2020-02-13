package kotlinStudy

//상속 가능한 클래스를 선언하기 위해 open 사용
open class Bird(var name: String, var wing: Int, var beak: String, var color: String){
    fun fly() = println("Fly Wing: $wing")
    fun sing(vol : Int) = println("Sing a song : $vol")
}
//주 생성자를 사용하는 상속
class Lark(name: String, wing: Int, beak: String, color: String) :Bird(name, wing, beak, color){
    fun singHitone() = println("Happy Song!");
}

//부 생성자를 사용하는 상속
class Parrot : Bird {
    val language: String
    constructor(name: String,
                wing: Int,
                beak: String,
                color: String,
                language: String) : super(name, wing, beak, color){
        this.language = language
    }
    fun speak() = println("I can speak $language!")
}

fun main() {
    val coco = Bird("myBird",2,"short","yellogreen")
    val lark  = Lark("myLark",386,"long","violet")
    val parrot = Parrot("myParrot",2718,"short","multiple","korean")
    println("Coco: ${coco.name}, ${coco.wing}, ${coco.beak}, ${coco.color}")
    println("Lark: ${lark.name}, ${lark.wing}, ${lark.beak}, ${lark.color}")
    lark.singHitone()
    parrot.speak()
    lark.fly()
}