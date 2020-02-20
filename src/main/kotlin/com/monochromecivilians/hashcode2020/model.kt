package com.monochromecivilians.hashcode2020

data class Book(val id: Int, val score: Int) {}

data class Library(val id: Int, val recordTime: Int, val bookIds: List<Book>, val scansPerDay: Int)

data class Output(var librariesCount: Int = 0, var libraries: MutableList<Library> = mutableListOf(), var bookScannedCount: Int = 0) {
    fun generateOutput(): List<String> {
        val output = mutableListOf<String>()
        output.add(librariesCount.toString())
        libraries.forEach { library ->
            output.add(library.id.toString() + " " + library.bookIds.size)
            output.add(library.bookIds.map { it.id }.joinToString { " " })
        }
        return output
    }
}
