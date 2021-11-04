package com.sample.news.feature_news_impl.util

fun String.toDate(): String {
    return this.replaceAfter("T", "").replace("T", "")
}