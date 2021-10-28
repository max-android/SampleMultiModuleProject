package com.sample.core

interface EventHandler<T> {
    fun obtainEvent(event: T)
}