package com.nchechin.graphqlApiDemo.dataloaders

import com.nchechin.graphqlApiDemo.clients.Shop
import com.nchechin.graphqlApiDemo.model.Item
import org.dataloader.BatchLoader
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage

@Component
class ItemBatchLoader(val shop: Shop) : BatchLoader<Long, Item> {

    override fun load(keys: List<Long>): CompletionStage<List<Item?>> =
            CompletableFuture.supplyAsync {
                val items = shop.buyItems(keys)
                return@supplyAsync keys.map { key ->
                    items.find { it.id == key }
                }
            }
}