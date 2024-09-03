package ru.wb.ui.ui.component.utils

import ru.wb.ui.R
import ru.wb.ui.ui.component.chips.ChipsData

internal val defaultSocialMediaMap = mapOf (
    "telegram" to R.drawable.ic_telegram,
    "twitter" to R.drawable.ic_twitter,
    "instagram" to R.drawable.ic_instagram,
    "facebook" to R.drawable.ic_facebook,
    "habr" to R.drawable.ic_habr,
)

internal val defaultChipsList = listOf(
    ChipsData(id = "design", name = "Дизайн"),
    ChipsData(id = "developer", name = "Разработка"),
    ChipsData(id = "pm", name = "Продакт менеджмент"),
    ChipsData(id = "backend", name = "Backend"),
    ChipsData(id = "frontend", name = "Frontend"),
    ChipsData(id = "mobile", name = "Mobile"),
    ChipsData(id = "web", name = "Web"),
    ChipsData(id = "testing", name = "Тестирование"),
    ChipsData(id = "sales", name = "Продажи"),
    ChipsData(id = "business", name = "Бизнес"),
    ChipsData(id = "marketing", name = "Маркетинг"),
    ChipsData(id = "security", name = "Безопасность"),
    ChipsData(id = "devops", name = "Девопс"),
    ChipsData(id = "analytics", name = "Аналитика"),
    ChipsData(id = "actions", name = "+ Добавить"),
)