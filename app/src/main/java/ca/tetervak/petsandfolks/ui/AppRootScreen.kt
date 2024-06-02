package ca.tetervak.petsandfolks.ui

import ca.tetervak.petsandfolks.ui.pets.PetListScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ca.tetervak.petsandfolks.ui.common.NavigationBarDestination
import ca.tetervak.petsandfolks.ui.folks.FolkListScreen
import ca.tetervak.petsandfolks.ui.home.HomeScreen

@Composable
fun AppRootScreen() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomeScreen(
                onNavigationTabClick = { destination ->
                    when(destination){
                        NavigationBarDestination.PET_LIST -> {
                            navController.navigate("pet-list")
                        }
                        NavigationBarDestination.FOLK_LIST -> {
                            navController.navigate("folk-list")
                        }
                        else -> {}
                    }
                }
            )
        }
        composable(route = "pet-list"){
            PetListScreen(
                onNavigationTabClick = { destination ->
                    when(destination){
                        NavigationBarDestination.HOME -> {
                            navController.navigate("home")
                        }
                        NavigationBarDestination.FOLK_LIST -> {
                            navController.navigate("folk-list")
                        }
                        else -> {}
                    }
                }
            )
        }
        composable(route = "folk-list"){
            FolkListScreen(
                onNavigationTabClick = { destination ->
                    when(destination){
                        NavigationBarDestination.HOME -> {
                            navController.navigate("home")
                        }
                        NavigationBarDestination.PET_LIST -> {
                            navController.navigate("pet-list")
                        }
                        else -> {}
                    }

                }
            )
        }
    }
}