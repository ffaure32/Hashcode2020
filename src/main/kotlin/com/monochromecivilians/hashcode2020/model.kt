package com.monochromecivilians.hashcode2020

data class Book(val id: Int, val score: Int) {}

data class Library(val id: Int, val recordTime: Int, val books: List<Book>, val scansPerDay: Int, var score: Int = 0) {
    fun computeScore() {
        this.score = (books.sumBy { it.score } * scansPerDay) / this.recordTime
    }
}

data class Output(var librariesCount: Int = 0, var libraries: MutableList<Library> = mutableListOf(), var bookScannedCount: Int = 0) {
    fun generateOutput(): List<String> {
        val output = mutableListOf<String>()
        output.add(librariesCount.toString())
        libraries.forEach { library ->
            output.add(library.id.toString() + " " + library.books.size)
            output.add(library.books.map { it.id }.joinToString(" "))
        }
        return output
    }
}
