package com.nchechin.graphqlApiDemo.model

data class Character(
        val id: Long,
        val characterClass: CharacterClass,
        val level: Int,
        val strength: Int,
        val dexterity: Int,
        val wisdom: Int,
        val weaponId: Long,
        val armorId: Long,
        val inventory: List<Long>
)

enum class CharacterClass {
    PALADIN,
    WIZARD,
    RANGER
}
