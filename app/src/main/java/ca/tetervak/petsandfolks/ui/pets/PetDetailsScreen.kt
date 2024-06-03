package ca.tetervak.petsandfolks.ui.pets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.tetervak.petsandfolks.R
import ca.tetervak.petsandfolks.ui.common.CommonBottomBar
import ca.tetervak.petsandfolks.ui.common.CommonTopBar
import ca.tetervak.petsandfolks.ui.common.NavigationBarDestination


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetDetailsScreen(
    viewModel: PetDetailsViewModel = viewModel(),
    onNavigateBack: () -> Unit,
    onNavigationTabClick: ((NavigationBarDestination) -> Unit) = {},
    onMenuButtonClick: (() -> Unit)? = null,
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = {
            CommonTopBar(
                title = stringResource(R.string.pet_details),
                onNavigateBack = onNavigateBack,
                onMenuButtonClick = onMenuButtonClick,
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            CommonBottomBar(
                currentTab = NavigationBarDestination.NONE,
                onNavigationTabClick = onNavigationTabClick
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        PetDetailsBody(
            itemId = viewModel.itemId,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun PetDetailsBody(
    itemId: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ){
        Text(
            text = stringResource(R.string.pet_details),
            fontSize = 24.sp,
        )
        Text(
            text = "itemId = $itemId",
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}