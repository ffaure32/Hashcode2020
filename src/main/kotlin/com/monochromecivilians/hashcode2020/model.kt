package com.monochromecivilians.hashcode2020

data class Book(val id : Int, val score : Int) {}

data class Library(val id : Int, val recordTime : Int, val bookIds  : List<Int>, val scansPerDay : Int)
