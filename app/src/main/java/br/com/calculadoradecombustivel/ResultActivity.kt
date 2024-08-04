package br.com.calculadoradecombustivel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultado = intent.getFloatExtra("resultado", 0.0f)
        val valorCombustivel = intent.getFloatExtra("precoCombustivel", 0.0f)
        val rendimento = intent.getFloatExtra("rendimento", 0.0f)
        val distancia = intent.getFloatExtra("distancia", 0.0f)

        val tvResultado = findViewById<TextView>(R.id.tv_resultado)
        tvResultado.text = "R$ " + resultado.toString()

        val tvValorCombustivel = findViewById<TextView>(R.id.tv_dado_valor)
        tvValorCombustivel.text = valorCombustivel.toString()

        val tvRendimento = findViewById<TextView>(R.id.tv_dado_consumo)
        tvRendimento.text = rendimento.toString()

        val tvDistancia = findViewById<TextView>(R.id.tv_dado_km)
        tvDistancia.text = distancia.toString()

        val btnRecalcular = findViewById<Button>(R.id.btn_reiniciar)

        btnRecalcular.setOnClickListener{

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}



