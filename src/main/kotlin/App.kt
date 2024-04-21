class App {

    private val menuInputHandler: MenuInputHandler = MenuInputHandler()

    fun start() {
        val numberOfQuestions = menuInputHandler.getNumberOfQuestions()
        val quizSession = QuizSession(numberOfQuestions)
        quizSession.startQuiz()
    }
}