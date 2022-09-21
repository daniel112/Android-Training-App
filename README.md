# Android Training App

## Requirements

- Android Studio 4.2+
- [Android 13 SDK](https://developer.android.com/about/versions/11/setup-sdk#get-sdk)

## Utilizes

- JAVA SDK 16
- Android 13+ SDK
- Android Compose for programmatic UI
- Material 3 (Not to be used in production)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel?gclid=CjwKCAjwpqCZBhAbEiwAa7pXeQ7l2QU5s7fw2QeayoBUARqeBFYheA_yQF3IdxZ1jA6292uYncpcGhoCDeQQAvD_BwE&gclsrc=aw.ds) - Android built it support for MVVM architecture
- [Retrofit](https://square.github.io/retrofit/) - Managed and developed by Square for networking utilities
  - Popular standard for Android HTTP client
- [Dagger Hilt](https://dagger.dev/hilt/) - Managed and developed by Google for clean dependency injection
- [observeAsState](https://developer.android.com/reference/kotlin/androidx/compose/runtime/livedata/package-summary) - State observer for the compose pattern

## Architecture

> **Architecture folder structure and setup is opinionated**, for the most part, as long as the separation and modularization is clear.

This template utilizes [clean architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) with [MVVM(Model-View-ViewModel)](https://developer.android.com/topic/libraries/architecture/viewmodel?hl=en) pattern. It also loosely recommends the [multi-module architecture pattern](https://developer.android.com/topic/modularization)

See the [Architecture README](/doc/Architecture.md) for more information.

![](/img/high-level-architecture.png)

### High level folder structure

- `di (Dependency Injection)` - [see README](./app/src/main/java/com/neudesic/myapplication/di/README.md)
  - Dagger Hilt injection modules
- `domain`

  Contains context and interface which describes the behavior of a system and its interactions with users.
  Domain information should be platform agnostic, meaning it doesn't have the specific implementation, rather just describes **what** the application does.

  - `useCase` - Use cases show us the intent of the software
  - `model` - Domain data model for the objects your App manages. _DTOs should be converted to domain models_
  - `repository` - an abstraction of Data Access and it does not depend on details. _Implementation details should exist under `data/repository`_
  - `constant` - any values that won't ever change in the entire app lifecycle

- `ui`
  - Contains UI related code. Such as `@Composable`, Navigation, Themes and ViewModels
- `data`
  - Contains the business logic implementation for the domain interfaces
