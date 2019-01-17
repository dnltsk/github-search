package org.dnltsk.githubsearch

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RequestHandler {

    @Autowired
    private lateinit var githubWebClient: GithubWebClient

    fun searchUser(language: String): List<User> {
        val githubUsers = githubWebClient.loadUsers(language)

        return githubUsers.map {
            User(it.login, it.name, it.avatar_url, it.followers)
        }

    }

}