import jdk.nashorn.internal.objects.NativeMath.pow
import kotlin.math.sqrt

// CLASE DELO EXAMEN
class Punto(var id: String) {
    var x: Int = 0
    var y: Int = 0

    // Constructor secundario de la clase, donde se dan los valores X e Y
    constructor(id: String, _x: Int, _y: Int) : this(id) {
        x = _x
        y = _y
    }

    // Funcion que da las coordenadas de un punto
    fun obtenerCoordenadas(): Pair<Int, Int> = Pair(x, y)

    // Sobreescritura de la funcion toString, para que devuelva el id y las coordenadas del punto
    override fun toString(): String {
        return "punto $id -> [$x,$y]"
    }

    // Funciones de la clase (metodos estaticos)
    companion object {

        // Toma dos puntos, puntoA y puntoB, y resta puntoA a PuntoB
        fun componenteDeVector(pA: Punto, pB: Punto): Punto {
            val puntoAmenosB = Punto ("${pA.id}${pB.id}", pB.x.minus(pA.x), pB.y.minus(pA.y))
            return puntoAmenosB
        }

        // Realiza la distancia de las coordenadas X e Y de los puntos puntoA y puntoB, que son los que recibe.
        // El calculo es la Raiz Cuadrada de las potencias de X e Y
        // Devuelve un Double.
        fun distancia(pA: Punto, pB: Punto): Double {
            val raizPuntoAyPuntoB: Double = sqrt(pow("", pA.x, pB.x) + pow("", pA.y, pB.y))
            return raizPuntoAyPuntoB
        }

        // Toma un array de coordenadas y separa estas coordenadas en dos listas
            // listaPuntosNorte: Los puntos están en 0 o son superiores que 0 (en la coordenada Y)
            // listaPuntosSur: Los puntos están por debajo de 0 (en la coordenada Y)
        // Despues estas listas son unidas en un map, que tiene como clave "Norte" y "Sur"
        // Cada una de las listas es añadida en su respectiva clave
        fun localizacionGeograficaNS(arrayPuntos: Array<Punto> ): Map< String, List<Punto> >{
            val mapaLocalizaciones = mutableMapOf< String, List<Punto> >()
            val listaPuntosNorte = mutableListOf<Punto>()
            val listaPuntosSur = mutableListOf<Punto>()

            for (i in 0..arrayPuntos.size - 1){

                if (arrayPuntos[i].y >= 0) {
                    listaPuntosNorte.add(arrayPuntos[i])
                } else {
                    listaPuntosSur.add(arrayPuntos[i])
                }

            }

            mapaLocalizaciones.put("Norte", listaPuntosNorte)
            mapaLocalizaciones.put("Sur", listaPuntosSur)

            return mapaLocalizaciones

        }
    }
}

fun main() {
    val puntoA = Punto("pA", 3, 2)
    val puntoB = Punto("pB", 1, 3)

    println(Punto.componenteDeVector(puntoA, puntoB))
    println(Punto.distancia(puntoA, puntoB))

    println("")
    println("----------------------------------------------------------------")
    println("")

    val punto1 = Punto("p1", -1, 0)
    val punto2 = Punto("p2", 3, -1)
    val punto3 = Punto("p3", -4, 4)
    val punto4 = Punto("p4", -3, 2)
    val punto5 = Punto("p5", 6, -4)
    val punto6 = Punto("p6", -5, 6)
    val punto7 = Punto("p7", 10, -8)
    val punto8 = Punto("p8", 1, 5)
    val punto9 = Punto("p9", 6, -7)
    val arrayLocalizaciones: Array<Punto> = arrayOf(punto1, punto2, punto3, punto4, punto5, punto6, punto7, punto8, punto9)

    println(Punto.localizacionGeograficaNS(arrayLocalizaciones))
}