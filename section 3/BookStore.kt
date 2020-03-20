package kotlinStudy

import java.util.*

fun main() {
    val booksName = arrayOf("java", "c", "c++", "kotlin", "c#", "html")
    val sc = Scanner(System.`in`)
    var loop = true
    val price = 200
    while(loop) {
        print("어떤 책을 원하시나요? : ")
        val find = sc.nextLine()
        if (booksName.contains(find.toLowerCase())) {
            print("당신의 직업은 무엇입니까?: ")
            val job = sc.nextLine().toLowerCase()
            when (job) {
                "student" -> println("15% 할인하여 가격은 ${(price) * 0.85}\$입니다")
                "teacher" -> println("15% 할인하여 가격은 ${(price) * 0.85}\$입니다")
                else -> print("가격 할인을 지원하지 않는 직업입니다.\n가격은 ${price}\$입니다\n")
            }
        }else if(find == "q" || find == "exit"){
            println("안녕히 가세요")
            loop = false
        }else println("그런 책은 없슴다")
    }

}