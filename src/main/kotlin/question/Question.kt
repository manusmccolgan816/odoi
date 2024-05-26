package question

class Question(
    val directObject: DirectObject = DirectObject.ME,
    val indirectObject: IndirectObject = IndirectObject.ME,
    val infinitive: Infinitive = Infinitive(),
    val subject: Subject = Subject.I,
    val tense: Tense = Tense.PRESENT,
) {
}