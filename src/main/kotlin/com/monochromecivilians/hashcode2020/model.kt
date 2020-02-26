package com.monochromecivilians.hashcode2020

import kotlin.math.max
import kotlin.math.min

class Book(val id: Int, val score: Int, var scanned : Boolean = false) {
    override fun equals(other: Any?): Boolean {
        if(other is Book) {
            return id == other.id
        } else {
            return false
        }
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

class Library(val id: Int, val recordTime: Int, var books: List<Book>, val scansPerDay: Int, var score: Int = 0) {
    override fun equals(other: Any?): Boolean {
        if(other is Library) {
            return id == other.id
        } else {
            return false
        }
    }
    override fun hashCode(): Int {
        return id.hashCode()
    }

    fun computeScore(remainingTime: Int): Int {
        val unscannedBooks = books.filter { !it.scanned }
        val min = max(0, remainingTime * this.scansPerDay)
        this.score = unscannedBooks.subList(0, max(0, min(min, unscannedBooks.size - 1))).sumBy { it.score } /this.recordTime
        return this.score
    }


    fun scanBooks() {
        books.forEach { it.scanned = true }
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
