package com.monochromecivilians.hashcode2020

data class Book(val id : Int, val score : Int) {}

data class Library(val id : Int, val recordTime : Int, val bookIds  : List<Book>, val scansPerDay : Int)

data class Output(val librariesCount : Int, val libraries : List<Library>, val bookScannedCount : Int) {
    fun generateOutput(): List<String> {
        val output = mutableListOf<String>()
        output.add(librariesCount.toString())
        libraries.forEach {
            output.add(it.id.toString() + " "+it.bookIds.size)
            output.add(it.bookIds.map { it.id }.joinToString { " "})
        }
        return output
    }
}
