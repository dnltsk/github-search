package org.dnltsk.githubsearch

import com.fasterxml.jackson.databind.ObjectMapper
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.net.URL

@SpringBootTest
@RunWith(SpringRunner::class)
class RequestHandlerTest{

    @InjectMocks
    private lateinit var requestHandler: RequestHandler

    @Mock
    private lateinit var webClient: GithubWebClient

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    private lateinit var sampleUserResponse: GithubUserResponse

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        sampleUserResponse = objectMapper.readValue(javaClass.getClassLoader().getResource("sample-user-response.js"), GithubUserResponse::class.java)

        whenever(webClient.loadUsers(any())).thenReturn(listOf(sampleUserResponse))
    }

    @Test
    fun `conversion of github user working fine`() {
        val users = requestHandler.searchUser("dummy-language")

        Assertions.assertThat(users[0]).isEqualToComparingFieldByField(
            User(
                username = "kittinunf",
                name = "Kittinun Vantasin",
                avatarUrl = URL("https://avatars1.githubusercontent.com/u/4669517?v=4"),
                numberOfFollowers = 288
            )
        )

    }

}