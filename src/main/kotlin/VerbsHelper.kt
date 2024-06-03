import com.github.doyaaaaaken.kotlincsv.dsl.csvReader

class VerbsHelper {

    private var verbsCsvData: List<List<String>> = loadVerbsCsvData()

    private fun loadVerbsCsvData(): List<List<String>> {
        var count = 0
        val verbsTable: List<List<String>>

        csvReader().open("src/main/resources/verbs.csv") {
            readAllAsSequence().forEach { row ->
                // Skip the first row as it is just headers
                if (count != 0) {
                    val row: MutableList<String>

                }

                count++
            }
        }

        return emptyList()
    }
}