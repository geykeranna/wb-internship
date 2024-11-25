package ru.wb.ui.ui.screens.profile.delete

import ru.wb.domain.usecases.user.DeleteUserListUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseViewModel

internal class DeleteProfileViewScreenViewModel(
    private val deleteUser: DeleteUserListUseCase,
): BaseViewModel<DeleteProfileViewScreenViewModel.Event>() {
    private fun deleteUser() {
        deleteUser.execute()
    }

    sealed class Event : BaseEvent() {
        data object OnDeleteUser : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnDeleteUser -> {
                deleteUser()
            }
        }
    }
}