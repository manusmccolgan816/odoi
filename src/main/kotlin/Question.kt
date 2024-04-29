class Question(
    private val directObject: DirectObject = DirectObject.ME,
    private val indirectObject: IndirectObject = IndirectObject.ME,
    private val infinitive: Infinitive = Infinitive(),
    private val tense: Tense = Tense.PRESENT
) {


}