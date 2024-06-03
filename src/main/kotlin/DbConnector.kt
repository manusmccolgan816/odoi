import com.mongodb.client.model.Filters
import db.VerbDocument
import org.litote.kmongo.KMongo
import org.litote.kmongo.json
import question.Infinitive
import question.Tense

class DbConnector {

    companion object {
        private val client = KMongo.createClient("mongodb://localhost:27017")
        private val database = client.getDatabase("odoi-verbs")
        private val collection = database.getCollection("jehle_verb_mongo")
    }

    fun getVerb(tense: Tense, infinitive: Infinitive, mood: String): String {
        val query = Filters.or( // TODO Change this to 'and' and make sure all is correct
            listOf(
                Filters.eq("tense", tense.name),
                Filters.eq("infinitive", infinitive.value),
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