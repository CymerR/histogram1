package ru.cmr.histogram1

import org.nield.kotlinstatistics.*

class Statistics(private val stats: List<Double>) {
    fun geometricMean(): Double {
        return stats.geometricMean()
    }

    fun mean(): Double {
        return stats.average()
    }

    fun median(): Double {
        return stats.median()
    }

    fun excess(): Double {
        return stats.kurtosis
    }

    fun normalize(): DoubleArray {
        return stats.normalize()
    }

    fun standardDeviation(): Double {
        return stats.standardDeviation()
    }

    fun variance(): Double {
        return stats.variance()
    }


    fun calculate(): List<String> {

        val res = mutableListOf<Pair<String, Double>>()

        val formatter = java.text.DecimalFormat("#.##")

        res.add(Pair("Геометрическое среднее", geometricMean()))
        res.add(Pair("МатОжидание", mean()))
        res.add(Pair("Стандартное отклонение", standardDeviation()))
        res.add(Pair("Медиана", median()))
        res.add(Pair("Эксцесс", excess()))
        res.add(Pair("Вариация", variance()))

        val stringList = res.map {
            var b = 0.0
            if (!it.second.isNaN()) {
                b = it.second
            }
            Pair(it.first, formatter.format(b))
        }.map {
            it.first + " - " + it.second
        }
        return stringList

    }

    companion object {
        fun empty(): Statistics {
            return Statistics(emptyList())
        }
    }
}


fun createStatistics(data: List<Double>): Statistics {
    return Statistics(data)
}