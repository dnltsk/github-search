package org.dnltsk.githubsearch

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HttpController{

    @Autowired
    private lateinit var requestHandler: RequestHandler

    @GetMapping("/search")
    fun getSearch(
        @RequestParam language: String
    ) : ResponseEntity<SearchResponse>{
        val users = requestHandler.searchUser(language)
        return ResponseEntity.ok(SearchResponse(users))
    }

}