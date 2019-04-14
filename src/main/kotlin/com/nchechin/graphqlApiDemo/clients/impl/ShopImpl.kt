package com.nchechin.graphqlApiDemo.clients.impl

import com.nchechin.graphqlApiDemo.clients.Shop
import com.nchechin.graphqlApiDemo.model.Item
import org.springframework.stereotype.Component

@Component
class ShopImpl: Shop {

    private val items = listOf(getHealthPotion(), getSpellScroll())

    override fun buyItem(id: Long): Item =
            items.find { it.id == id }!!

    override fun buyItems(ids: List<Long>): List<Item> =
        items.filter { ids.contains(it.id) }
}