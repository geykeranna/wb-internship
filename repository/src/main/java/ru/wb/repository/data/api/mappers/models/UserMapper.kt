package ru.wb.repository.data.api.mappers.models

import ru.wb.domain.model.UserData
import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.model.User

internal class UserMapper(
    private val socialMapper: SocialMediaMapper
): Mapper<User, UserData> {
    override fun transformToDomain(data: User): UserData {
        return UserData(
            id = data.id,
            name = data.name,
            icon = data.icon,
            story = data.story,
            status = data.status,
            phone = data.phone,
            socialMedia = data.socialMedia.map { socialMapper.transformToDomain(it) },
            role = data.role,
            description = data.description,
            location = data.location,
            tags = data.tags,
        )
    }

    override fun transformToRepository(data: UserData): User {
        return User(
            id = data.id,
            name = data.name,
            icon = data.icon,
            story = data.story,
            status = data.status,
            phone = data.phone,
            socialMedia = data.socialMedia.map { socialMapper.transformToRepository(it) },
            role = data.role,
            description = data.description,
            location = data.location,
            tags = data.tags,
        )
    }
}