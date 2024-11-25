package ru.wb.ui.utils.mappers

import ru.wb.domain.model.UserData
import ru.wb.domain.model.UserItemsData

internal class UserToUserItemMapper: Mapper<UserData, UserItemsData> {
    override fun transformTo(data: UserData): UserItemsData {
        return UserItemsData(
            id = data.id,
            name = data.name,
            icon = data.icon,
            story = data.story,
            status = data.status,
            role = data.role,
        )
    }

    override fun transformFrom(data: UserItemsData): UserData {
        return UserData(
            id = data.id,
            name = data.name,
            icon = data.icon,
            story = data.story,
            status = data.status,
            role = data.role,
            phone = "",
            socialMedia = listOf(),
            description = "",
            location = "",
            tags = listOf(),
        )
    }
}
