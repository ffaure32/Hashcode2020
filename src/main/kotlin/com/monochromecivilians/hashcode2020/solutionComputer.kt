package com.monochromecivilians.hashcode2020

fun resolve(input: ParsedInput): Output {
    val output = Output()
    val libraries = input.libraries
    var deadline = input.nbDays
    var scannedBooks = mutableSetOf<Book>()
    var library = findLibraryToScan(deadline, libraries, scannedBooks)
    while (library != null) {
        scan(library, output)
        libraries.remove(library)
        deadline -= library.recordTime
        library = findLibraryToScan(deadline, libraries, scannedBooks)
    }
    return output
}

fun findLibraryToScan(remainingTime: Int, libraries: List<Library>, scannedBooks: MutableSet<Book>): Library? {
    libraries.forEach(Library::computeScore)
    val library = libraries.sortedBy(Library::score).findLast { it.recordTime < remainingTime }
    if (library != null) {
        scannedBooks.addAll(library.books)
    }
    libraries.forEach {
        it.books = it.books.filter { book -> !scannedBooks.contains(book) }
    }
    return library
}

fun scan(library: Library, output: Output) {
    output.librariesCount++
    output.bookScannedCount += library.books.size
    output.libraries.add(library)
}