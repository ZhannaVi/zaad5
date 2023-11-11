fun main() {
    val words = inputWords()
    val groupedWords = groupWords(words)
    displayGroups(groupedWords)
}

fun inputWords(): List<String> {
    println("Введите слова, разделенные запятой:")
    val input = readLine()
    return input?.split(",")?.map { it.trim() } ?: emptyList()
}

fun groupWords(words: List<String>): Map<String, List<String>> {
    val groupedWords = mutableMapOf<String, MutableList<String>>()
    for (word in words) {
        val sortedChars = word.toCharArray().sorted().toString()
        val group = groupedWords.getOrPut(sortedChars) { mutableListOf() }
        group.add(word)
    }
    return groupedWords
}

fun displayGroups(groupedWords: Map<String, List<String>>) {
    println("Результат группировки:")
    for (group in groupedWords.values) {
        println(group.joinToString(", "))
    }
}