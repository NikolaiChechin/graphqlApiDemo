package com.nchechin.graphqlApiDemo

import com.graphql.spring.boot.test.GraphQLTestTemplate
import com.nchechin.graphqlApiDemo.clients.Smithy
import com.nchechin.graphqlApiDemo.clients.Tavern
import com.nchechin.graphqlApiDemo.clients.Shop
import com.nchechin.graphqlApiDemo.clients.impl.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import com.nhaarman.mockitokotlin2.reset
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions.*


@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QueryTest {

    @MockBean
    lateinit var smithy: Smithy

    @MockBean
    lateinit var tavern: Tavern

    @MockBean
    lateinit var shop: Shop

    @Autowired
    lateinit var graphQLTestTemplate: GraphQLTestTemplate

    @BeforeEach
    fun init() {
        reset(
                smithy,
                tavern,
                shop
        )
    }

    @Test
    fun `service returns a character`() {
        //setup:
        val paladin = getPaladin()
        val ranger = getRanger()
        val wizard = getWizard()
        val characters = listOf(paladin, ranger, wizard)
        val characterIds = characters.map { it.id }

        val lightArmor = getLightArmor()
        val mediumArmor = getMediumArmor()
        val heavyArmor = getHeavyArmor()
        val armors = listOf(lightArmor, mediumArmor, heavyArmor)
        val armorIds = armors.map { it.id }

        val sword = getSword()
        val bow = getBow()
        val stave = getStave()
        val weapons = listOf(sword, bow, stave)
        val weaponIds = weapons.map { it.id }

        val healthPotion = getHealthPotion()
        val spellScroll = getSpellScroll()
        val items = listOf(healthPotion, spellScroll)
        val itemIds = items.map { it.id }

        val result = "{\"data\":{\"hireCharactersByIds\":[{\"id\":1,\"characterClass\":\"PALADIN\",\"level\":5,\"strength\":10,\"dexterity\":5,\"wisdom\":3,\"weapon\":{\"id\":1,\"type\":\"SWORD\",\"damage\":10},\"armor\":null,\"inventory\":[{\"id\":1,\"type\":\"HEALTH_POTION\",\"weight\":1}]},{\"id\":3,\"characterClass\":\"RANGER\",\"level\":5,\"strength\":5,\"dexterity\":10,\"wisdom\":3,\"weapon\":{\"id\":2,\"type\":\"BOW\",\"damage\":3},\"armor\":null,\"inventory\":[{\"id\":1,\"type\":\"HEALTH_POTION\",\"weight\":1},{\"id\":2,\"type\":\"SPELL_SCROLL\",\"weight\":1}]},{\"id\":2,\"characterClass\":\"WIZARD\",\"level\":5,\"strength\":3,\"dexterity\":5,\"wisdom\":10,\"weapon\":{\"id\":3,\"type\":\"STAVE\",\"damage\":5},\"armor\":null,\"inventory\":[{\"id\":2,\"type\":\"SPELL_SCROLL\",\"weight\":1}]}]}}"

        whenever(smithy.buyArmors(armorIds)).thenReturn(armors)
        whenever(tavern.hireCharactersByIds(characterIds)).thenReturn(characters)
        whenever(smithy.buyWeapons(weaponIds)).thenReturn(weapons)
        whenever(shop.buyItems(itemIds)).thenReturn(items)

        //when:
        val response = graphQLTestTemplate.perform("graphql/getCharacters.graphqls",
                CharactersQueryParams(characterIds).toObjectNode())

        //then:
        assertNotNull(response)
        assertEquals(response.readTree().toString(), result)
    }
}