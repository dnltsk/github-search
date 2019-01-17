package org.dnltsk.githubsearch

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.net.URL

@Service
class RequestHandler {

    @Autowired
    private lateinit var githubWebClient: GithubWebClient

    fun searchUser(language: String): List<User> {
        val githubUsers = githubWebClient.loadUsers(language)

        return githubUsers.map {
            User("username", "user", URL("http://link.net"), 0)
        }

    }

}