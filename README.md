# Drive Score Technical Test - Android

## Overview

This project is a technical test implementation for **Drive Score**, demonstrating modern Android app architecture, best practices, and fully tested features using Kotlin and Jetpack Compose. Developed in Android Studio Narwhal 2025.1.2.

---

## Screenshots

| Loading screen                               | Success screen                               | Error screen                             |
|----------------------------------------------|----------------------------------------------|------------------------------------------|
| ![Loading.png](readme-resources/Loading.png) | ![Success.png](readme-resources/Success.png) | ![Error.png](readme-resources/Error.png) |

---

## Features

- Fetch and display data from a remote API using **Retrofit**.
- JSON parsing with **Moshi**.
- **Dependency Injection** via **Dagger Hilt**.
- **Modern UI** with **Jetpack Compose**.
- **MVI (Model-View-Intent)** architecture for unidirectional data flow.
- **Navigation Compose** with **Kotlin Serialization**.
- Fully tested with **unit tests** (`JUnit`, `MockK`, `Turbine`) and **UI tests** for all main scenarios.

---

## Architecture

- **MVI (Model-View-Intent)** for predictable state management.
- **Repository pattern** for clean data handling.
- **Single Source of Truth** ensures consistency across the app.

---

## Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Retrofit + Moshi**
- **Kotlin Serialization** (for Navigation arguments)
- **Dagger Hilt**
- **Navigation Compose**
- **JUnit + MockK + Turbine**

---

## Running Tests from Command Line

You can run the tests without opening Android Studio using Gradle commands:

### Unit Tests
```bash
./gradlew testDebugUnitTest
```
```bash
./gradlew connectedDebugAndroidTest
```


