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
        questionAnswerCombos = loadQuestionsAndAnswers()
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

    private fun loadQuestionsAndAnswers(): MutableMap<Question, String> {
        var count = 0
        val questionAnswerCombos: MutableMap<Question, String> = mutableMapOf()

        while (count < numberOfQuestions) {
            val question = loadRandomQuestion()
            questionAnswerCombos[question] = calculateAnswer(question)
            println(questionAnswerCombos[question]) // TODO Remove this
            count++
        }

        return questionAnswerCombos
    }

    private fun loadRandomQuestion(): Question {
        return Question(
            DirectObject.entries[Random.nextInt(0, DirectObject.entries.size)],
            IndirectObject.entries[Random.nextInt(0, IndirectObject.entries.size)],
            "dar", // TODO Carga infinitivo aleatoriamente (de una seleccion que apunto yo en el codigo, o sacado de otro archivo)
            Subject.entries[Random.nextInt(0, Subject.entries.size)],
            Tense.entries[Random.nextInt(0, Tense.entries.size)],
        )
    }

    private fun askQuestions() {
        var count = 0
        val questions = questionAnswerCombos.keys.toList()

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

    private fun calculateAnswer(question: Question): String {
        // encuentra la forma conjugada del verbo
        // asegurate de tener la forma espanola del objeto directo
        // asegurate de tener la forma espanola del objeto indirecto
        // TODO Haz algo con el modo, ahora es siempre Indicativo
        val conjugatedVerb: String = dbConnector.getVerb(question.tense, question.infinitive, question.subject, "Indicativo")
        val directObject: String = question.directObject.spanishValue
        val indirectObject = calculateIndirectObject(question)
        // TODO Anade funcionalidad para las 2 opciones en cuanto a la colocacion de los objetos
        return "$indirectObject $directObject $conjugatedVerb"
    }

    private fun calculateIndirectObject(question: Question): String {
        return if (doesIndirectObjectHaveToChangeToSe(question.directObject, question.indirectObject)) {
            "se"
        } else {
            question.indirectObject.spanishValue
        }
    }

    private fun doesIndirectObjectHaveToChangeToSe(directObject: DirectObject, indirectObject: IndirectObject): Boolean {
        return isDirectObjectThirdPerson(directObject) && isIndirectObjectThirdPerson(indirectObject)
    }

    private fun isDirectObjectThirdPerson(directObject: DirectObject): Boolean {
        return (directObject == DirectObject.HIM || directObject == DirectObject.HER || directObject == DirectObject.IT)
    }

    private fun isIndirectObjectThirdPerson(indirectObject: IndirectObject): Boolean {
        return (indirectObject == IndirectObject.HIM || indirectObject == IndirectObject.HER || indirectObject == IndirectObject.IT)
    }
}