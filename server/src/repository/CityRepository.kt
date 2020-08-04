package com.example.server.repository

import com.example.server.db.dbQuery
import com.example.server.db.table.Cities
import com.example.server.db.table.toCity
import org.jetbrains.exposed.sql.selectAll

class CityRepository {
    suspend fun getAll() =
        dbQuery {
            Cities.selectAll().map { it.toCity() }
        }

}