package org.dnltsk.githubsearch

import com.fasterxml.jackson.databind.ObjectMapper
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
class GithubWebClientTest {

    @InjectMocks
    private lateinit var webClient: GithubWebClient

    @Mock
    private lateinit var githubRequester: GithubRequester

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    private lateinit var sampleSearchResponse: GithubSearchUserResponse
    private lateinit var sampleUserResponse: GithubUserResponse

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        sampleSearchResponse = objectMapper.readValue(javaClass.getClassLoader().getResource("sample-search-response.js"), GithubSearchUserResponse::class.java)
        sampleUserResponse = objectMapper.readValue(javaClass.getClassLoader().getResource("sample-user-response.js"), GithubUserResponse::class.java)

        whenever(githubRequester.requestSearch(any()))
            .thenReturn(sampleSearchResponse)
        whenever(githubRequester.requestUser(any()))
            .thenReturn(sampleUserResponse)
    }

    @Test
    fun `all users from search are converted as user`() {
        val users = webClient.loadUsers("dummy-language")
        assertThat(users).hasSameSizeAs(sampleSearchResponse.items)
    }

}