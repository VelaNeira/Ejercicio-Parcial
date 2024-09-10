fun main() {
    var estado = true
    // Lista de candidatos
    val candidato1 = Candidato("carlos")
    val candidato2 = Candidato("pepe")
    val candidato3 = Candidato("andres")

    val elecciones = Elecciones(listOf(candidato1, candidato2, candidato3))

    println("Bienvenido al programa de votos premium")
    do {
        println("*----------------------------------------------------------------------------------------------------------*")
        println("Menú de opciones: ")
        println("\n1- Votar por el candidato de su elección.")
        println("2- Calcular el costo de campaña de un candidato dependiendo de la influencia publicitaria de cada voto.")
        println("3- Vaciar todas las urnas de la votación.")
        println("4- Conocer el número total de votos.")
        println("5- Porcentaje de votos obtenidos por cada candidato.")
        println("6- Costo promedio de campaña en las elecciones.")
        println("7- Conocer al candidato ganador.")
        println("8- Salir")
        println("*----------------------------------------------------------------------------------------------------------*")
        print("\nElija la opción que desea realizar: ")
        val op: Int = readln().toInt()

        when (op) {
            1 -> {
                // Opción para votar por un candidato
                println("\nCandidatos: ")
                println("   1- Carlos")
                println("   2- Pepe")
                println("   3- Andres")

                print("\nIngrese el número del candidato: ")
                val numeroCandidato = readln().toInt()

                // Ingresar el medio por el que votó
                println("Medios por los cuales se enteró: ")
                println("   1- Internet.")
                println("   2- Radio.")
                println("   3- TV.")
                print("\nIngrese el número del medio de influencia: ")
                val medio = readln().toInt()

                // Registrar el voto
                elecciones.votarCandidato(numeroCandidato, medio)
                println("¡Voto registrado!")
            }
            2 -> {
                // Opción para calcular el costo de campaña de un candidato
                print("\nIngrese el número del candidato para calcular el costo de campaña (1, 2 o 3): ")
                val numeroCandidato = readln().toInt()
                val costo = elecciones.calcularCostoCampaña(numeroCandidato)

                // Validar si existe
                if (costo != null) {
                    println("El costo de campaña para el candidato $numeroCandidato es: $costo")
                } else {
                    println("El candidato no fue encontrado.")
                }
            }
            3 -> {
                // Opción para vaciar todas las urnas
                elecciones.vaciarUrnas()
                println("\n¡Las urnas han sido vaciadas!")
            }
            4 -> {
                // Opción para conocer el número total de votos
                println("\nTotal de votos: ${elecciones.totalVotos()}")
            }
            5 -> {
                // Opción para conocer el porcentaje de votos obtenidos por cada candidato
                println("\nPorcentaje de votos por candidato: ${elecciones.porcentajeVotos()}")
            }
            6 -> {
                // Opción para conocer el costo promedio de campaña
                println("\nCosto promedio de campaña: ${elecciones.costoPromedioCampana()}")
            }
            7 -> {
                // Opción para conocer al candidato ganador
                val ganador = elecciones.obtenerGanador()

                if (ganador != null) {
                    println("\nEl candidato ganador es: ${ganador.nombre}")
                } else {
                    println("\nNo hay suficientes votos para determinar un ganador.")
                }
            }
            8 -> {
                // Opción para salir
                println("\nSaliendo del sistema...")
                estado = false
            }
            // Manejo de errores si selecciona una opción inválida en el menú principal.
            else -> println("\nOpción inválida, vuelva a seleccionar de nuevo.")
        }
    } while (estado)
}