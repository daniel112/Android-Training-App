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

Utilizing [clean architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) with [MVVM(Model-View-ViewModel)](https://developer.android.com/topic/libraries/architecture/viewmodel?hl=en) pattern.
**Architecture folder structure and setup is opinionated**, for the most part, as long as the separation and modularization is clear.
I'll try to give my high level reasoning for choosing this particular setup.

### High level folder setup

- `di (Dependency Injection)` - [see README](./app/src/main/java/com/neudesic/myapplication/di/README.md)
  - Dagger Hilt injection modules
- `domain`
  - Contains context and interface which describes the behavior of a system and its interactions with users.
  - Should be platform agnostic, meaning it doesn't have the specific implementation, rather just describes **what** the application does.
  - `useCase` pattern
    - https://github.com/android/architecture-samples/tree/usecases/app/src/main/java/com/example/android/architecture/blueprints/todoapp
    - https://www.raywenderlich.com/3595916-clean-architecture-tutorial-for-android-getting-started#toc-anchor-002
    - https://paulallies.medium.com/clean-architecture-in-the-flavour-of-jetpack-compose-dd4b0016f815
    - https://proandroiddev.com/the-neverending-use-case-story-d30440e5c7f0
- `ui`
  - Contains UI related code. Such as `@Composable`, Navigation, Themes and ViewModels
- `data`
  - Contains the business logic implementation for the domain interfaces
