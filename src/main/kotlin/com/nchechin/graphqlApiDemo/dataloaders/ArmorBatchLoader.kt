package com.nchechin.graphqlApiDemo.dataloaders

import com.nchechin.graphqlApiDemo.clients.Smithy
import com.nchechin.graphqlApiDemo.model.Armor
import org.dataloader.BatchLoader
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage

@Component
class ArmorBatchLoader(val smithy: Smithy)
    : BatchLoader<Long, Armor> {

    override fun load(keys: List<Long>): CompletionStage<List<Armor?>> =
            CompletableFuture.supplyAsync {
                val armors = smithy.buyArmors(keys)
                return@supplyAsync keys.map { key ->
                    armors.find { it.id == key }
                }
            }
}