package org.dnltsk.githubsearch

import org.springframework.stereotype.Service
import java.net.URL

@Service
class RequestHandler{

    fun searchUser(language: String): List<User> {
        return listOf(
            User("username", "name", URL("http://link.net"), 0),
            User("username", "name", URL("http://link.net"), 0)
        )
    }

}