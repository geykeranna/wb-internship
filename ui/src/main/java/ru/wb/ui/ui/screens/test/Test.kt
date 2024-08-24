package ru.wb.ui.ui.screens.test

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.wb.ui.ui.component.avatars.UserAvatar
import ru.wb.ui.ui.component.cards.Owner
import ru.wb.ui.ui.component.cards.OwnerCard
import ru.wb.ui.ui.component.cards.visitors.AvatarsSize
import ru.wb.ui.ui.component.chips.ChipsGroup
import ru.wb.ui.ui.component.chips.ChipsMode
import ru.wb.ui.ui.component.chips.TagsChips
import ru.wb.ui.ui.component.toolbars.TopBarDetail
import ru.wb.ui.ui.component.toolbars.TopBarMain

@Composable
fun Test() {
    val viewModel = TestViewModel()

    val selectedChipsSingleList by viewModel.getChipsSingleFlow().collectAsStateWithLifecycle()
    val selectedChipsMultipleList by viewModel.getChipsMultipleFlow().collectAsStateWithLifecycle()
    val text by viewModel.getTextFlow().collectAsStateWithLifecycle()

    val mod = Modifier.padding(vertical = 10.dp)

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            TopBarMain(
                modifier = Modifier.padding(horizontal = 10.dp),
                inputText = text,
                onChangeValue = {text -> viewModel.onTextChange(text)}
            )
        }

        item {
            TopBarDetail(
                modifier = Modifier.padding(horizontal = 10.dp),
                title = text,
            )
        }

        item {
            OwnerCard(
                title = "The IT-Crowd",
                description = "Сообщество профессионалов в сфере IT. Объединяем специалистов разных направлений для обмена опытом, знаниями и идеями.",
                owner = Owner.COMMUNITY,
            ) {
                UserAvatar(size = AvatarsSize.SQUARE)
            }
        }

        item {
            ChipsGroup(
                modifier = mod,
                data = viewModel.chipsList,
            )
        }

        item {
            ChipsGroup(
                modifier = mod,
                data = viewModel.chipsList,
                selectedList = selectedChipsSingleList,
                mode = ChipsMode.SINGLE
            ) { newList -> viewModel.onSelectChipsSingle(newList)}
        }

        item {
            ChipsGroup(
                modifier = mod,
                data = viewModel.chipsList,
                selectedList = selectedChipsMultipleList,
                mode = ChipsMode.MULTIPLE
            ) { newList -> viewModel.onSelectChipsMultiple(newList) }
        }

        item {
            TagsChips(
                data = viewModel.chipsList,
                modifier = mod
            )
        }
    }
}