package ca.tetervak.petsandfolks.ui.folks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.sp
import ca.tetervak.petsandfolks.R
import ca.tetervak.petsandfolks.ui.common.CommonTopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FolkDetailsScreen(
    onMenuButtonClick: (() -> Unit)? = null,
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = {
            CommonTopBar(
                title = stringResource(R.string.folk_details),
                onMenuButtonClick = onMenuButtonClick,
                scrollBehavior = scrollBehavior
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        FolkDetailsBody(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun FolkDetailsBody(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.folk_details),
            fontSize = 24.sp
        )
    }
}