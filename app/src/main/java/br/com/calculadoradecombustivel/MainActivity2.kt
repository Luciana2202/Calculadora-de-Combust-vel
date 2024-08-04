package br.com.calculadoradecombustivel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val precoCombustivel = intent.getFloatExtra("precoCombustivel", 0.0f)

        val edtrendimento = findViewById<TextInputEditText>(R.id.edt_rendimento)
        val btnproximo = findViewById<Button>(R.id.btn_proximo)

        btnproximo.setOnClickListener {

            val rendimentoStr = edtrendimento.text.toString()

            if (rendimentoStr == "") {
                Snackbar.make(edtrendimento, "Preencha todos os campos.", Snackbar.LENGTH_LONG).show()
            } else {
                val rendimento = rendimentoStr.toFloat()

                val intent = Intent(this, MainActivity3::class.java)
                intent.apply {
                    putExtra("rendimento", rendimento)
                    putExtra("precoCombustivel", precoCombustivel)
                }
                startActivity(intent)
            }

        }
    }
}