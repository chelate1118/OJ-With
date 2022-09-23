package com.plugin.oj

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.plugin.oj.problems.BOJProblem
import java.net.URL
import java.net.URLConnection
import java.util.*

class SubmitCodeAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Thread {
            val connection: URLConnection = URL("https://www.acmicpc.net/").openConnection()
            val scanner = Scanner(connection.getInputStream())
            scanner.useDelimiter("\\Z")
            val content: String = scanner.next()
            scanner.close()

            println(content)
        }.start()

        val problem = BOJProblem(1000).toURL()
        println(problem)
        BrowserUtil.browse(problem)
    }
}