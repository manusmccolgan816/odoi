import question.*
import kotlin.random.Random

class QuizSession(
    private val numberOfQuestions: Int,
    private val dbConnector: DbConnector,
) {

    private var questions: MutableList<Question> = mutableListOf()
    private var questionAnswerCombos: MutableMap<Question, String> = mutableMapOf()

    fun startQuiz() {
        doCountdown()
        questions = loadQuestionsAndAnswers()
        askQuestions()
    }

    private fun doCountdown() {
        val quizStartText = "Quiz starting in 3..."
        print(quizStartText)
        Thread.sleep(1000)
        print("2...")
        Thread.sleep(1000)
        print("1...")
        Thread.sleep(1000)
        println()
    }

    private fun loadQuestionsAndAnswers(): MutableList<Question> {
        var count = 0
        val questions: MutableList<Question> = mutableListOf()

        while (count < numberOfQuestions) {
            val question = loadRandomQuestion()
            questions.add(question)
            questionAnswerCombos[question] = QuizUtil.calculateAnswer(question)
            dbConnector.getVerb(question.tense, question.infinitive, "Indicativo")
            count++
        }

        return questions
    }

    private fun loadRandomQuestion(): Question {
        return Question(
            DirectObject.entries[Random.nextInt(0, DirectObject.entries.size)],
            IndirectObject.entries[Random.nextInt(0, IndirectObject.entries.size)],
            "dar",
            Subject.entries[Random.nextInt(0, Subject.entries.size)],
            Tense.entries[Random.nextInt(0, Tense.entries.size)],
        )
    }

    private fun askQuestions() {
        var count = 0

        while (count < numberOfQuestions) {
            val question = questions[count]
            print("Dir. object: ${question.directObject.name}\n" +
                    "Ind. object: ${question.indirectObject.name}\n" +
                    "Action: ${question.infinitive}\n" +
                    "question.Subject: ${question.subject.name}\n" +
                    "question.Tense: ${question.tense.name}")
            count++
        }
    }
}