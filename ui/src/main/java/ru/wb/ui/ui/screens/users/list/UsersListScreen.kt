package ru.wb.ui.ui.screens.users.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import ru.wb.ui.ui.base.BaseScreen
import ru.wb.ui.ui.component.cards.visitors.UserShortCard
import ru.wb.ui.ui.component.toolbars.TopBarDetail
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON
import ru.wb.ui.ui.theme.AppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun UsersListByEventScreen(
    data: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    detailViewModel: UsersListScreenViewModel = koinViewModel(parameters = { parametersOf(data) })
) {
    val state by detailViewModel.getStateFlow().collectAsStateWithLifecycle()
    val usersListLabel by detailViewModel.getUserListLabelFlow().collectAsStateWithLifecycle()
    val dataList by detailViewModel.getDataListFlow().collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp),
        containerColor = AppTheme.colors.neutralColorBackground,
        topBar = {
            TopBarDetail(
                modifier = Modifier,
                title = usersListLabel.label,
                onBackClick = { navController.popBackStack() },
                rightIconVisible = false,
            )
        },
    ) { padding ->
        BaseScreen(
            modifier = Modifier.padding(padding),
            state = state,
        ){
            FlowRow(
                modifier = modifier.fillMaxSize().padding(top = 32.dp),
                verticalArrangement = Arrangement.spacedBy(25.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                dataList.forEach { user ->
                    UserShortCard(
                        userData = user,
                    )
                }
            }
        }
    }
}