package com.nchechin.graphqlApiDemo.dataloaders

import com.nchechin.graphqlApiDemo.clients.Smithy
import com.nchechin.graphqlApiDemo.model.Weapon
import org.dataloader.BatchLoader
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage

@Component
class WeaponBatchLoader(val smithy: Smithy) : BatchLoader<Long, Weapon> {

    override fun load(keys: List<Long>): CompletionStage<List<Weapon?>> =
            CompletableFuture.supplyAsync {
                val weapons = smithy.buyWeapons(keys)
                return@supplyAsync keys.map { key ->
                    weapons.find { it.id == key }
                }
            }
}