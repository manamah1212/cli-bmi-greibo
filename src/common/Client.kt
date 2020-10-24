package common

data class Client (
    var firstName: String,
    var lastName: String,
    var year: Int,
    var weight: Double,
    var height: Double,
    var bmi: Int? = null,
    var age:Int? = null,
    var bmiCategory: String? = null
)