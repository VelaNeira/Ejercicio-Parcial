// Clase Elecciones que maneja el sistema de votación
class Elecciones(val candidatos: List<Candidato>) {

    // Método para votar por un candidato usando el número
    fun votarCandidato(numeroCandidato: Int, medio: Int) {
        val candidato = candidatos.getOrNull(numeroCandidato - 1)
        if (candidato != null) {
            candidato.votar(medio)
        } else {
            println("Número de candidato no válido.")
        }
    }

    // Método para calcular el costo de campaña de un candidato específico usando el número
    fun calcularCostoCampaña(numeroCandidato: Int): Int? {
        return candidatos.getOrNull(numeroCandidato - 1)?.calcularCostoCampana()
    }

    // Método para vaciar todas las urnas
    fun vaciarUrnas() {
        candidatos.forEach {
            it.votosInternet = 0
            it.votosRadio = 0
            it.votosTV = 0
        }
    }

    // Método para obtener el número total de votos de todos los candidatos
    fun totalVotos(): Int {
        return candidatos.sumOf { it.totalVotos() }
    }

    // Método para obtener el porcentaje de votos de cada candidato
    fun porcentajeVotos(): Map<String, Double> {
        val totalVotos = totalVotos()
        return if (totalVotos > 0) {
            candidatos.associate { it.nombre to (it.totalVotos().toDouble() / totalVotos) * 100 }
        } else {
            candidatos.associate { it.nombre to 0.0 }
        }
    }

    // Método para calcular el costo promedio de campaña en las elecciones
    fun costoPromedioCampana(): Double {
        return candidatos.sumOf { it.calcularCostoCampana() }.toDouble() / candidatos.size
    }

    // Método para obtener al candidato ganador (con más votos)
    fun obtenerGanador(): Candidato? {
        return candidatos.maxByOrNull { it.totalVotos() }
    }
}