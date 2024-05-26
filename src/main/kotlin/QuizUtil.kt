import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import question.Question
import java.io.InputStream

object QuizUtil {

    fun calculateAnswer(question: Question): String {
        // encuentra la forma conjugada del verbo
        // asegurate de tener la forma espanola del objeto directo
        // asegurate de tener la forma espanola del objeto indirecto
        val conjugatedVerb: String
        readCsv()

        return ""
    }

    fun readCsv(): List<String> {
        var count = 0
        // TODO Necesito anadir funcionalidad para coger la forma conjugada del verbo
        csvReader().open("src/main/resources/verbs.csv") {
            readAllAsSequence().forEach { row ->
                // Skip the first row as it is just headers
                if (count != 0) {
                    println(row)
                }
                count++
            }
        }
        return mutableListOf("")
    }
}