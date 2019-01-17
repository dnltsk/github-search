package org.dnltsk.githubsearch

import java.net.URL

data class SearchResponse(
    val users: List<User>
)

data class User(
    val username: String,
    val name: String,
    val avatarUrl: URL,
    val numberOfFollowers: Int
)