plugins {
    id("java")
}

group = property.project.groupName

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}