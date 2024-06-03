import org.litote.kmongo.KMongo

class App {

    private val menuInputHandler = MenuInputHandler()
    private val dbConnector = DbConnector()

    fun start() {
        val numberOfQuestions = menuInputHandler.getNumberOfQuestions()
        val quizSession = QuizSession(numberOfQuestions, dbConnector)
        quizSession.startQuiz()
    }
}