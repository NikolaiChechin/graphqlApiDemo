package com.nchechin.graphqlApiDemo.clients

import com.nchechin.graphqlApiDemo.model.Item

interface Shop {

    fun buyItem(id: Long): Item

    fun buyItems(ids: List<Long>): List<Item>

}