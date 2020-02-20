package com.monochromecivilians.hashcode2020

const val fileName = "a_example"

fun resolve(input: ParsedInput): Output {
    var libraries = input.libraries
    var deadline = input.nbDays
    var library = findLibraryToScan(deadline, libraries)
    while(library != null) {
        scan(library)
        libraries = input.libraries.filter { it != library }
        deadline -= library.recordTime
        library = findLibraryToScan(deadline, libraries)
    }
}

fun findLibraryToScan(remaningTime: Int, libraries: List<Library>): Library? =
        libraries.find { it.recordTime < remaningTime }

fun scan(library: Library) {
    
}