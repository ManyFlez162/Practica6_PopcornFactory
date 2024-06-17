package flores.manuel.popcornfactory

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeatSelection : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seat_selection)

        val title: TextView = findViewById(R.id.titleSeats)
        var posMovie = -1
        var selectedSeat = -1
        val nombre = "Manuel Flores"
        var imagen = -1

        val bundle = intent.extras

        if (bundle != null) {
            title.setText(bundle.getString("name"))
            posMovie = bundle.getInt("id")
            imagen = bundle.getInt("image")
        }

        val confirm: Button = findViewById(R.id.confirm)

        confirm.setOnClickListener {
            if (selectedSeat != -1) {
                val cliente = Cliente(nombre, "Credit Card", selectedSeat)

                val intent = Intent(this, Compra::class.java)

                intent.putExtra("cliente", cliente)
                intent.putExtra("nombrePelicula", title.text.toString())
                intent.putExtra("image", imagen)

                Toast.makeText(this, "Enjoy the movie!", Toast.LENGTH_LONG).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select a seat", Toast.LENGTH_SHORT).show()
            }
        }

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        row1.setOnCheckedChangeListener { group, checkedID ->

            if (checkedID > -1) {
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row1.check(checkedID)
                selectedSeat = checkedID
            }
        }

        row2.setOnCheckedChangeListener { group, checkedID ->

            if (checkedID > -1) {
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkedID)
                selectedSeat = checkedID
            }
        }

        row3.setOnCheckedChangeListener { group, checkedID ->

            if (checkedID > -1) {
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()

                row3.check(checkedID)
                selectedSeat = checkedID
            }
        }

        row4.setOnCheckedChangeListener { group, checkedID ->

            if (checkedID > -1) {
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()

                row4.check(checkedID)
                selectedSeat = checkedID
            }
        }

    }

}