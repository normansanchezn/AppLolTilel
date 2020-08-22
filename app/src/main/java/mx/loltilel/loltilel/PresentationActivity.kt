package mx.loltilel.loltilel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_presentation.*

class PresentationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation)

        btnConocenos.setOnClickListener {
            Toast.makeText(
                this,
                "Estamos trabajando en esta funcionalidad, espera nuevas actualizaciones", Toast.LENGTH_SHORT)
                .show()
        }
    }
}