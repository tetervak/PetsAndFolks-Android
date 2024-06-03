package ca.tetervak.petsandfolks.ui

import ca.tetervak.petsandfolks.ui.pets.PetListScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ca.tetervak.petsandfolks.ui.common.NavigationBarDestination
import ca.tetervak.petsandfolks.ui.folks.FolkDetailsScreen
import ca.tetervak.petsandfolks.ui.folks.FolkListScreen
import ca.tetervak.petsandfolks.ui.home.HomeScreen
import ca.tetervak.petsandfolks.ui.pets.PetDetailsScreen

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
        composable(route = "pet-list") {
            PetListScreen(
                onListItemClick = { itemId ->
                    navController.navigate("pets/$itemId")
                },
                onNavigationTabClick = { destination ->
                    when (destination) {
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
        composable(
            route = "pets/{itemId}",
            arguments = listOf(
                navArgument(name = "itemId"){ type = NavType.StringType }
            )
        ){
            PetDetailsScreen(
                onNavigateBack = {
                    navController.navigate("pet-list")
                },
                onNavigationTabClick = { destination ->
                    when(destination){
                        NavigationBarDestination.HOME -> {
                            navController.navigate("home")
                        }
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
        composable(route = "folk-list") {
            FolkListScreen(
                onListItemClick = { itemId ->
                    navController.navigate("folks/$itemId")
                },
                onNavigationTabClick = { destination ->
                    when (destination) {
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
        composable(
            route = "folks/{itemId}",
            arguments = listOf(
                navArgument(name = "itemId"){ type = NavType.StringType }
            )
        ){
            FolkDetailsScreen(
                onNavigateBack = {
                    navController.navigate("folk-list")
                },
                onNavigationTabClick = { destination ->
                    when(destination){
                        NavigationBarDestination.HOME -> {
                            navController.navigate("home")
                        }
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
    }
}