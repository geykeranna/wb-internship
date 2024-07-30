package ru.wb.ui.ui.component.cards.events

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import ru.wb.domain.model.EventData
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_OF_TAB_ITEM_IN_EVENT_GROUP
import ru.wb.ui.ui.component.utils.Constants.TAB_LABEL_TEXT_SIZE
import ru.wb.ui.ui.component.utils.CustomIndicator
import ru.wb.ui.ui.theme.BrandDefaultColor
import ru.wb.ui.ui.theme.TabUnselectedColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun EventListByGroup (
    navController: NavController,
    modifier: Modifier = Modifier,
    listByGroup: List<List<EventData>> = listOf(),
    tabsList: List<String> = listOf()
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { listByGroup.size })
    val selectedTab = remember { derivedStateOf { pagerState.currentPage } }

    TabRow(
        selectedTabIndex = selectedTab.value,
        modifier = modifier.fillMaxWidth(),
        containerColor = Color.Transparent,
        contentColor = BrandDefaultColor,
        divider = {},
        indicator = @Composable { tabPositions: List<TabPosition> ->
            CustomIndicator(Modifier.tabIndicatorOffset(tabPositions[selectedTab.value]), BrandDefaultColor)
        }
    ) {
        tabsList.forEachIndexed { index, tab ->
            Tab(
                modifier = Modifier
                    .height(HEIGHT_OF_TAB_ITEM_IN_EVENT_GROUP.dp),
                selected = selectedTab.value == index,
                selectedContentColor = BrandDefaultColor,
                unselectedContentColor = TabUnselectedColor,
                onClick = {
                    scope.launch {
                        pagerState.scrollToPage(index)
                    }
                },
            ) {
                Text(
                    text = tab.uppercase(),
                    fontSize = TAB_LABEL_TEXT_SIZE.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }

    HorizontalPager(
        state = pagerState,
        modifier = modifier
            .padding(top = HEIGHT_OF_TAB_ITEM_IN_EVENT_GROUP.dp)
            .fillMaxWidth(),
    ) { page ->
        EventCardsList(
            itemsList = listByGroup[page],
            navController = navController,
        )
    }
}