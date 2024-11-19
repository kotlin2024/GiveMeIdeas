plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("kapt") version "1.9.25"// querydsl 코드 생성을 위해서 필요하다
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.3.5"
    id("io.spring.dependency-management") version "1.1.6"
    kotlin("plugin.jpa") version "1.9.25"
    kotlin("plugin.noarg") version "1.9.25"
    kotlin("plugin.allopen") version "1.9.25"

}

group = "HJP"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}
val queryDslVersion = "5.0.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    //implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta") // queryDsl
    implementation("javax.persistence:javax.persistence-api:2.2") // 요거 추가

    implementation("com.querydsl:querydsl-jpa:$queryDslVersion:jakarta") // 추가!
    kapt("com.querydsl:querydsl-apt:$queryDslVersion:jakarta") // 추가!

    //kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0") // 스웨거
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    runtimeOnly("org.postgresql:postgresql") // postgresql설치
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

noArg {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}



tasks.withType<Test> {
    useJUnitPlatform()
}
