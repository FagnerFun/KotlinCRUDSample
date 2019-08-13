package com.example.cinqsampleandroid.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cinqsampleandroid.R
import com.example.cinqsampleandroid.domain.Carro
import com.example.cinqsampleandroid.domain.CarroService
import com.example.cinqsampleandroid.extensions.setupToolbar
import com.example.cinqsampleandroid.extensions.toast
import kotlinx.android.synthetic.main.activity_carro.*
import org.jetbrains.anko.doAsync

class CarroActivity: AppCompatActivity() {


    var carro: Carro? = null

    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        setContentView(R.layout.activity_carro)

        setupToolbar(R.id.toolbar, upNavigation = true)

        btSalvar.setOnClickListener { onClickSalvar() }

        if(intent.extras != null) {
            carro = intent.extras.get("carro") as Carro
            atualizarTela()
        }

    }

    private fun atualizarTela()
    {
        tNome.setText(carro?.nome)
        tDesc.setText(carro?.desc)
        tUrlFoto.setText(carro?.urlFoto)

    }

    private fun onClickSalvar() {

        doAsync {
            var update: Boolean = true
            if (carro == null)
            {
                carro = Carro()
                update = false
            }
            carro?.nome = tNome.text.toString()
            carro?.desc = tDesc.text.toString()
            carro?.urlFoto = tUrlFoto.text.toString()

            if(update)
                CarroService.atualizar(carro!!)
            else
                CarroService.salvar(carro!!)

            toast("Carro salvo com sucesso")
            finish()
        }
    }
}