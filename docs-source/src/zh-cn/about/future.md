# 展望未来

> 未来是美好的，也是不确定的，让我们共同期待 `KavaRef` 在未来的发展空间。

## 未来的计划

> 这里收录了 `KavaRef` 可能会在后期添加的功能。

### 支持通过 ClassLoader 过滤 Class

`KavaRef` 目前仅支持 `Method`、`Field`、`Constructor` 等反射 API 的查找和调用，
未来可能会根据需求在 Java 与 Android 平台支持通过指定类型的 `ClassLoader` 过滤 `Class` 的功能。

目前，你可以使用 [DexKit](https://github.com/LuckyPray/DexKit) 来完成这一需求，它同时支持更加复杂的 Method、Field、Constructor 等反射 API 的查找和调用。

### 自动生成反射代码

**这是在 [YukiReflection](https://github.com/HighCapable/YukiReflection) 中已经初步立项的功能，`KavaRef` 准备在未来可能的时间里继续实现它。**

使用 `stub` 的方式创建一个 Kotlin 类，并声明其中的参数，以及其在各个版本中的不同状态。

比如下面的这个 Java 类就是我们需要反射的目标类。

> 示例如下

```java:no-line-numbers
package com.example.test;

public class MyClass {
    
    private String myField = "test";

    public MyClass() {
        // ...
    }

    private String myMethod1(String var1, int var2) {
        // ...
    }

    private void myMethod2() {
        // ...
    }

    private void myMethod3(String var1) {
        // ...
    }
}
```

通过目前 API 的现有用法可以使用如下方式反射调用这个类。

> 示例如下

```kotlin
MyClass().resolve().apply {
    // 调用 myField
    val value = firstField { name = "myField" }.get<String>()
    // 调用 myMethod1
    val methodValue = firstMethod { name = "myMethod1" }.invoke<String>("test", 0)
    // 调用 myMethod2
    firstMethod { name = "myMethod2" }.invoke()
    // 调用 myMethod3
    firstMethod { name = "myMethod3" }.invoke("test")
}
```

目前要实现的功能是可以使用反射功能直接定义为如下 Kotlin 类。

> 示例如下

```kotlin
package com.example.test

@ReflectClass
class MyClass {

    @ReflectField
    val myField: String = fieldValueOf("none")

    @ReflectMethod
    fun myMethod1(var1: String, var2: Int): String = methodReturnValueOf("none")

    @ReflectMethod
    fun myMethod2() = MethodReturnType.Unit

    @ReflectMethod
    fun myMethod3(var1: String) = MethodReturnType.Unit
}
```

然后我们就可以直接调用这个定义好的 Kotlin 类来实现反射功能，API 会根据注解自动生成反射代码。

> 示例如下

```kotlin
MyClass().also {
    // 调用 myField
    val value = it.myField
    // 调用 myMethod1
    val methodValue = it.myMethod1("test", 0)
    // 调用 myMethod2
    it.myMethod2()
    // 调用 myMethod3
    it.myMethod3("test")
}
```

::: tip

以上功能可能会在实际推出后有所变化，最终以实际版本的功能为准。

:::