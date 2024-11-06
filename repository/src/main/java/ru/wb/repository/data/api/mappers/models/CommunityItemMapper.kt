package ru.wb.repository.data.api.mappers.models

import ru.wb.domain.model.CommunityItemData
import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.model.CommunityItem

internal class CommunityItemMapper: Mapper<CommunityItem, CommunityItemData>{
    override fun transformToDomain(data: CommunityItem): CommunityItemData {
        return CommunityItemData(
            id = data.id,
            label = data.label,
            description = data.description,
            icon = data.icon,
            isVerified = data.isVerified,
            isSubscribed = data.isSubscribed,
            tags = data.tags,
        )
    }

    override fun transformToRepository(data: CommunityItemData): CommunityItem {
        return CommunityItem(
            id = data.id,
            label = data.label,
            description = data.description,
            icon = data.icon,
            isVerified = data.isVerified,
            isSubscribed = data.isSubscribed,
            tags = data.tags,
        )
    }
}
