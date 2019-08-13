package com.example.cinqsampleandroid.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "carro")
class Carro : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    var nome = ""
    var desc = ""
    var urlFoto = ""

    override fun toString(): String {
        return "Carro(nome='$nome')" }

}