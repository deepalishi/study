package com.techdata.study.ui

fun main() {

    val name: String? = "Deepali"

    name.apply {
        "Vishal"
    }
    println("Object value $name")

    name?.let { nm ->

    }

    name?.run {
        this.toString()
        this.length
    }

    with(name){
        this.toString()
        this?.length
    }
}

