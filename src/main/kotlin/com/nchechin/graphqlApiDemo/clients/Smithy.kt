package com.nchechin.graphqlApiDemo.clients

import com.nchechin.graphqlApiDemo.model.Armor
import com.nchechin.graphqlApiDemo.model.Weapon

interface Smithy {

    fun buyArmor(id: Long): Armor

    fun buyArmors(ids: List<Long>): List<Armor>

    fun buyWeapon(id: Long): Weapon

    fun buyWeapons(ids: List<Long>): List<Weapon>

}