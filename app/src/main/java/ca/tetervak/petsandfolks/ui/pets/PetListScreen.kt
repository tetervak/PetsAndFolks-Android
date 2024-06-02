package ca.tetervak.petsandfolks.ui.pets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
fun PetListScreen(
    onMenuButtonClick: (() -> Unit)? = null,
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = {
            CommonTopBar(
                title = stringResource(R.string.pet_list),
                icon = R.drawable.baseline_pets_24,
                onMenuButtonClick = onMenuButtonClick,
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            CommonBottomBar(
                currentTab = NavigationBarDestination.PET_LIST,
                onTabPressed = {}
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        PetListBody(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun PetListBody(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ){
        Text(
            text = stringResource(R.string.pet_list),
            fontSize = 24.sp
        )
        Button(
            onClick = {},
            modifier = Modifier.padding(top = 16.dp)
        ){
            Text(text = stringResource(id = R.string.pet_details))
        }
    }
}