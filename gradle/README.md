# Version Catalog
`libs.versions.toml` is used to manage shared dependencies. 

If you find that you're adding a dependency that is required in other modules. You can use this file to share the versions instead of hardcoding it in multiple places

## Reference
- https://docs.gradle.org/7.5.1/userguide/platforms.html#sub:version-catalog-declaration:~:text=Gradle%20offers%20a%20conventional%20file%20to%20declare%20a%20catalog.%20If%20a%20libs.versions.toml%20file%20is%20found%20in%20the%20gradle%20subdirectory%20of%20the%20root%20build%2C%20then%20a%20catalog%20will%20be%20automatically%20declared%20with%20the%20contents%20of%20this%20file.