import common.Client
import common.Constants.ABOVE_40_BMI_CATEGORY
import common.Constants.CALC_ERROR
import common.Constants.UNDER_16_BMI_CATEGORY
import common.Constants.UNDER_17_BMI_CATEGORY
import common.Constants.UNDER_19_BMI_CATEGORY
import common.Constants.UNDER_25_BMI_CATEGORY
import common.Constants.UNDER_30_BMI_CATEGORY
import common.Constants.UNDER_35_BMI_CATEGORY
import common.Constants.UNDER_40_BMI_CATEGORY
import java.time.LocalDateTime
import kotlin.math.pow
import kotlin.math.roundToInt

class UserCalculations(private var ourClient: Client) {





    fun getBMI(): Int{
        return (ourClient.weight / ourClient.height.pow(2)).roundToInt()
    }

    fun getAge(): Int{
    val current = LocalDateTime.now().toString().take(4).toInt()
        return current - ourClient.year
    }


    fun getBMIDescription():String{
        return  when (ourClient.bmi) {
            in 1..16 -> UNDER_16_BMI_CATEGORY
            in 16..17 -> UNDER_17_BMI_CATEGORY
            in 17..19 -> UNDER_19_BMI_CATEGORY
            in 19..25 -> UNDER_25_BMI_CATEGORY
            in 25..30 -> UNDER_30_BMI_CATEGORY
            in 30..35 -> UNDER_35_BMI_CATEGORY
            in 35..40 -> UNDER_40_BMI_CATEGORY
            in 40..100 -> ABOVE_40_BMI_CATEGORY
            else -> CALC_ERROR
        }
    }
}

