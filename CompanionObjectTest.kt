package kotlinStudy

class Person {
    var id: Int = 0
    var name : String = "Hoon"
    companion object {
        var language = "Korean"
        fun work(){
            println("Now Working...")
        }
    }
}

fun main() {
    var ps = Person()
    // println(ps.language) 불가능! 컴패니언 객체 안에서 생성한 프로퍼티와 메소드들은, 클래스 이름으로만 접근 가능
    ps.name = "Joon"
    println(Person.language)
    println(ps.name)
    Person.work()
    //Person.name = "Kim" 불가능! 한 클래스 안이더라도, 컴패니언 객체 안에 있지 않은 것들은 클래스명으로 접근 불가능
    Person.language = "Italian" //변경 가능
    println(Person.language)


}