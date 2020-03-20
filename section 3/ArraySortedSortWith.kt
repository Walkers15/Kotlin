package kotlinStudy

fun main() {
    val products = arrayOf(
            Product("CoCoball", 870.00),
            Product("iPhone", 1111.11),
            Product("Galaxy", 1231.125),
            Product("Salad", 220.00),
            Product("Fish", 1.toDouble())
    )
    products.sortWith(
            Comparator<Product> { p1, p2 ->
                when {
                    p1.price > p2.price -> 1
                    p1.price == p2.price -> 0
                    else -> -1
                }
            }
    )
    products.forEach{ println(it) }
}