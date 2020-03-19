package kotlinStudy

import kotlin.properties.Delegates


#1
observable()을 이용한 프로퍼티 값 변화 감시
변화가 생기면 람다식 안에 작성된 이벤트 부분 실행
class User{
    var name: String by Delegates.observable("Noname"){//프로퍼티 위임, 초기값 Noname
        property, oldValue, newValue -> //람다식 매개변수로 프로퍼티 값, 이전 값, 새로운 값 전달
        println("$oldValue -> $newValue")//이벤트가 발생할 때만 실행(콜백)
    }
}

fun main() {
    val user = User()
    user.name = "Hoon"
    user.name = "Alice"
}


#2
vetoable() 을 이용한 프로퍼티 값 할당 조건 검사
람다식 안에 제시된 조건에 맞지 않으면, 프로퍼티에 값을 할당해주지 않음

fun main() {
    var max: Int by Delegates.vetoable(0){
        property, oldValue, newValue ->
        newValue > oldValue
    }
    println(max) // 0
    max = 10
    println(max) // 10
    max = 5 //vetoable의 조건이 이전 값 < 입력 값이므로 false. 따라서 5를 재할당하지 않음
    println(max) // 10
}
