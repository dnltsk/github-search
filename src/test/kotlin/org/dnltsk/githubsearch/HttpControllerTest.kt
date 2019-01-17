package org.dnltsk.githubsearch

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest
import java.net.URL

@SpringBootTest
class HttpControllerTest{

    @InjectMocks
    private lateinit var httpController: HttpController

    @Mock
    private lateinit var requestHandler: RequestHandler

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `language query is forwarded to RequestHandler`() {
        val language = "kotlin"
        httpController.getSearch(language)
        verify(requestHandler).searchUser(language)
    }

    @Test
    fun `list of users is surrounded by response object`() {
        val users = listOf(
            User("username", "name", URL("http://link.net"), 0),
            User("username", "name", URL("http://link.net"), 0)
        )
        whenever(requestHandler.searchUser(any())).thenReturn(users)

        val response = httpController.getSearch("dummy-langauge")

        assertThat(response.body!!.users).isEqualTo(users)
    }
}