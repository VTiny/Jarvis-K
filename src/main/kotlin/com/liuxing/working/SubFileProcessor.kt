package com.liuxing.working

import java.io.File


fun processFile(files: List<File>? = null, paths: List<String>? = null, processor: (File) -> Unit) {
    val targets = files ?: paths?.map { File(it) } ?: return
    targets.forEach {
        if (it.isFile) {
            processor(it)
        }
        if (it.isDirectory) {
            processFile(files = it.listFiles()?.toList() ?: emptyList(), processor = processor)
        }
    }
}

fun main() {
    val runtime = Runtime.getRuntime()
    fun exec(cmd: String) {
        println("exe $cmd ...")
        runtime.exec(cmd)
    }
    val targetPath = "/Users/liuxia/Downloads/thunder_uploader/output"
    val targetSuffix = ".png"
    processFile(
        paths = listOf(
            "/Users/liuxia/Downloads/thunder_uploader/rec/chatimg",
            "/Users/liuxia/Downloads/thunder_uploader/rec/chatraw",
            "/Users/liuxia/Downloads/thunder_uploader/rec/chatthumb",
        )
    ) {
        if (it.length() > 0) {
            exec(
                "cp " +
                        "${it.absolutePath} " +
                        "$targetPath/${it.name}${if (it.name.endsWith(targetSuffix)) "" else targetSuffix}"
            )
        }
    }
}