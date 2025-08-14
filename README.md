# Drive Score Technical Test - Android

## Overview

This project is a technical test implementation for **Drive Score**, developed in Android Studio Narwhal 2025.1.2, demonstrating modern Android app architecture, best practices, and fully tested features using Kotlin and Jetpack Compose.

---

## Screenshots

| Loading screen                               | Success screen                               | Error screen                             |
|----------------------------------------------|----------------------------------------------|------------------------------------------|
| ![Loading.png](readme-resources/Loading.png) | ![Success.png](readme-resources/Success.png) | ![Error.png](readme-resources/Error.png) |

---

## Features & Technologies Used

- Fetch and display data from a remote API using **Retrofit** with **Moshi** for JSON parsing.
- **MVI (Model-View-Intent)** architecture for predictable state management and unidirectional data
  flow.
- **Repository pattern** with a single source of truth for clean and consistent data handling.
- **Dependency Injection** via **Dagger Hilt**.
- **Modern UI** built with **Jetpack Compose**.
- **Navigation Compose** with **Kotlin Serialization** for type-safe navigation arguments.
- Fully tested:
    - **Unit tests** (`JUnit`, `MockK`, `Turbine`) for repositories, view models, and MVI state
      logic.
    - **UI tests** for loading, success, and error scenarios.
- CI workflow runs all tests automatically on push.

---

## Testing

- Unit tests cover repositories, view models, and MVI state logic.
- UI tests cover error, loading and success cases.
- CI workflow runs all unit and UI tests automatically on push.

```bash
./gradlew testDebugUnitTest
```

### UI Tests (A device must be connected)

```bash
./gradlew connectedDebugAndroidTest
```

These commands will execute all tests for the debug variant.

---

## Notes

- Fully reactive **MVI architecture** ensures a clean and maintainable codebase.
- All scenarios, including loading, error, and success states, are thoroughly tested.
- Includes custom accessibility for the Doughnut composable
  in [YourCreditScoreSuccessScreen.kt](app/src/main/java/com/jdp/drivescoretechnicaltest/yourcreditscore/ui/composable/YourCreditScoreSuccessScreen.kt),
  verified through UI tests.
- Includes a CI workflow file that runs unit and UI tests automatically.

---

## Possible Enhancements

- Add animation to the inner line of the doughnut chart.
- Ensure TalkBack automatically focuses on the top app bar.
- Modularize the `yourcreditscore` package into a separate feature module for reusability and
  maintainability.
- Keep the sealed interface for UI state and user intents in `YourCreditScoreViewModel.kt` due to
  their small size, improving readability.

