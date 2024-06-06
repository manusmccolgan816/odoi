package question

enum class Subject(val correspondingNameInDb: String) {
    I("form_1s"),
    YOU_SINGULAR("form_2s"),
    HE("form_3s"),
    SHE("form_3s"),
    IT("form_3s"),
    WE("form_1p"),
    YOU_PLURAL("form_2p"),
    THEY("form_3p")
}