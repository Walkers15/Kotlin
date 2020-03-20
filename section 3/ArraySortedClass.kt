package kotlinStudy

data class Product(val name: String, val price: Double)

fun main() {
    val products = arrayOf(
            Product("CoCoball",870.00),
            Product("iPhone",1111.11),
            Product("Galaxy", 1231.125),
            Product("Salad", 220.00),
            Product("Fish", 1.toDouble())
    )
    products.sortBy{ it.price }
    //sortedBy를 사용하면 새로 생성한 배열에 저장하는 것으므로 원본 배열이 정렬되지 않음.
    //sortBy를 사용할 때만 원본 배열 정렬

    //print(products.contentToString())
    products.forEach{ println(it) }
}