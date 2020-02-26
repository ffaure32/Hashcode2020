package com.monochromecivilians.hashcode2020

fun resolve(input: ParsedInput): Output {
    val output = Output()
    val libraries = input.libraries.toMutableSet()
    var deadline = input.nbDays
    var library = findLibraryToScan(deadline, libraries)
    while (library != null) {
        scan(library, output)
        libraries.remove(library)
        deadline -= library.recordTime
        library = findLibraryToScan(deadline, libraries)
    }
    return output
}

fun findLibraryToScan(remainingTime: Int, libraries: Set<Library>): Library? {
    val library = libraries.filter { it.recordTime < remainingTime }.maxBy{it.computeScore(remainingTime)}
    return library
}

fun scan(library: Library, output: Output) {
    library?.scanBooks()
    output.librariesCount++
    output.bookScannedCount += library.books.size
    output.libraries.add(library)
}