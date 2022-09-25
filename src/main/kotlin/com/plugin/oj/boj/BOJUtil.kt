package com.plugin.oj.boj

import com.plugin.oj.SampleInputOutput
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import javax.swing.BoxLayout
import javax.swing.BoxLayout.Y_AXIS
import javax.swing.JPanel

private val sectionIDArray = arrayOf("problem-info", "description", "input", "output", "source", "problem_tags")
private const val urlPref: String = "https://www.acmicpc.net"
private fun probURL(probID: Int): String = "$urlPref/problem/$probID"

class BOJPage(probNum: Int): JPanel() {
    private val htmlDocument: Document = Jsoup.connect(probURL(probNum)).get()
    val title: String = htmlDocument.title()
    private val sectionElementList = ArrayList<BOJPageSection>()
    private val sampleIOList = ArrayList<SampleInputOutput>()

    init {
        this.layout = BoxLayout(this, Y_AXIS)
        parseSections()
        parseSampleData()

        addSampleData()
    }

    private fun parseSections() {
        for (sectionID in sectionIDArray) {
            val element = htmlDocument.getElementById(sectionID) ?: continue
            val bojPageSection = BOJPageSection(element)

            sectionElementList.add(bojPageSection)
        }
    }

    private fun parseSampleData() {
        var sampleDataIndex = 0
        while(true) {
            sampleDataIndex++
            val inputElement = htmlDocument.getElementById("sample-input-$sampleDataIndex") ?: break
            val outputElement = htmlDocument.getElementById("sample-output-$sampleDataIndex") ?: break

            val sampleIO = SampleInputOutput(Pair(inputElement, outputElement))
            sampleIOList.add(sampleIO)

            println("Parse Test Case #$sampleDataIndex")
        }
    }

    private fun addSampleData() {
        for (sampleIO in sampleIOList) {
            add(sampleIO)
        }
    }
}

class BOJPageSection(private val element: Element): JPanel() {
    init {
        element.className()
    }
}