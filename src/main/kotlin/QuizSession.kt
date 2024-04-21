
class QuizSession(
    private val numberOfQuestions: Int,
) {

    fun startQuiz() {
        doCountdown()
    }

    private fun doCountdown() {
        val quizStartText = "Quiz starting in 3..."
        print(quizStartText)
        Thread.sleep(1000)
        print("2...")
        Thread.sleep(1000)
        print("1...")
        Thread.sleep(1000)
    }
}