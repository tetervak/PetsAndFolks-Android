package ca.tetervak.petsandfolks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ca.tetervak.petsandfolks.ui.AppRootScreen
import ca.tetervak.petsandfolks.ui.theme.PetsAndFolksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PetsAndFolksTheme {
                AppRootScreen()
            }
        }
    }
}
