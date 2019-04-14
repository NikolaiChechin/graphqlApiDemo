package com.nchechin.graphqlApiDemo.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.nchechin.graphqlApiDemo.clients.Tavern
import com.nchechin.graphqlApiDemo.model.Character
import com.nchechin.graphqlApiDemo.model.CharacterClass
import org.springframework.stereotype.Component

@Component
class QueryResolver(val tavern: Tavern)
    : GraphQLQueryResolver {

    fun hireCharacter(id: Long): Character
            = tavern.hireCharacter(id)

    fun hireCharactersByIds(ids: List<Long>): List<Character>
            = tavern.hireCharactersByIds(ids)

    fun hireCharactersByClasses(classes: List<CharacterClass>)
            = tavern.hireCharactersByClasses(classes)

}