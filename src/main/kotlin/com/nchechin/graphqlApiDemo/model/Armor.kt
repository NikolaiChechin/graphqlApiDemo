package com.nchechin.graphqlApiDemo.model

import com.nchechin.graphqlApiDemo.dataloaders.ArmorBatchLoader
import com.nchechin.graphqlApiDemo.utils.GetWithDataLoader

@GetWithDataLoader(ArmorBatchLoader::class)
data class Armor(
        val id: Long,
        val type: ArmorType,
        val defense: Int
)

enum class ArmorType {
    LIGHT,
    MEDIUM,
    HEAVY
}
