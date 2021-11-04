package com.sample.core

fun String.toDate(): String {
    return this.replaceAfter("T", "").replace("T", "")
}