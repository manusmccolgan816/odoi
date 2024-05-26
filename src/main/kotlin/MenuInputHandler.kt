class MenuInputHandler {

    fun getNumberOfQuestions(): Int {
        var userInput: String

        while (true) {
            println("How many questions do you want? ")
            userInput = readln()

            if (isValidNumberOfQuestions(userInput)) {
                return userInput.toInt()
            }
            println(INVALID_NUMBER_OF_QUESTIONS_MESSAGE)
        }
    }

    private fun isValidNumberOfQuestions(numberOfQuestions: String): Boolean {
        return isInt(numberOfQuestions) && numberOfQuestions.toInt() <= MAX_NUMBER_OF_QUESTIONS
    }

    private fun isInt(toCheck: String): Boolean {
        return toCheck.toIntOrNull() != null
    }

    companion object {
        private const val MAX_NUMBER_OF_QUESTIONS = 100
        const val INVALID_NUMBER_OF_QUESTIONS_MESSAGE =
            "You must enter a whole number with a max value of $MAX_NUMBER_OF_QUESTIONS"
    }
}