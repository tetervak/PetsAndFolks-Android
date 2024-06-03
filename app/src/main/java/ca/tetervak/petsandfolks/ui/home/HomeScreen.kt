package ca.tetervak.petsandfolks.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.tetervak.petsandfolks.R
import ca.tetervak.petsandfolks.ui.common.CommonBottomBar
import ca.tetervak.petsandfolks.ui.common.CommonTopBar
import ca.tetervak.petsandfolks.ui.common.NavigationBarDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigationTabClick: ((NavigationBarDestination) -> Unit),
    onMenuButtonClick: (() -> Unit)? = null,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = {
            CommonTopBar(
                title = stringResource(id = R.string.app_name),
                icon = R.drawable.baseline_home_24,
                onMenuButtonClick = onMenuButtonClick,
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            CommonBottomBar(
                currentTab = NavigationBarDestination.HOME,
                onNavigationTabClick = onNavigationTabClick
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        HomeBody(
            onPetListClick = {
                 onNavigationTabClick(NavigationBarDestination.PET_LIST)
            },
            onFolkListClick = {
                onNavigationTabClick(NavigationBarDestination.FOLK_LIST)
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun HomeBody(
    onPetListClick: () -> Unit,
    onFolkListClick: () -> Unit,
    modifier: Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.home),
            fontSize = 24.sp
        )
        Button(onClick = onPetListClick) {
            Text( text = stringResource(id = R.string.pet_list))
        }
        Button(onClick = onFolkListClick) {
            Text( text = stringResource(id = R.string.folk_list))
        }
    }
}