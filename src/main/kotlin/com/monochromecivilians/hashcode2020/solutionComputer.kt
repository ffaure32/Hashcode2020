package com.monochromecivilians.hashcode2020

fun resolve(input: ParsedInput): Output {
    val output = Output()
    val libraries = input.libraries
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

fun findLibraryToScan(remainingTime: Int, libraries: List<Library>): Library? {
    libraries.forEach(Library::computeScore)
    return libraries.sortedBy(Library::score).find { it.recordTime < remainingTime }
}

fun scan(library: Library, output: Output) {
    output.librariesCount++
    output.bookScannedCount += library.books.size
    output.libraries.add(library)
}