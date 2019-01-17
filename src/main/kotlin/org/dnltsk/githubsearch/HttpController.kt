package org.dnltsk.githubsearch

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HttpController{

    @GetMapping("/search")
    fun getSearch() : ResponseEntity<String>{
        return ResponseEntity.ok("Hi!")
    }

}