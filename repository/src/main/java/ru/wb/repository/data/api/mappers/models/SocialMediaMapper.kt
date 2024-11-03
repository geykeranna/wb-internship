package ru.wb.repository.data.api.mappers.models

import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.model.SocialMedia

internal class SocialMediaMapper: Mapper<SocialMedia, ru.wb.domain.model.SocialMedia> {
    override fun transformToDomain(data: SocialMedia): ru.wb.domain.model.SocialMedia {
        return ru.wb.domain.model.SocialMedia(
            id = data.id,
            name = data.name,
            baseUrl = data.baseUrl,
            url = data.url
        )
    }

    override fun transformToRepository(data: ru.wb.domain.model.SocialMedia): SocialMedia {
        return SocialMedia(
            id = data.id,
            name = data.name,
            baseUrl = data.baseUrl,
            url = data.url
        )
    }
}