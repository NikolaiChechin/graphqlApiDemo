package com.nchechin.graphqlApiDemo.config

import graphql.servlet.GraphQLContext
import graphql.servlet.GraphQLContextBuilder
import org.dataloader.BatchLoader
import org.dataloader.DataLoader
import org.dataloader.DataLoaderRegistry
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.websocket.Session
import javax.websocket.server.HandshakeRequest

@Component
class CustomGraphQLContextBuilder(val batchLoaders: Map<String, BatchLoader<*, *>>) : GraphQLContextBuilder {

    override fun build(request: HttpServletRequest?, response: HttpServletResponse?): GraphQLContext {
        val graphQLContext = GraphQLContext(request, response)
        graphQLContext.setDataLoaderRegistry(getDataLoaderRegistry())
        return graphQLContext
    }

    override fun build(session: Session?, handshakeRequest: HandshakeRequest?): GraphQLContext {
        val graphQLContext = GraphQLContext(session, handshakeRequest)
        graphQLContext.setDataLoaderRegistry(getDataLoaderRegistry())
        return graphQLContext
    }

    override fun build(): GraphQLContext {
        val graphQLContext = GraphQLContext()
        graphQLContext.setDataLoaderRegistry(getDataLoaderRegistry())
        return graphQLContext
    }

    fun getDataLoaderRegistry(): DataLoaderRegistry {
        val registry = DataLoaderRegistry()
        batchLoaders.forEach { name, bean ->
            registry.register(name, DataLoader.newDataLoader(bean))
        }
        return registry
    }

}