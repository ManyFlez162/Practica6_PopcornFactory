package flores.manuel.popcornfactory

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Compra : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_compra)

        val bundle = intent.extras
        var cliente: Cliente = Cliente("a","a",1)
        var nombrePelicula: String = ""
        var imagen = -1

        if(bundle != null) {
            cliente = bundle.getSerializable("cliente", Cliente::class.java)!!
            nombrePelicula = bundle.getString("nombrePelicula").toString()
            imagen = bundle.getInt("image")
        }

        val titulo: TextView = findViewById(R.id.movieTitle)
        val name: TextView = findViewById(R.id.clientName)
        val seatNumber: TextView = findViewById(R.id.seatNumber)
        val imageMovie: ImageView = findViewById(R.id.movieImage)

        // image.setImageResource(bundle.getInt("header"))
        imageMovie.setImageResource(imagen)
        titulo.text = "Movie: $nombrePelicula"
        name.text = "Client: ${cliente?.nombre}"
        seatNumber.text = "Seat: ${cliente?.asiento}"


    }
}