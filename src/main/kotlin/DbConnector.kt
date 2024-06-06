import com.mongodb.client.model.Filters
import org.litote.kmongo.KMongo
import org.litote.kmongo.json
import question.Tense

class DbConnector {

    companion object {
        private val client = KMongo.createClient("mongodb://localhost:27017")
        private val database = client.getDatabase("odoi-verbs")
        private val collection = database.getCollection("jehle_verb_mongo")
    }

    fun getVerb(tense: Tense, infinitive: String, mood: String): String {
        val query = Filters.and(
            listOf(
                Filters.eq("tense", tense.spanishValue),
                Filters.eq("infinitive", infinitive),
                Filters.eq("mood", mood),
            )
        )

        val result = collection.find(query).limit(1)
        result.forEach {
            println("Manus ")
            println(it)
        }

        return query.json
    }

}