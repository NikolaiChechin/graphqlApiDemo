package com.nchechin.graphqlApiDemo.resolvers

import com.coxautodev.graphql.tools.GraphQLResolver
import com.nchechin.graphqlApiDemo.clients.Shop
import com.nchechin.graphqlApiDemo.clients.Smithy
import com.nchechin.graphqlApiDemo.model.Armor
import com.nchechin.graphqlApiDemo.model.Character
import com.nchechin.graphqlApiDemo.model.Item
import com.nchechin.graphqlApiDemo.model.Weapon
import com.nchechin.graphqlApiDemo.utils.load
import com.nchechin.graphqlApiDemo.utils.loadMany
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component
class CharacterResolver() : GraphQLResolver<Character> {

    fun getArmor(character: Character, dfe: DataFetchingEnvironment)
            : CompletableFuture<Armor> =
            dfe.load(character.armorId)

    fun getWeapon(character: Character, dfe: DataFetchingEnvironment): CompletableFuture<Weapon> =
            dfe.load(character.weaponId)

    fun getInventory(character: Character, dfe: DataFetchingEnvironment): CompletableFuture<List<Item>> =
            dfe.loadMany(character.inventory)

}