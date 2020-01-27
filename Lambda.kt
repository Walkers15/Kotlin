package kotlinStudy
#1
fun main() {
    val result = callByName(otherLambda)
    println(result);
}


fun callByName(b: ( ) -> Boolean): Boolean { // 람다식 자료형 b: () -> Boolean 으로 선언된 매개변수
    println("fun callByName")
    return b() //여기서 함수 호출, 이때 되서야 람다 함수 실행
}

val otherLambda: () -> Boolean = {
    println("Lambda Function")
    true
}


#2
fun main() {
    val result = callByName(lambda()) //람다식 함수를 호출
    println(result);
}


fun callByName(b: Boolean): Boolean { //일반 변수 자료형(Boolean)으로 선언된 매개변수
    println("fun callByName")
    return b //일반 변수 자료형 반환
}


val lambda: () -> Boolean = {
    println("Lambda Function")
    true
}

