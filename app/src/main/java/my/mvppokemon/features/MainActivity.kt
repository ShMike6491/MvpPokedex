package my.mvppokemon.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.androidx.AppNavigator
import my.mvppokemon.PokemonApp
import my.mvppokemon.R
import my.mvppokemon.navigation.INavigationUpListener

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val navigator = AppNavigator(this, R.id.container)
    private val navHolder = PokemonApp.INSTANCE.navigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is INavigationUpListener && it.backPressed()) {
                return
            }
        }
        //TODO Let presented handle back pressed func
    }
}