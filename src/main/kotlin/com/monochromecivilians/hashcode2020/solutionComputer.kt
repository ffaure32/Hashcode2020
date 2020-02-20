package com.monochromecivilians.hashcode2020

fun resolve(input: ParsedInput): Output {
    var output = Output()
    var libraries = input.libraries
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

fun findLibraryToScan(remaningTime: Int, libraries: List<Library>): Library? =
        libraries.find { it.recordTime < remaningTime }

fun scan(library: Library, output: Output) {
    output.librariesCount++
    output.bookScannedCount += library.bookIds.size
    output.libraries.add(library)
}