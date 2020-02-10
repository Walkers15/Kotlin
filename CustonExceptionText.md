#1 throw를 사용해 예외 발생시키기

```
fun main() {
    var amount = 600
    try{
        amount -= 100
        checkAmount(amount)
    } catch(e : Exception){
        println(e.message)
    }finally{
        println("finally 블록은 항상 실행된다")
    }
    println("Amount : $amount")
}
fun checkAmount(amount: Int) {
    if(amount < 1000) throw Exception("잔고가 $amount 로 1000원 이하입니다")
}
```

#2 사용자 정의 예외 클래스 만들어 보기
```
class InvalidNameException(message: String) : Exception(message)

fun main() {
    var name = "shoon__100"
    try{
        checkName(name)
    } catch(e: InvalidNameException){
        println(e.message)
    }
}
fun checkName(name: String){
    if(name.matches(Regex(".*\\d+.*")))//아름에 숫자가 포함되어 있으면 예외 발생
        throw InvalidNameException("Your Name : $name is Invalid >> Contains numerals.")
}
```
