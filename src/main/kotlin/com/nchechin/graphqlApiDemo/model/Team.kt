package com.nchechin.graphqlApiDemo.model

data class Team(
        val id: Long,
        val name: String,
        val characters: List<Character>
)