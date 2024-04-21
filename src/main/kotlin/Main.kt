fun main() {
    println("How many questions do you want? ")
    val numberOfQuestions = readln()
    val quizSession = QuizSession(numberOfQuestions.toInt())
    quizSession.startQuiz()
}