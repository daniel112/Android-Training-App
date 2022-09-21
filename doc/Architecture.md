# Architecture

## Multi-Module Pattern

Modularization is a practice of organizing a codebase into loosely coupled and self contained parts.

How that applies on this project is as follows:

- `:module:core:network` is a separate module and independent from the App(`:app:Android`) module
- The App module consumes the network module and uses its public API to fetch data
- App Module is not aware of the dependencies that may exist in `:module:core:network`

![](/img/base-modularization.png)

**Upside:**

- If we ever need to change networking dependency for any reason, the App layer does not need to be touched at all 🥳
- Testing in isolation is much easier and cleaner
  **Downside:**
- We have to be strict and thorough with shared versions. We need to make sure all modules share the same versions
- Possibility of overengineering by going too granular in modularization. **Need to pick and choose what makes sense to modularize in the App on a need basis**

### References

- https://developer.android.com/topic/modularization#what-is-modularization
- https://developer.android.com/topic/modularization#common-pitfalls
- https://developer.android.com/topic/modularization/patterns#consistent-configuration
