# Internal Module - Network

Handles all things related to the App's service request, DTO (Data Transfer Object) and API services
This module integrates with [Retrofit](https://square.github.io/retrofit/) and exposes the following

- `CoreNetworkModule` - Interface which exposes the API service(s)
- `CoreNetworkModuleImpl` - Implementation for the Interface above. Helps in abstracting away the dependency that the consumer don't care about
- `DadJokeAPIService` - Interface for the supported HTTP methods for the given service. This example uses DadJoke API
- `NetworkResult` - used to abstract away the Retrofit `Response` type. Plus it's more convenient

## Setup

Consume this module by:

1. Including the module in `settings.gradle` by adding `include ':module:core:network'`
2. adding `implementation project(':module:core:network')` in the App level `build.gradle`

## Usage

Very basic use case could be something like this

```kotlin
suspend fun getDadJoke(baseUrl: String) {
    val coreNetworkModule: CoreNetworkModule = CoreNetworkModuleImpl()
    val service = coreNetworkModule.getDadJokeAPIService(baseUrl)
    withContext(Dispatchers.IO) {
        // call the API
        when (val response = service.fetchJoke()) {
            is NetworkError -> println("Network Error: $response.message")
            is NetworkException -> println("Network Error: $response.e.message")
            // response.data contains the API result object
            is NetworkSuccess -> println("Success: $response.data")
        }
    }
}
```

## Testing

TBA
