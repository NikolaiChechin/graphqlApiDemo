package com.nchechin.graphqlApiDemo.model

import com.nchechin.graphqlApiDemo.dataloaders.WeaponBatchLoader
import com.nchechin.graphqlApiDemo.utils.GetWithDataLoader

@GetWithDataLoader(WeaponBatchLoader::class)
data class Weapon(
        val id: Long,
        val type: WeaponType,
        val damage: Int
)

enum class WeaponType {
    SWORD,
    BOW,
    STAVE
}
