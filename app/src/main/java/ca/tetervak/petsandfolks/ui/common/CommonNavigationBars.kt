package ca.tetervak.petsandfolks.ui.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ca.tetervak.petsandfolks.R

enum class NavigationBarDestination {
    HOME, PET_LIST, FOLK_LIST, NONE
}

private data class NavigationBarItem(
    val destination: NavigationBarDestination,
    @DrawableRes val icon: Int,
    @StringRes val text: Int
)

private val navigationBarItemList: List<NavigationBarItem> = listOf(
    NavigationBarItem(
        destination = NavigationBarDestination.HOME,
        icon = R.drawable.baseline_home_24,
        text = R.string.home
    ),
    NavigationBarItem(
        destination = NavigationBarDestination.PET_LIST,
        icon = R.drawable.baseline_pets_24,
        text = R.string.pet_list
    ),
    NavigationBarItem(
        destination = NavigationBarDestination.FOLK_LIST,
        icon = R.drawable.baseline_person_24,
        text = R.string.folk_list
    )
)

@Composable
fun CommonBottomBar(
    currentTab: NavigationBarDestination,
    onNavigationTabClick: ((NavigationBarDestination) -> Unit),
) = NavigationBar(
    modifier = Modifier.fillMaxWidth()
) {
    for (navItem in navigationBarItemList) {
        val text: String = stringResource(id = navItem.text)
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.weight(1.0f)
        ) {
            NavigationRailItem(
                selected = currentTab == navItem.destination,
                onClick = { onNavigationTabClick(navItem.destination) },
                label = { Text(text = text) },
                alwaysShowLabel = true,
                icon = {
                    Icon(
                        painter = painterResource(id = navItem.icon),
                        contentDescription = text
                    )
                }
            )
        }
    }
}