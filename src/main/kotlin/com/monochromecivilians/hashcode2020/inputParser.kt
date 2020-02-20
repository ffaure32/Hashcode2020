package com.monochromecivilians.hashcode2020

fun parseInput(input: List<String>): ParsedInput {
    val firstLine = input[0].split(" ").map { it.toInt()}
    val nbBooks = firstLine[0]
    val nbLibraries = firstLine[1]
    val nbDays = firstLine[2]

    val secondLine = input[1].split(" ").map { it.toInt()}
    val books = mutableMapOf<Int, Book>()
    for(i in 0  until nbBooks) {
        books.put(i,  Book(i, secondLine[i]))
    }

    var index = 2
    val libraries = mutableListOf<Library>()
    for(i in 0 until nbLibraries) {
        val map = input[index++].split(" ").map { it.toInt() }
        val nbRecordTime = map[1]
        val nbBooksToScan = map[2]

        val booksForLibrary = input[index++].split(" ").map { it.toInt() }
        val booksForLib = booksForLibrary.map { books[it]!! }

        libraries.add(Library(i, nbRecordTime, booksForLib, nbBooksToScan))
    }
    return ParsedInput(libraries, nbBooks, nbLibraries, nbDays)
}

data class ParsedInput(val libraries: MutableList<Library>, val nbBooks : Int, val nbLibraries : Int, val nbDays : Int)