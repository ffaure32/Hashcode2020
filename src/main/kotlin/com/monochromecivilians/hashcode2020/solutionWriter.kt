package com.monochromecivilians.hashcode2020

import java.io.File

fun writeSolution(data: Output, fileName: String) {
    File("solution_$fileName.txt").writeText(data.generateOutput().joinToString("\n"))
}