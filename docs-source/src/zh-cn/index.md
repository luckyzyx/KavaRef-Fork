---
home: true
title: 首页
heroImage: /images/logo.svg
actions:
  - text: 快速上手
    link: /zh-cn/guide/home
    type: primary
  - text: 更新日志
    link: /zh-cn/about/changelog
    type: secondary
features:
  - title: 轻量优雅
    details: 拥有一套强大、优雅、人性化、完全使用 Kotlin lambda 打造的 API，可以帮你快速实现字节码的过滤以及反射功能。
  - title: 全面兼容
    details: 使用原生 Java API 实现反射功能，可在任何 Kotlin on JVM 的项目上使用，在 Android 上使用也丝毫不成问题。
  - title: 快速上手
    details: 简单易用，不需要繁琐的配置，不需要十足的开发经验，搭建环境集成依赖即可立即开始使用。
footer: Apache-2.0 License | Copyright (C) 2019 HighCapable
---

### 随时随地，开始反射。

```java
public class World {

    private void sayHello(String content) {
        System.out.println("Hello " + content + "!");
    }
}
```

```kotlin
val myWorld = World()

World::class.resolve().firstMethod {
    name = "sayHello"
    parameters(String::class)
}.of(myWorld).invoke("KavaRef")
```