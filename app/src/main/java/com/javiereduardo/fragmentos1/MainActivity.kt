package com.javiereduardo.fragmentos1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.javiereduardo.fragmentos1.fragmentos.navegadorFragment
import com.javiereduardo.fragmentos1.fragmentos.primerFragment
import com.javiereduardo.fragmentos1.fragmentos.segundoFragment

class MainActivity : AppCompatActivity() {
    lateinit var btnFragment1:Button
    lateinit var btnFragment2:Button
    lateinit var btnNavegador:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFragment1=findViewById(R.id.btnf1)
        btnFragment2=findViewById(R.id.btnf2)
        btnNavegador=findViewById(R.id.btnNavegador)

        btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.contenedor,primerFragment.newInstance("ddd","www"))
                .commitNow()
        }
        btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.contenedor,segundoFragment.newInstance("ddd","www"))
                .commitNow()
        }
        btnNavegador.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.contenedor,navegadorFragment.newInstance("https://www.google.com/"))
                .commitNow()
        }
    }
}