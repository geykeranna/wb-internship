package ru.testtask.testapplication.ui.component.cards.events

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import ru.testtask.testapplication.data.model.EventsByGroup
import ru.testtask.testapplication.ui.component.utils.CustomIndicator
import ru.testtask.testapplication.ui.theme.BrandDefaultColor
import ru.testtask.testapplication.ui.theme.TabUnselectedColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EventListByGroup(
    modifier: Modifier,
    listByGroup: List<EventsByGroup>,
    navController: NavController,
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { listByGroup.size })
    val selectedTab = remember { derivedStateOf { pagerState.currentPage } }

    Column(modifier = modifier) {
        TabRow(
            selectedTabIndex = selectedTab.value,
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color.Transparent,
            contentColor = BrandDefaultColor,
            divider = {},
            indicator = @Composable { tabPositions: List<TabPosition> ->
                CustomIndicator(Modifier.tabIndicatorOffset(tabPositions[selectedTab.value]), BrandDefaultColor)
            }
        ) {
            listByGroup.forEachIndexed { index, tab ->
                Tab(
                    modifier = Modifier
                        .height(48.dp),
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
                        text = tab.group.uppercase(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
    HorizontalPager(
        state = pagerState,
        modifier = modifier
            .fillMaxWidth(),
    ) { page ->
        val sorted = when (listByGroup[page].group) {
            "Уже прошли" -> SORTBY.NO_ACTIVE
            "Активные" -> SORTBY.ACTIVE
            else -> SORTBY.NO_SORT
        }
        EventCardsList(
            itemsList = listByGroup[page].listOfEvents,
            navController = navController,
            sorted = sorted
        )
    }
}