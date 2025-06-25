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
 * This file is created by fankes on 2025/5/19.
 */
@file:Suppress("unused")

package com.highcapable.kavaref.runtime

import android.util.Log
import com.highcapable.kavaref.KavaRef
import com.highcapable.kavaref.extension.hasClass
import com.highcapable.kavaref.generated.KavarefCoreProperties
import org.slf4j.LoggerFactory

/**
 * Runtime class for KavaRef logging.
 */
object KavaRefRuntime {

    private const val TAG = KavarefCoreProperties.PROJECT_NAME

    private val slf4jLogger by lazy { LoggerFactory.getLogger(TAG) }

    private val isAndroidEnv by lazy {
        javaClass.classLoader.hasClass("android.os.Build")
    }

    private var logger: Logger = DefaultLogger()

    /**
     * Log levels for KavaRef.
     * @param levelName the name of the log level.
     */
    enum class LogLevel(val levelName: String) {
        /** DEBUG */
        DEBUG("debug"),

        /** INFO */
        INFO("info"),

        /** WARN */
        WARN("warn"),

        /** ERROR */
        ERROR("error"),

        /** OFF (Turn off logging) */
        OFF("off")
    }

    /**
     * Logger interface for KavaRef.
     *
     * You can implement this interface to create your own logger and set it to [KavaRef.setLogger].
     */
    interface Logger {

        /** Logger tag. */
        val tag: String

        /**
         * Log a debug message.
         * @param msg the message to log.
         * @param throwable an optional throwable to log.
         */
        fun debug(msg: Any?, throwable: Throwable? = null)

        /**
         * Log an info message.
         * @param msg the message to log.
         * @param throwable an optional throwable to log.
         */
        fun info(msg: Any?, throwable: Throwable? = null)

        /**
         * Log a warning message.
         * @param msg the message to log.
         * @param throwable an optional throwable to log.
         */
        fun warn(msg: Any?, throwable: Throwable? = null)

        /**
         * Log an error message.
         * @param msg the message to log.
         * @param throwable an optional throwable to log.
         */
        fun error(msg: Any?, throwable: Throwable? = null)
    }

    /**
     * Default logger implementation for KavaRef.
     *
     * This logger uses SLF4J for non-Android environments and Android Log for Android environments.
     */
    private class DefaultLogger : Logger {

        override val tag = TAG

        override fun debug(msg: Any?, throwable: Throwable?) {
            if (!isAndroidEnv)
                slf4jLogger.debug(msg.toString(), throwable)
            else Log.d(TAG, msg.toString(), throwable)
        }

        override fun info(msg: Any?, throwable: Throwable?) {
            if (!isAndroidEnv)
                slf4jLogger.info(msg.toString(), throwable)
            else Log.i(TAG, msg.toString(), throwable)
        }

        override fun warn(msg: Any?, throwable: Throwable?) {
            if (!isAndroidEnv)
                slf4jLogger.warn(msg.toString(), throwable)
            else Log.w(TAG, msg.toString(), throwable)
        }

        override fun error(msg: Any?, throwable: Throwable?) {
            if (!isAndroidEnv)
                slf4jLogger.error(msg.toString(), throwable)
            else Log.e(TAG, msg.toString(), throwable)
        }
    }

    /**
     * Get or set the log level for KavaRef.
     *
     * Use [KavaRef.logLevel] to control it.
     * @see KavaRef.logLevel
     * @return [LogLevel]
     */
    @get:JvmSynthetic
    @set:JvmSynthetic
    internal var logLevel = LogLevel.WARN
        set(value) {
            if (!isAndroidEnv)
                // Enable level for SLF4J.
                System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", value.levelName)

            field = value
        }

    /**
     * Set the logger for KavaRef.
     *
     * Use [KavaRef.setLogger] to control it.
     * @see KavaRef.setLogger
     * @param logger the logger to be set.
     */
    @JvmSynthetic
    internal fun setLogger(logger: Logger) {
        this.logger = logger
    }

    init {
        // Initialize the log level to WARN if not set.
        logLevel = logLevel
    }

    /**
     * DEBUG
     */
    @JvmSynthetic
    internal fun debug(msg: Any?, throwable: Throwable? = null) {
        if (shouldLog(LogLevel.DEBUG)) logger.debug(msg, throwable)
    }

    /**
     * INFO
     */
    @JvmSynthetic
    internal fun info(msg: Any?, throwable: Throwable? = null) {
        if (shouldLog(LogLevel.INFO)) logger.info(msg, throwable)
    }

    /**
     * WARN
     */
    @JvmSynthetic
    internal fun warn(msg: Any?, throwable: Throwable? = null) {
        if (shouldLog(LogLevel.WARN)) logger.warn(msg, throwable)
    }

    /**
     * ERROR
     */
    @JvmSynthetic
    internal fun error(msg: Any?, throwable: Throwable? = null) {
        if (shouldLog(LogLevel.ERROR)) logger.error(msg, throwable)
    }

    private fun shouldLog(level: LogLevel) = logLevel.ordinal <= level.ordinal
}