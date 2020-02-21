package com.monochromecivilians.hashcode2020

import kotlin.math.max
import kotlin.math.min

data class Book(val id: Int, val score: Int, var scanned : Boolean = false) {}

data class Library(val id: Int, val recordTime: Int, var books: List<Book>, val scansPerDay: Int, var score: Int = 0) {
    fun computeScore(remainingTime: Int): Int {
        val unscannedBooks = books.filter { !it.scanned }
        val min = max(0, remainingTime * this.scansPerDay)
        this.score = unscannedBooks.subList(0, max(0, min(min, unscannedBooks.size - 1))).sumBy { it.score } /this.recordTime
        return this.score
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
