package com.monochromecivilians.hashcode2020

import org.junit.jupiter.api.Test
import java.io.File


internal class TestKtTest {
    @Test
    fun `run Input A`() {
        val input = File("./src/main/resources/a_example.txt").readLines(Charsets.UTF_8)
        runInput(input, "a_example")
    }

    @Test
    fun `run Input B`() {
        val input = File("./src/main/resources/b_read_on.txt").readLines(Charsets.UTF_8)
        runInput(input, "b_read_on")
    }

    @Test
    fun `run Input C`() {
        val input = File("./src/main/resources/c_incunabula.txt").readLines(Charsets.UTF_8)
        runInput(input, "c_incunabula")
    }


    @Test
    fun `run Input D`() {
        val input = File("./src/main/resources/d_tough_choices.txt").readLines(Charsets.UTF_8)
        runInput(input, "d_tough_choices")
    }


    @Test
    fun `run Input E`() {
        val input = File("./src/main/resources/e_so_many_books.txt").readLines(Charsets.UTF_8)
        runInput(input, "e_so_many_books")
    }

    @Test
    fun `run Input F`() {
        val input = File("./src/main/resources/f_libraries_of_the_world.txt").readLines(Charsets.UTF_8)
        runInput(input, "f_libraries_of_the_world")
    }

}

