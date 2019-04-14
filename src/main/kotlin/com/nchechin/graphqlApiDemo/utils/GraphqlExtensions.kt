package com.nchechin.graphqlApiDemo.utils

import graphql.schema.DataFetchingEnvironment
import graphql.servlet.GraphQLContext
import org.dataloader.DataLoader
import java.util.concurrent.CompletableFuture
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation

inline fun <T, reified K> DataFetchingEnvironment.load(key: T): CompletableFuture<K> {
    return dataLoader<T, K>().load(key)
}

inline fun <T, reified K> DataFetchingEnvironment.loadMany(keys: List<T>): CompletableFuture<List<K>> {
    return dataLoader<T, K>().loadMany(keys)
}

inline fun <T, reified K> DataFetchingEnvironment.dataLoader(): DataLoader<T, K> =
        getContext<GraphQLContext>().dataLoaderRegistry.get()
                .getDataLoader<T, K>(getDataLoaderName(K::class))

fun getDataLoaderName(clazz: KClass<*>): String =
        clazz.findAnnotation<GetWithDataLoader>()?.clazz?.simpleName?.decapitalize()
                ?: throw IllegalArgumentException("No data loader found for class ${clazz.simpleName}")