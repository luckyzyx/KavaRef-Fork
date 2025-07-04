/*
 * KavaRef - A modernizing Java Reflection with Kotlin.
 * Copyright (C) 2019 HighCapable
 * https://github.com/HighCapable/KavaRef
 *
 * Apache License Version 2.0
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * This file is created by fankes on 2025/5/20.
 */
package com.highcapable.kavaref.condition.matcher

import com.highcapable.kavaref.condition.matcher.base.TypeMatcher
import java.lang.reflect.GenericArrayType
import java.lang.reflect.Type

/**
 * A [TypeMatcher] that matches a generic array type.
 * @see GenericArrayType.getGenericComponentType
 * @see Class.getComponentType
 * @param componentMatcher the [TypeMatcher] for the component type of the array.
 */
data class GenericArrayTypeMatcher(
    val componentMatcher: TypeMatcher
) : TypeMatcher {

    override fun matches(type: Type) = when (type) {
        is GenericArrayType -> componentMatcher.matches(type.genericComponentType)
        is Class<*> -> type.isArray && componentMatcher.matches(type.componentType)
        else -> false
    }
}