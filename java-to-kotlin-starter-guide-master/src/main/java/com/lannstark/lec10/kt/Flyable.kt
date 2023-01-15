package com.lannstark.lec10.kt

interface Flyable {

    // default function
    fun act() {
        println("파닥 파닥")
    }

    // abstract function
    fun fly()
}