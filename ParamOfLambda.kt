package kotlinStudy
fun main(){
    noParam({"Hello, World!"})
    noParam{"Hello, World!"}
    oneParam({ a -> "Hello World! $a"})
    oneParam{a -> "Hello World! $a"}
    oneParam{"Hello World! $it"}//람다식 매개변수가 하나일 경우, 화살표 표기를 생략하고 it로 표현 가능
    moreParam{a,b -> "Hello, World! $a $b"}
    //moreParam{ _, b -> "Hello, World! $b"} //언더스코어로 사용하고 싶지 않은 매개변수 생략 가능
    withArgs("Arg1", "Arg2", {a,b -> "Hello, World! $a $b"})
    withArgs("Arg1","Arg2"){a,b -> "Hello, World! $a $b" }//마지막 인자가 람다식인 경우 분리 가능
    twoLambda({a,b -> "first is $a $b"},{"Second is $it"})
    twoLambda({a,b -> "first is $a $b"}){a -> "Second is $a"}
}
fun noParam(out: () -> String) = println(out())
fun oneParam(out: (String) -> String){
    println(out("OneParam"))
}
fun moreParam(out:(String, String) -> String){
    println(out("OneParam","TwoParam"))
}
fun withArgs(a: String, b: String, out: (String, String) -> String) = println(out(a,b))
fun twoLambda(first:(String, String)-> String, second:(String)->(String)){
    println(first("OneParam","TwoParam"))
    println(second("GotoBed"))
}
