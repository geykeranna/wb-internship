package ru.wb.repository.data.api.mappers.models

import ru.wb.domain.model.UserItemsData
import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.model.UserItem

internal class UserItemsMapper: Mapper<UserItem, UserItemsData> {
    override fun transformToDomain(data: UserItem): UserItemsData {
        return UserItemsData(
            id = data.id,
            name = data.name,
            icon = data.icon,
            story = data.story,
            status = data.status,
            role = data.role,
            description = data.description,
        )
    }

    override fun transformToRepository(data: UserItemsData): UserItem {
        return UserItem(
            id = data.id,
            name = data.name,
            icon = data.icon,
            story = data.story,
            status = data.status,
            role = data.role,
            description = data.description,
        )
    }
}