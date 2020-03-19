package kotlinStudy

open class A {
    open fun f() = println("A class f()")
    fun a( ) = println("A Class a( )")
}
interface B {
    //인터페이스는 기본적으로 open이다.
    fun f( ) = println("B interface f( )")
    fun b( ) = println("B interface b( )")
}
//A 클래스와 B 인터페이스에서 함수 f의 이름이 중복되므로, f를 반드시 오버라이딩 해야 함.
class C : A(), B{
    override fun f() = println("C class f ()")
    fun test(){
        f()
        b()
        super<A>.f() //앵글 브레킷 사용, A 표현
        super.a()
        super.b()//상속받은 메소드중 중복되는 이름이 없다면, 그냥 사용 가능
        super<B>.f()//앵글 브레킷 사용, B 표현
    }
}
fun main(){
    val c = C()
    c.test()

}