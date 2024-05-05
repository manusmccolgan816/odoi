import kotlin.random.Random

class QuizSession(
    private val numberOfQuestions: Int,
) {

    private var questions: MutableList<Question> = mutableListOf()

    fun startQuiz() {
        doCountdown()
        questions = loadQuestions(numberOfQuestions)
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

    private fun loadQuestions(numberOfQuestions: Int): MutableList<Question> {
        var count = 0
        val questions: MutableList<Question> = mutableListOf()

        while (count < numberOfQuestions) {
            questions.add(loadRandomQuestion())
            count++
        }

        return questions
    }

    private fun loadRandomQuestion(): Question {
        return Question(
            DirectObject.entries[Random.nextInt(0, DirectObject.entries.size)],
            IndirectObject.entries[Random.nextInt(0, IndirectObject.entries.size)],
            Infinitive(),
            Tense.entries[Random.nextInt(0, Tense.entries.size)]
        )
    }
}