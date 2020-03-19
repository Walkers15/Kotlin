package kotlinStudy
/*
확장함수
기존 클래스의 멤버 메소드는 아니지만, 기존의 클래스에 내가 원하는 함수를 하나 더 포함시켜 확장사용을 하고 싶을 때 이용하는 개념
fun 확장 대상.함수 이름(매개변수, ...): 반환값 {
  ...
  return 값
} 의 형태로 사용함
String 클래스에 매소드를 추가하는 방법
기존의 표준 라이브러리를 수정하지 않고도 확장할 수 있음
 */
fun main() {
    val source = "Hello, World!"
    val target = "Kotlin"
    println(source.getLongString(target))
}

fun String.getLongString(target : String) : String =
        if(this.length > target.length) this else target