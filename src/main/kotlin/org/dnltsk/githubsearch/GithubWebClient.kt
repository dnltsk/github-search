package org.dnltsk.githubsearch

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class GithubWebClient {

    @Autowired
    private lateinit var githubRequester: GithubRequester

    fun loadUsers(language: String): List<GithubUserResponse> {

        val searchResponse = githubRequester.requestSearch(language)

        if (searchResponse == null || searchResponse.items.isEmpty()) {
            return emptyList()
        }

        return searchResponse.items.map {
            githubRequester.requestUser(it.login)
        }
    }

}

@Service
class GithubRequester {

    @Autowired
    private lateinit var restTemplate: RestTemplate

    fun requestSearch(language: String): GithubSearchUserResponse? {
        return restTemplate.getForObject("https://api.github.com/search/users?q=language:$language&page=1&per_page=5", GithubSearchUserResponse::class.java)
    }

    fun requestUser(login: String): GithubUserResponse {
        return restTemplate.getForObject("https://api.github.com/users/$login", GithubUserResponse::class.java)!!
    }


}