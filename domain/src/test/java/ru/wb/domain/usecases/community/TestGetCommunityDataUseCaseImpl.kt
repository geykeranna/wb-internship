package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.CommunityRepositoryStubs

class TestGetCommunityDataUseCaseImpl {
    private val testRepository = CommunityRepositoryStubs()

    @Test
    fun `should return the same community data as in repo`() = runTest {
        val useCase = GetCommunityDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(id = "1").last()

        Assertions.assertTrue(
            actual.id.isNotEmpty()
            && actual.label.isNotEmpty()
            && actual.countPeople > 0
            && actual.description.isNotEmpty()
        )
    }
}