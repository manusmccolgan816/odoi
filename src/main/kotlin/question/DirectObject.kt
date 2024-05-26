package question

enum class DirectObject(val spanishValue: String) {
    ME ("me"),
    YOU("te"),
    HIM("lo"),
    HER("la"),
    IT("lo"), // TODO Implementa funcionalidad para cambiar en funcion del genero del sustantivo
    US("nos"),
    YOU_PL("os"),
    THEM("los") // TODO Implementa funcionalidad para 'las' en funcion del genero del sustantivo
}