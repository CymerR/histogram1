package ru.cmr.histogram1

import org.junit.Test


class StatisticsTest {


    @Test
    fun ultimaTest() {
        val a = Statistics(listOf(1.0, 2.0, 3.0, 4.0, 5.0))
        a.calculate().forEach { println(it) }
    }
}