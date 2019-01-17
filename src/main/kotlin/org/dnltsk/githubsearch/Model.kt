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

data class GithubSearchUserResponse(
    val items: List<GithubSearchUser>
)
data class GithubSearchUser(
    val login: String
)
data class GithubUserResponse(
    val login: String,
    val followers: Int,
    val name: String,
    val avatar_url: URL
)