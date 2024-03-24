plugins {
	java
	war
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.sephora.fuel"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	/* ALL */
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")

	/* DEVELOPMENT */
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	/* TEST */
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
