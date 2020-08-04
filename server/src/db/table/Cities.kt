package com.example.server.db.table

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Cities : Table() {
    val id: Column<Long> = Cities.long("id").autoIncrement().primaryKey()
    val title: Column<String> = Cities.text("title")
    val temp: Column<Int> = Cities.integer("temp")
}