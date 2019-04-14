package com.nchechin.graphqlApiDemo.clients

import com.nchechin.graphqlApiDemo.model.Character
import com.nchechin.graphqlApiDemo.model.CharacterClass

interface Tavern {

    fun hireCharacter(id: Long): Character

    fun hireCharactersByIds(ids: List<Long>): List<Character>

    fun hireCharactersByClasses(classes: List<CharacterClass>): List<Character>

}