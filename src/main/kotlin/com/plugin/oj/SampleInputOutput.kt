package com.plugin.oj

import org.jsoup.nodes.Element
import javax.swing.JSplitPane
import javax.swing.JTextArea

class SampleInputOutput(sampleIO: Pair<Element, Element>): JSplitPane(HORIZONTAL_SPLIT) {
    private val inputData = SampleData(sampleIO.first)
    private val outputData = SampleData(sampleIO.second)

    init {
        this.leftComponent = inputData
        this.rightComponent = outputData
    }
}

class SampleData(sampleData: Element): JTextArea() {
    private val data: String = sampleData.text()

    init {
        println(data)
//        this.font = Font(MONOSPACED, PLAIN, 16)
        this.text = data
    }
}