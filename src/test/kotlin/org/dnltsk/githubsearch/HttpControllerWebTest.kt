package org.dnltsk.githubsearch

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus.OK
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class HttpControllerWebTest{

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun `search endpoint responds with 200OK`() {
        val response = restTemplate.getForEntity("/search?language=kotlin", SearchResponse::class.java)
        assertThat(response.statusCode).isEqualTo(OK)
    }
}