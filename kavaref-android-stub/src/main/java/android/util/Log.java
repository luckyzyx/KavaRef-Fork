/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.util;

/**
 * API for sending log output.
 *
 * <p>Generally, you should use the {@link #v Log.v()}, {@link #d Log.d()},
 * {@link #i Log.i()}, {@link #w Log.w()}, and {@link #e Log.e()} methods to write logs.
 * You can then <a href="{@docRoot}studio/debug/am-logcat.html">view the logs in logcat</a>.
 *
 * <p>The order in terms of verbosity, from least to most is
 * ERROR, WARN, INFO, DEBUG, VERBOSE.
 *
 * <p><b>Tip:</b> A good convention is to declare a <code>TAG</code> constant
 * in your class:
 *
 * <pre>private static final String TAG = "MyActivity";</pre>
 * <p>
 * and use that in subsequent calls to the log methods.
 * </p>
 *
 * <p><b>Tip:</b> Don't forget that when you make a call like
 * <pre>Log.v(TAG, "index=" + i);</pre>
 * that when you're building the string to pass into Log.d, the compiler uses a
 * StringBuilder and at least three allocations occur: the StringBuilder
 * itself, the buffer, and the String object.  Realistically, there is also
 * another buffer allocation and copy, and even more pressure on the gc.
 * That means that if your log message is filtered out, you might be doing
 * significant work and incurring significant overhead.
 *
 * <p>When calling the log methods that take a Throwable parameter,
 * if any of the throwables in the cause chain is an <code>UnknownHostException</code>,
 * then the stack trace is not logged.
 *
 * <p>Note: The return value from the logging functions in this class may vary between Android
 * releases due to changes in the logging implementation. For the methods that return an integer,
 * a positive value may be considered as a successful invocation.
 */
@SuppressWarnings("ALL")
public final class Log {

    private Log() {
    }

    public static int v(String tag, String msg) {
        throw new RuntimeException("Stub!");
    }

    public static int v(String tag, String msg, Throwable tr) {
        throw new RuntimeException("Stub!");
    }

    public static int d(String tag, String msg) {
        throw new RuntimeException("Stub!");
    }

    public static int d(String tag, String msg, Throwable tr) {
        throw new RuntimeException("Stub!");
    }

    public static int i(String tag, String msg) {
        throw new RuntimeException("Stub!");
    }

    public static int i(String tag, String msg, Throwable tr) {
        throw new RuntimeException("Stub!");
    }

    public static int w(String tag, String msg) {
        throw new RuntimeException("Stub!");
    }

    public static int w(String tag, String msg, Throwable tr) {
        throw new RuntimeException("Stub!");
    }

    public static int w(String tag, Throwable tr) {
        throw new RuntimeException("Stub!");
    }

    public static int e(String tag, String msg) {
        throw new RuntimeException("Stub!");
    }

    public static int e(String tag, String msg, Throwable tr) {
        throw new RuntimeException("Stub!");
    }

    public static int wtf(String tag, String msg) {
        throw new RuntimeException("Stub!");
    }

    public static int wtfStack(String tag, String msg) {
        throw new RuntimeException("Stub!");
    }

    public static int wtf(String tag, Throwable tr) {
        throw new RuntimeException("Stub!");
    }

    public static int wtf(String tag, String msg, Throwable tr) {
        throw new RuntimeException("Stub!");
    }
}
