package com.plugin.oj.browser

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.Content
import com.intellij.ui.content.ContentFactory
import java.awt.BorderLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JEditorPane
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextField
import javax.swing.event.HyperlinkEvent
import javax.swing.event.HyperlinkListener

class ProblemWindow: JPanel(), ActionListener, HyperlinkListener {
    private val browserPane = JEditorPane()
    private val addressBar = JTextField()

    init {
        println("init")
        addressBar.addActionListener(this)
        browserPane.isEditable = false
        browserPane.addHyperlinkListener(this)
        this.add(addressBar, BorderLayout.NORTH)
        this.add(JScrollPane(browserPane))
    }

    override fun actionPerformed(e: ActionEvent?) {
        val url = addressBar.text
        browserPane.setPage(url)
    }

    override fun hyperlinkUpdate(e: HyperlinkEvent?) {
        println("hyperlink")
    }
}

class ProblemWindowFactory: ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val contentFactory: ContentFactory = ContentFactory.SERVICE.getInstance()
        val content: Content = contentFactory.createContent(ProblemWindow(), "", false)
        toolWindow.contentManager.addContent(content)
    }
}