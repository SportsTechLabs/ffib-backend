plugins {
	java

	id("org.springframework.boot") version "3.5.5"
	id("io.spring.dependency-management") version "1.1.7"

	jacoco

	id("com.diffplug.spotless") version "7.2.1"
	id("org.sonarqube") version "6.2.0.5505"
}

group = "com.sportstechlabs.ffib"
version = "0.1.0-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {

	// Spring Boot
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-actuator")

	// Database
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation("org.flywaydb:flyway-database-postgresql")
	implementation("org.springframework:spring-jdbc")

	runtimeOnly("org.postgresql:postgresql")
	runtimeOnly("org.postgresql:r2dbc-postgresql")

	// Redis
	implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")

	// OpenAPI
	implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.8.9")

	// MapStruct
	implementation("org.mapstruct:mapstruct:1.6.3")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")

	// Lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	compileOnly("org.projectlombok:lombok-mapstruct-binding:0.2.0")
	annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")

	// Testing
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")

	testImplementation("io.projectreactor:reactor-test")

	testImplementation("org.mockito:mockito-core")

	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:postgresql")
	testImplementation("org.testcontainers:r2dbc")

	testImplementation("com.tngtech.archunit:archunit-junit5:1.4.1")

	testCompileOnly("org.projectlombok:lombok")
	testAnnotationProcessor("org.projectlombok:lombok")

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<JavaCompile> {
	options.encoding = "UTF-8"

	options.compilerArgs.add("-parameters")
	options.compilerArgs.add("-Xlint:unchecked")
	options.compilerArgs.add("-Xlint:deprecation")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

jacoco {
	toolVersion = "0.8.13"
}

tasks.test {
	finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
	dependsOn(tasks.test)

	reports {
		xml.required.set(true)
		html.required.set(true)
	}
}

spotless {
	java {
		target("src/**/*.java")

		googleJavaFormat()

		removeUnusedImports()
		trimTrailingWhitespace()
		endWithNewline()
	}
}

sonar {
	properties {
		property("sonar.projectKey", "ffib-backend")
		property("sonar.projectName", "FFIB Backend")
	}
}