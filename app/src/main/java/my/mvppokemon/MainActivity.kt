package my.mvppokemon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import my.mvppokemon.features.details.DetailsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, DetailsFragment.newInstance(), "tag")
                .commit()
        }
    }
}