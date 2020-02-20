package com.monochromecivilians.hashcode2020

fun runInput(input: List<String>, fileName: String) = parseInput(input).run(::resolve).run{
    writeSolution(this, fileName)
}