package com.monochromecivilians.hashcode2020

import java.io.File

fun writeSolution(data: String) {
    File("solution_$fileName.txt").writeText(data)
}