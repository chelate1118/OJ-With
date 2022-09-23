package com.plugin.oj.problems

class BOJProblem(private val probID: Int) : Problem() {
    companion object {
        const val urlPref: String = "https://www.acmicpc.net/"
    }

    override fun toURL(): String {
        return urlPref.plus("problem/").plus(probID)
    }
}