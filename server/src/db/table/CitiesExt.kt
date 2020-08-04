package com.example.server.db.table

import com.example.common.City
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toCity() = City(
    id = this[Cities.id],
    title = this[Cities.title],
    temp = this[Cities.temp]
)