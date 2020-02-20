package com.monochromecivilians.hashcode2020

fun resolve(input: ParsedInput): Output {
    val output = Output()
    val libraries = input.libraries
    var deadline = input.nbDays
    val scannedBooks = mutableSetOf<Book>()
    var unSingedLibraries = mutableListOf<Library>()
    unSingedLibraries.addAll(libraries)
    var library = findLibraryToScan(deadline, libraries, scannedBooks, unSingedLibraries)
    while (library != null) {
        scan(library, output)
        libraries.remove(library)
        deadline -= library.recordTime
        library = findLibraryToScan(deadline, libraries, scannedBooks, unSingedLibraries)
    }
    return output
}

fun findLibraryToScan(remainingTime: Int, libraries: List<Library>, scannedBooks: MutableSet<Book>, unSingedLibraries: MutableList<Library>): Library? {
    libraries.forEach { it.computeScore(remainingTime) }
    val library = libraries.sortedBy(Library::score).findLast { it.recordTime < remainingTime }
    if (library != null) {
        scannedBooks.addAll(library.books)
    }
    unSingedLibraries.remove(library)
    unSingedLibraries.forEach {
        it.books = it.books.filter { book -> !scannedBooks.contains(book) }
    }
    return library
}

fun scan(library: Library, output: Output) {
    output.librariesCount++
    output.bookScannedCount += library.books.size
    output.libraries.add(library)
}