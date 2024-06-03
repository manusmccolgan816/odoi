package db

import org.bson.codecs.pojo.annotations.BsonId

data class VerbDocument(
    @BsonId
    val infinitive: Int,
    val infinitiveEnglish: String,
    val mood: String,
    val moodEnglish: String,
    val tense: String,
    val tenseEnglish: String,
    val verbEnglish: String,
    val form1s: String,
    val form2s: String,
    val form3s: String,
    val form1p: String,
    val form2p: String,
    val form3p: String,
    val gerund: String,
    val gerundEnglish: String,
    val pastParticiple: String,
    val pastParticipleEnglish: String,
)