package br.com.calculadoradecombustivel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtpreco = findViewById<TextInputEditText>(R.id.preco_combustivel)
        val btncontinuar = findViewById<Button>(R.id.button_continuar)


        btncontinuar.setOnClickListener{

            val precoCombustivelStr = edtpreco.text.toString()

            if( precoCombustivelStr == "") {
                Snackbar.make(edtpreco, "Preencha todos os campos.", Snackbar.LENGTH_LONG).show()
            } else {

                val precoCombustivel = precoCombustivelStr.toFloat()

                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("precoCombustivel", precoCombustivel)
                val precoCombustivelStr = ""
                startActivity(intent)



            }
        }

    }
}