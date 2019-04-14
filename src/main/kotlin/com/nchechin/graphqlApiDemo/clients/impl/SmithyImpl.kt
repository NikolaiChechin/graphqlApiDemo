package com.nchechin.graphqlApiDemo.clients.impl

import com.nchechin.graphqlApiDemo.clients.Smithy
import com.nchechin.graphqlApiDemo.model.Armor
import com.nchechin.graphqlApiDemo.model.Weapon
import org.springframework.stereotype.Component

@Component
class SmithyImpl : Smithy {

    private val armors = listOf(getMediumArmor(), getLightArmor(), getHeavyArmor())

    private val weapons = listOf(getSword(), getBow(), getStave())

    override fun buyArmor(id: Long): Armor =
            armors.find { it.id == id }!!

    override fun buyArmors(ids: List<Long>): List<Armor> =
            armors.filter { ids.contains(it.id) }

    override fun buyWeapon(id: Long): Weapon =
            weapons.find { it.id == id }!!

    override fun buyWeapons(ids: List<Long>): List<Weapon> =
            weapons.filter { ids.contains(it.id) }
}