package com.nchechin.graphqlApiDemo.utils

import kotlin.reflect.KClass

/**
 * Binds data class with data loader
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class GetWithDataLoader(val clazz: KClass<*>)