import java.io.File

fun main() {
    val a1: MutableList<Long> = ArrayList()
    val a2: MutableList<Long> = ArrayList()
    var i = 0
    val inputOutFileName = "d_quite_big"

    File("$inputOutFileName.in").forEachLine { line ->
        when (i) {
            0 -> {
                line.split(" ").forEach {
                    a1.add(it.toLong())
                }
            }
            else -> {
                line.split(" ").forEach {
                    a2.add(it.toLong())
                }
            }
        }
        i++
    }

    var pizzaCounter = 0
    var sum : Long = 0
    var position = ""

    for (j in a2.size - 1 downTo 0) {
        if (sum + a2[j] <= a1[0]) {
            sum += a2[j]
            position = "$j $position"
            pizzaCounter++
        }
    }

    val output = File("$inputOutFileName.out")
    output.writeText("$pizzaCounter\n$position")
}