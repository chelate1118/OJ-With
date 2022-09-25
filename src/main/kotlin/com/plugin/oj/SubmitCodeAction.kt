package com.plugin.oj

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.plugin.oj.boj.BOJPage

class SubmitCodeAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        BOJPage(7569)
    }
}