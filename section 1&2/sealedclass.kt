package kotlinStudy

//실드 클래스를 선언하는 방법 1
sealed class Result {
    open class Success(val message: String): Result()
    class Error(val code: Int, val message: String): Result()
}
class Status: Result()
class Inside: Result.Success("Good!")

//실드 클래스를 선언하는 방법 2
sealed class Sealed

open class Protect(val message: String): Sealed()
class Error(val code: Int, val message: String): Sealed()

class Status_2: Sealed()
class Inside_2: Protect("지키는 중")

fun main() {
    val result = Result.Success("Good!")
    val msg = eval(result)
    println(msg)
}

fun eval(result: Result): String = when(result){
    is Status -> "실행중"
    is Result.Success -> result.message
    is Result.Error -> result.message
}
