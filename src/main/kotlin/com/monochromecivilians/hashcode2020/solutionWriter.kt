package com.monochromecivilians.hashcode2020

import java.io.File

fun writeSolution(data: List<String>) {
    File("solution_$fileName.txt").writeText(data.joinToString("\n"))
}