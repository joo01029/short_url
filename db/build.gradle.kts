dependencies {
    api("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
}

tasks.getByName("bootJar") {
    enabled = false
}

tasks.getByName("jar") {
    enabled = true
}
