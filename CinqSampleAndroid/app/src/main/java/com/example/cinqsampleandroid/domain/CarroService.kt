package com.example.cinqsampleandroid.domain

import com.example.cinqsampleandroid.domain.dao.DatabaseManager


object CarroService {
    private val dao = DatabaseManager.getCarroDAO()

    fun getCarros(): List<Carro> {
        return dao.findAll()
    }

    fun getCarro(id: Long): Carro?
    {
        return dao.getById(id)
    }

    fun salvar(carro: Carro) {
        dao.insert(carro)
    }

    fun atualizar(carro: Carro) {
        dao.update(carro)
    }

    fun deletar(carro: Carro){
        dao.delete(carro)
    }
}