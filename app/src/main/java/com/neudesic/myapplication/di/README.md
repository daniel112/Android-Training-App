# Dependency Injection with Dagger2 + Hilt

Hilt provides a standard way to incorporate Dagger dependency injection into an Android application. It's created and maintained by Google
**Goals**

- To simplify Dagger-related infrastructure for Android apps.
- To create a standard set of components and scopes to ease setup, readability/understanding, and code sharing between apps.
- To provide an easy way to provision different bindings to various build types (e.g. testing, debug, or release).

Functions declared with the dagger hit decorators (everything in `di` folder) does not get called by us. It's all abstracted away by the plugin to make our lives easier.

![](/img/flow.png)

## di (Dependency Injection) Folder/File structure

`di` folder is standard best practice for integrating with Dagger.

### ApplicationModule

Sets up the injection on the App level. The snippet below will automatically inject `DadJokeRepositoryImpl` to any and all places where `DadJokeRepository` is being referenced

```Kotlin
    @Provides
    @Singleton
    fun providesDadJokeRepo(dadJokeAPIService: DadJokeAPIService): DadJokeRepository {
        return DadJokeRepositoryImpl(dadJokeAPIService)
    }
```

In this case, it will know to use [data/repository/DadJokeRepositoryImpl](app/src/main/java/com/neudesic/myapplication/data/repository/DadJokeRepository.kt) in its usage in [domain/GetDadJokeUseCase.kt](./app/src/main/java/com/neudesic/myapplication/domain/repository/DadJokeRepository.kt)

### NetworkingModule

TBA

### References used

- https://github.com/iambaljeet/JetPackHiltDemo - referenced for ideas on folder structure and modularization of files
