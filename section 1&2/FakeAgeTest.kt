class FakeAge {

    var age: Int = 0
    var fake : Int = 0
    get(){//fake의 커스텀 게터
        when(this.age){//같은 클래스 내의 age프로퍼티 참고
            in 1 .. 17 -> return 18
            in 18..30 -> return this.age
            else -> return (this.age - 3)
        }
    }
}
fun main() {
    val kim = FakeAge()
    kim.age = 18
    //kim.fake를 get할 때 커스텀 게터 사용
    println("Kim's real age = ${kim.age}, pretended age = ${kim.fake}")
    val baek = FakeAge()
    baek.age = 35
    //baek.fake를 get할 때 커스텀 게터 사용
    println("Baek's real age = ${baek.age}, pretended age = ${baek.fake}")
}
