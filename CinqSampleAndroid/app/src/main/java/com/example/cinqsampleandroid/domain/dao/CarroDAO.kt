package com.example.cinqsampleandroid.domain.dao

import androidx.room.*
import com.example.cinqsampleandroid.domain.Carro

@Dao
interface CarroDAO {
    @Query("SELECT * FROM carro where id = :id")
    fun getById(id: Long): Carro?

    @Query("SELECT * FROM carro")
    fun findAll(): List<Carro>

    @Insert
    fun insert(carro: Carro)

    @Update
    fun update(carro: Carro)

    @Delete
    fun delete(carro: Carro)
}