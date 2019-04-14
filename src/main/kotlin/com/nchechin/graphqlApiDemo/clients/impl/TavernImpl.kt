package com.nchechin.graphqlApiDemo.clients.impl

import com.nchechin.graphqlApiDemo.clients.Tavern
import com.nchechin.graphqlApiDemo.model.Character
import com.nchechin.graphqlApiDemo.model.CharacterClass
import org.springframework.stereotype.Component

@Component
class TavernImpl : Tavern {

    private val characters = listOf(getPaladin(), getWizard(), getRanger())

    override fun hireCharacter(id: Long): Character =
            characters.find { it.id == id }!!

    override fun hireCharactersByIds(ids: List<Long>): List<Character> =
            characters.filter { ids.contains(it.id) }

    override fun hireCharactersByClasses(classes: List<CharacterClass>): List<Character> =
            characters.filter { classes.contains(it.characterClass) }
}