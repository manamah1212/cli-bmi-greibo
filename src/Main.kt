import common.Client
import common.Constants.ADD_NEW_MESSAGE
import common.Constants.CLOSE_APP_MESSAGE
import common.Constants.ENTER_FIRST_NAME_MESSAGE
import common.Constants.ENTER_HEIGHT_MESSAGE
import common.Constants.ENTER_LAST_NAME_MESSAGE
import common.Constants.ENTER_WEIGHT_MESSAGE
import common.Constants.ENTER_YEAR_MESSAGE
import common.Constants.GREETING_MESSAGE
import common.Constants.INVALID_DATA_ERROR_MESSAGE
import common.Constants.SEPARATOR_MESSAGE
import common.Constants.SUCCESSFULLY_ADDED_TO_DB_MESSAGE
import common.clearScreen
import common.validateIfNotEmpty
import common.validateUserInput
import kotlin.system.exitProcess

fun main(){

}

/**
 * Gets data from user
 * @return Validated data in form of Client class
 */
fun inputHandler(): Client {
    var validData = false

    var userName = ""
    var userLastName = ""
    var userYear = ""
    var userWeight = ""
    var userHeight = ""

    while (!validData){
        //Greet user and collect info
        println(GREETING_MESSAGE)

        print(ENTER_FIRST_NAME_MESSAGE)
        //to kas user ierakstit
        userName = readLine().toString().trim()

        print(ENTER_LAST_NAME_MESSAGE)
        userLastName = readLine().toString().trim()

        print(ENTER_YEAR_MESSAGE)
        userYear = readLine().toString().trim()

        print(ENTER_WEIGHT_MESSAGE)
        userWeight = readLine().toString().trim()

        print(ENTER_HEIGHT_MESSAGE)
        userHeight = readLine().toString().trim()

        if (
            !validateIfNotEmpty(userName) ||
            !validateIfNotEmpty(userLastName) ||
            !validateUserInput(userYear,"Int") ||
            !validateUserInput(userHeight,"Double") ||
            !validateUserInput(userWeight,"Double")
        ){
            clearScreen()
            println(INVALID_DATA_ERROR_MESSAGE)
            println()
        }else {
            validData = true
        }

    }
    return Client(
        userName,
        userLastName,
        userYear.toInt(),
        userWeight.toDouble(),
        userHeight.toDouble()
    )
}

fun outputHandler(clientData: ArrayList<Client>){
    clearScreen()
    println(SUCCESSFULLY_ADDED_TO_DB_MESSAGE)
    println(SEPARATOR_MESSAGE)

    System.out.printf(
        "%-4s%-13s%-15s%-15s%-15s%-15s%-7s%-20s%-15s\n",
        "ID",
        "NAME",
        "LAST NAME",
        "BIRTH YEAR",
        "WEIGHT",
        "HEIGHT",
        "BMI",
        "BMI CATEGORY",
        "AGE"
    )

    clientData.forEachIndexed { index, client ->
        System.out.printf(
            "%-4s%-13s%-15s%-15s%-15s%-15s%-7s%-20s%-15s\n",
            index,
            client.firstName,
            client.lastName,
            client.year,
            client.weight,
            client.height,
            client.bmi,
            client.bmiCategory,
            client.age
        )
    }
    println(SEPARATOR_MESSAGE)

    println(ADD_NEW_MESSAGE)

    if (readLine().toString().trim() == "yes"){
        main()
    }else {
        closeApp()
    }
}

/**
 * Terminates app
 */
fun closeApp(){
    clearScreen()
    println(CLOSE_APP_MESSAGE)
    exitProcess(0)
}