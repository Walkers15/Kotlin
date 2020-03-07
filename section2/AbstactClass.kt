package kotlinStudy

//추상 클래스, 주 생성자에는 비추상 프로퍼티 선언의 매개변수 3개가 있음
abstract class Vehicle(val name: String, val color: String, val weight: Double) {
    //추상 프로퍼티_반드시 하위 클래스에서 재정의해 초기화해야 함
    abstract var maxSpeed: Double

    //일반 프로퍼티(초깃값인 상태를 저장할 수 있음)
    var year = "2018"

    //추상 메서드(반드시 하위 클래스에서 구현해야 함)
    abstract fun start()
    abstract fun stop()

    fun displaySpecs(){
        println("Name : $name, Color: $color, Weight: $weight, Year: $year, MaxSpeed: $maxSpeed")
    }
}

class Car(name: String, color: String, weight: Double, /*프로퍼티 재정의,초기화*/override var maxSpeed: Double):Vehicle(name, color, weight){
    //메소드 구현
    override fun start() {
        println("출발 부릉부릉")
    }
    //메소드 구현
    override fun stop() {
        println("장비를 정지합니다")
    }
}
//object 키워드를 사용하면 추상 클래스로부터 하위 클래스 없이 단일 인스턴스로 객체를 선언할 수 있음
val MyVehicle = object: Vehicle("Ogu","White&pink",1000.0){
    override var maxSpeed = 1100.0 //추상 프로퍼티 값 초기화
    override fun start() {//추상 메서드의 구현
        println("오구 출동!")
    }
    override fun stop() {//추상 메서드의 구현
        println("오구 복귀!")
    }
}

fun main() {
    var car = Car("MatizWalWal","DeepBlack",1110.0,270.0)
    car.year = "20100"
    car.displaySpecs()
    MyVehicle.displaySpecs() //추상 클래스의 object키워드를 사용한 단독 인스턴스화
}