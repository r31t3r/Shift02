package com.example.server.repository

import com.example.common.CreateCityDto
import com.example.server.db.dbQuery
import com.example.server.db.table.Cities
import com.example.server.db.table.toCity
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class CityRepository {
    suspend fun getAll() =
        dbQuery {
            Cities.selectAll().map { it.toCity() }
        }

    suspend fun add(createCityDto: CreateCityDto) {
        dbQuery {
            Cities.insert{ insertStatement ->
                insertStatement[title] = createCityDto.title
                insertStatement[temp] = createCityDto.temp
            }
        }
    }

    suspend fun delete(id: Long) {
        dbQuery {
            Cities.deleteWhere {
                Cities.id.eq(id)
            }
        }
    }

    //TODO: Add update!
}