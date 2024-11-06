package ru.wb.ui.utils.mappers

import ru.wb.domain.model.CommunityData
import ru.wb.domain.model.CommunityItemData

internal class CommunityToCommunityItemMapper: Mapper<CommunityData, CommunityItemData> {
    override fun transformTo(data: CommunityData): CommunityItemData {
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

    override fun transformFrom(data: CommunityItemData): CommunityData {
        return CommunityData(
            id = data.id,
            label = data.label,
            description = data.description,
            icon = data.icon,
            isVerified = data.isVerified,
            isSubscribed = data.isSubscribed,
            tags = data.tags,
            lastEvent = listOf(),
            subscribers = listOf(),
            eventList = listOf(),
        )
    }
}
