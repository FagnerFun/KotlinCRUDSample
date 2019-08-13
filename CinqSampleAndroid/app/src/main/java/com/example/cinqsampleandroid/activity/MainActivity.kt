package com.example.cinqsampleandroid.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinqsampleandroid.R
import com.example.cinqsampleandroid.adapter.CarroAdapter
import com.example.cinqsampleandroid.domain.Carro
import com.example.cinqsampleandroid.domain.CarroService
import com.example.cinqsampleandroid.extensions.setupToolbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_progress.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import com.example.cinqsampleandroid.CarrosApplication
import java.util.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setupToolbar(R.id.toolbar, upNavigation = false)

        recyclerView.layoutManager = GridLayoutManager(context, 2) as RecyclerView.LayoutManager?
        recyclerView.itemAnimator = DefaultItemAnimator()


        swipeToRefresh.setOnRefreshListener {
            taskCarros(true)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_carros, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.action_refresh-> {
                val intent = Intent(this, CarroActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()

        taskCarros(false)
        progress.visibility = View.INVISIBLE

    }

    private fun taskCarros(refresh: Boolean) {

        if(! swipeToRefresh.isRefreshing) {
            progress.visibility = View.VISIBLE
        }

        doAsync {

            val dateIni = Date().getTime()

            val carros = CarroService.getCarros()

            uiThread {


                var adapter = CarroAdapter(carros) { c ->
                    onClickCarro(c)
                }

                tRegistros.text = carros.count().toString()
                tTimer.text = (Date().getTime() - dateIni).toString() + " ms"

                recyclerView.adapter = adapter

                swipeToRefresh.isRefreshing = false
                progress.visibility = View.INVISIBLE

            }
        }
    }

    private fun onClickCarro(c: Carro) {

        val intent = Intent(this, CarroActivity::class.java)
        intent.putExtra("carro", c)
        startActivity(intent)
    }
}
