package flores.manuel.popcornfactory

import android.os.Bundle
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

        val bundle = intent.extras

        if(bundle != null){
            image.setImageResource(bundle.getInt("header"))
            title.setText(bundle.getString("titulo"))
            description.setText(bundle.getString("sinopsis"))
        }

    }
}