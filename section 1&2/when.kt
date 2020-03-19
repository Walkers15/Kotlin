#1
인자가 있는 when

fun main() {
    print("점수를 입력해 주세요 : ")
    val score = readLine()!!.toDouble()
    var grade = 'F' //초기화해주지 않으면, 출력에서 이용할 수 없음
    when(score){
        in 90.0 .. 100.0 -> grade = 'A'
        in 80.0 .. 89.9 -> grade = 'B'
        in 70.0 .. 79.9 -> grade = 'C'
        !in 70.0 .. 100.0 -> grade = 'F'//70 미만 혹은 100초과(!in)
    }
    println("$score 점의 점수를 받은 학생의 등급은 $grade 입니다")
}

#2
인자가 없는 when

fun main() {
    print("점수를 입력해 주세요 : ")
    val score = readLine()!!.toDouble()
    var grade = 'F'
    when{
        score >= 90.0 -> grade = 'A'//인자 있는 when문과 다르게, 조건식(score >= 90.0)을 구성할 수 있음
        score in 80.0 .. 89.9 -> grade = 'B'
        score in 70.0 .. 79.9 -> grade = 'C'
        score < 70.0 -> grade = 'F'//여기도 조건식
    }
    println("$score 점의 점수를 받은 학생의 등급은 $grade 입니다")
}
 
