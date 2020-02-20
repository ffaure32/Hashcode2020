package com.monochromecivilians.hashcode2020

fun runInput(input: List<String>) = parseInput(input).run(::resolve).run(::writeSolution)