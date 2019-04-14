package com.nchechin.graphqlApiDemo.model

import com.nchechin.graphqlApiDemo.dataloaders.ItemBatchLoader
import com.nchechin.graphqlApiDemo.utils.GetWithDataLoader

@GetWithDataLoader(ItemBatchLoader::class)
data class Item(
        val id: Long,
        val type: ItemType,
        val weight: Int
)

enum class ItemType {
    HEALTH_POTION,
    SPELL_SCROLL
}
