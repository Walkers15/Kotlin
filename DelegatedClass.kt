package study.kotlin

interface Car {
    fun go( ): String
}

class VanImpl(val power: String): Car{
    override fun go( ) = "은 짐을 적재하며 $power 을 가집니다."
}
class SportImpl(val power: String): Car {
    override fun go(): String {
        return "은 경주용에 사용되며 $power 을 가집니다."
    }
}
//by 를 사용하여 CarModel 클래스의 객체에 Car 클래스의 impl객체의 멤버들을 위임함
//따라서, go() 메소드를 Car의 impl객체를 명시적으로 참조하지 않고도 호출 가능
class CarModel(val model: String, impl: Car): Car by impl {
    fun carInfo(){
        println("$model ${go()}")
    }
}
fun main() {
    val myDamas = CarModel("Damas 2010", VanImpl("100마력"))
    val my350z = CarModel("350Z 2008", SportImpl("350 마력"))
    myDamas.carInfo()
    my350z.carInfo()
}