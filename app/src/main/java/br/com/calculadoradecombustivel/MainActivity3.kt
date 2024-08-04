package br.com.calculadoradecombustivel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val valorCombustivel = intent.getFloatExtra("precoCombustivel", 0.0f)
        val rendimento = intent.getFloatExtra("rendimento", 0.0f)

        val edtdistancia = findViewById<TextInputEditText>(R.id.edt_distancia)
        val btndistancia = findViewById<Button>(R.id.btn_avancar)

        btndistancia.setOnClickListener {

            val distanciaStr = edtdistancia.text.toString()

            if (distanciaStr =="") {
                Snackbar.make(edtdistancia,"Preencha todos os campos.",Snackbar.LENGTH_LONG).show()
            } else {
                val distancia = distanciaStr.toFloat()

                val resultado = valorCombustivel * (distancia / rendimento)

                val intent = Intent(this, ResultActivity::class.java)
                intent.apply{
                    putExtra("resultado", resultado)
                    putExtra("precoCombustivel", valorCombustivel)
                    putExtra("rendimento", rendimento)
                    putExtra("distancia", distancia)
                }
                startActivity(intent)
            }

        }
    }
}