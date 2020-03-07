package kotlinStudy
//히터 인터페이스
interface Heater {
    fun on()
    fun off()
    fun isHot(): Boolean
}
// 히터 인터페이스를 구현한 전기물끓이기
class ElectricHeater(var heating:Boolean = false) : Heater{
    override fun on() {
        println("ElectricHeater is heating water..Done")
        heating = true;
    }

    override fun off() {
        heating = false;
    }

    override fun isHot(): Boolean = heating
}

//펌프 인터페이스
interface Pump{
    fun pump()
}
//펌프 인터페이스를 구현한 열사이펀
class Thermosiphon(heater: Heater):Pump, Heater by heater{ //인터페이스를 타입으로 지정해둘 수 있음. 이를 구현한 클래스들은 모두 매개변수로 전달 가능
    override fun pump() {
        if(isHot()) println("[Thermosiphon] pumping...")
    }
}

//커피 모듈 인터페이스
interface CoffeeModule{
    fun getThermosiphon() : Thermosiphon
}
//커피 모듈 인터페이스를 상속받은 드립커피모듈 클래스
class MyDripModule: CoffeeModule{
    companion object{
        val electricHeater: ElectricHeater by lazy{ //lazy를 이용한 지연 초기화
            ElectricHeater()
        }
    }
    private val _thermosiphon : Thermosiphon by lazy{
        Thermosiphon(electricHeater) //Heater 인터페이스를 구현한 electricHeater 클래스의 인스턴스를 Heater인터페이스의 인스턴스를 필요로 하는 생성자의 매개변수에 전달할 수 있음
    }

    override fun getThermosiphon(): Thermosiphon = _thermosiphon //return _thermosiphon 이랑 같은거임!
}
//커피 모듈 인터페이스를 구현한 클래스의 인스턴스를 매개변수로 필요로 하는 클래스
class CoffeeMaker(val coffeeModule: CoffeeModule){
    fun brew(){
        val theSiphon: Thermosiphon = coffeeModule.getThermosiphon()
        theSiphon.on()
        theSiphon.pump()
        println("Wow! Coffee!")
        theSiphon.off()
    }
}

fun main() {
    val coffeeMaker = CoffeeMaker(MyDripModule())
    coffeeMaker.brew()
}