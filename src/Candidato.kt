class Candidato(val nombre: String) {
    var votosInternet = 0
    var votosRadio = 0
    var votosTV = 0

    // Método para sumar un voto según el medio de influencia
    fun votar(medio: Int) {
        when (medio) {
            1 -> votosInternet++
            2 -> votosRadio++
            3 -> votosTV++
            else -> println("Medio de influencia no reconocido.")
        }
    }

    // Método para calcular el costo total de la campaña basado en los votos y su influencia
    fun calcularCostoCampana(): Int {
        val costoInternet = votosInternet * 700000  // Costo por los votos de Internet
        val costoRadio = votosRadio * 200000        // Costo por los votos de radio
        val costoTV = votosTV * 600000              // Costo por los votos de televisión

        return costoInternet + costoRadio + costoTV
    }

    // Método para obtener el número total de votos del candidato
    fun totalVotos(): Int {
        return votosInternet + votosRadio + votosTV
    }
}