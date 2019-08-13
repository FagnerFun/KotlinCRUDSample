package com.example.cinqsampleandroid.domain.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cinqsampleandroid.domain.Carro

// Define as classes que precisam ser persistidas e a versão do banco
@Database(entities = [Carro::class], version = 1)
abstract class CarrosDatabase : RoomDatabase() {
    abstract fun carroDAO(): CarroDAO
}
