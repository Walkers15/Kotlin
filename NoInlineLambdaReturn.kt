package kotlinStudy

fun main() {
    retFunc()
}

fun inlineLambda(a: Int, b:Int, out:(Int, Int)-> Unit){
    out(a,b)
}

fun retFunc(){
    println("Start of retFunc")
    inlineLambda(13,3) lit@{ a,b ->
        val result = a + b
        if(result > 10) return@lit //return을 이용하면, 라벨을 사용한 블록의 끝부분으로 반환됨
        //즉, 흐름이 블록 바깥으로 나가서 다시 진행
        println("result : $result")
    }
    println("end of retFunc")
}
/*     Result     */
/*Start of retFunc*/
/*end of retFunc  */