package flores.manuel.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_detail)

        val image: ImageView = findViewById(R.id.imagen)
        val title: TextView = findViewById(R.id.titulo)
        val description: TextView = findViewById(R.id.desc)
        val seatsLeft: TextView = findViewById(R.id.seatsLeft)
        val buyTickets: Button = findViewById(R.id.buyTickets)

        val bundle = intent.extras
        var ns = 0
        var id = -1;
        var titulo = "";

        if(bundle != null){
            ns = bundle.getInt("numberSeats")
            titulo = bundle.getString("titulo")!!

            image.setImageResource(bundle.getInt("header"))
            title.setText(bundle.getString("titulo"))
            description.setText(bundle.getString("sinopsis"))
            seatsLeft.setText("$ns seats available")
            id = bundle.getInt("pos")
        }

        if (ns == 0){
            buyTickets.isEnabled = false
        } else {
            buyTickets.setOnClickListener {
                val intent: Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("name", titulo)

                this.startActivity(intent)

            }
        }

    }
}