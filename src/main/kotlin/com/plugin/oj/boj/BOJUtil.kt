package com.plugin.oj.boj

class BOJPageSection(val html: String) {

}

class BOJPage(val probNum: Int) {
    companion object {
        val sectionIDList = arrayOf("problem-info", "description", "input", "output", "source", "problem_tags")
    }

    init {

    }
}