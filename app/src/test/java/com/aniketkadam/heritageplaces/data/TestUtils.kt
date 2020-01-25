package com.aniketkadam.heritageplaces.data

/**
 * The text in the file if it exists.
 * Null if the file does not exist or cannot be read.
 */
fun getTextFromAsset(fileName: String): String? =
    ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()?.use { it.readText() }