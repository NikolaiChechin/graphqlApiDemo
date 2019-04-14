package com.nchechin.graphqlApiDemo

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode

open class GraphqlQueryParams {
    fun toObjectNode(): ObjectNode = ObjectMapper().valueToTree(this)
}

data class CharactersQueryParams(
        val characterIds: List<Long>
) : GraphqlQueryParams()