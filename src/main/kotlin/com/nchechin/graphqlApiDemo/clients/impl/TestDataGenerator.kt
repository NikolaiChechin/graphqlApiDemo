package com.nchechin.graphqlApiDemo.clients.impl

import com.nchechin.graphqlApiDemo.model.*

fun getPaladin() = Character(
        id = 1L,
        characterClass = CharacterClass.PALADIN,
        level = 5,
        strength = 10,
        dexterity = 5,
        wisdom = 3,
        armorId = 1L,
        weaponId = 1L,
        inventory = listOf(1L)
)

fun getWizard() = Character(
        id = 2L,
        characterClass = CharacterClass.WIZARD,
        level = 5,
        strength = 3,
        dexterity = 5,
        wisdom = 10,
        armorId = 3L,
        weaponId = 3L,
        inventory = listOf(2L)
)

fun getRanger() = Character(
        id = 3L,
        characterClass = CharacterClass.RANGER,
        level = 5,
        strength = 5,
        dexterity = 10,
        wisdom = 3,
        armorId = 2L,
        weaponId = 2L,
        inventory = listOf(1L, 2L)
)

fun getHeavyArmor() = Armor(
        id = 1L,
        type = ArmorType.HEAVY,
        defense = 10
)

fun getMediumArmor() = Armor(
        id = 2L,
        type = ArmorType.MEDIUM,
        defense = 5
)

fun getLightArmor() = Armor(
        id = 3L,
        type = ArmorType.LIGHT,
        defense = 3
)

fun getSword() = Weapon(
        id = 1L,
        type = WeaponType.SWORD,
        damage = 10
)

fun getBow() = Weapon(
        id = 2L,
        type = WeaponType.BOW,
        damage = 3
)

fun getStave() = Weapon(
        id = 3L,
        type = WeaponType.STAVE,
        damage = 5
)

fun getHealthPotion() = Item(
        id = 1L,
        type = ItemType.HEALTH_POTION,
        weight = 1
)

fun getSpellScroll() = Item(
        id = 2L,
        type = ItemType.SPELL_SCROLL,
        weight = 1
)