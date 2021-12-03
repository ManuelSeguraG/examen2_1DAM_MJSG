import kotlin.math.sqrt
import kotlin.math.pow

class Punto(var id: String) {
    var x: Int = 0
    var y: Int = 0

    constructor(id: String, _x: Int, _y: Int) : this(id) {
        x = _x
        y = _y
    }

    fun obtenerCoordenadas(): Pair<Int, Int> = Pair(x, y)

    override fun toString(): String {
        return "punto <$id> -> [<$x>,<$y>]"
    }

    companion object {
        fun componenteDeVector(pA: Punto, pB: Punto): Punto {
            var puntoAmenosB = Punto ("${pA.id}${pB.id}", pB.x.minus(pA.x), pB.y.minus(pA.y))
            return puntoAmenosB
        }

        fun distancia(pA: Punto, pB: Punto): Double = TODO()
    }
}

fun main() {
    var puntoA = Punto("pA", 3, 2)
    var puntoB = Punto("pb", 2, 1)

    println(Punto.componenteDeVector(puntoA, puntoB))
}