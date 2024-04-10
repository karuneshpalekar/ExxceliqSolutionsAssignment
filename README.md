<h1>Exxceliq Solutions Assignment</h1>
<h3>An Android Application showcasing Pagination along with Clean Architecture along with Caching</h3>

Screenshots from the application : 

| ![list](preview/preview2.jpg) | ![list](preview/preview3.jpg) |![list](preview/preview4.jpg) |![noData](preview/preview1.jpg) |
|----------|:----------:|:--------:|:--------:|


<h3>Architecture Used</h3>

![Architecture](preview/architecture-graph.png)

## Tech stack 

- [Kotlin][1] based
- [Coroutines][2] for asynchronous.
- [Compose][3] - Modern toolkit for building native UI.
- [Lifecycle][4] - Create a UI that automatically responds to lifecycle events.
- [LiveData][5] - Notify domain layer data to views.
- [Navigation][6] - Handle everything needed for in-app navigation.
- [ViewModel][7] - UI-related data holder, lifecycle aware.
- [Hilt][8] - For [dependency injection][10].
- [Coil][9] - An image-loading library for Android backed by Kotlin Coroutines.

[1]: https://kotlinlang.org/
[2]: https://kotlinlang.org/docs/reference/coroutines-overview.html
[3]: https://developer.android.com/jetpack/compose
[4]: https://developer.android.com/topic/libraries/architecture/lifecycle
[5]: https://developer.android.com/topic/libraries/architecture/livedata
[6]: https://developer.android.com/jetpack/compose/navigation
[7]: https://developer.android.com/topic/libraries/architecture/viewmodel
[8]: https://dagger.dev/hilt/
[9]: https://developer.android.com/training/dependency-injection/hilt-android
[10]: https://github.com/coil-kt/coil

## Features

- Jetpack Compose UI. 
- Jetpack Compose Navigation
- MVVM Architecture
- Dependency injection with Hilt
- Retrieves Data from the network using Retrofit 
- Documented Flow 

## Testing 
Make sure to pre-fill Database with dummy data before testing 

- Running Unit Tests

  Unit tests are isolated tests that focus on the functionality of individual classes or units of code without relying on external dependencies like the UI or network.

  Instructions:
1. Locate Unit Tests: Unit tests are placed in the src/test/java directory of the Android module.
2. Run Tests from Android Studio:
3. Open the Test view (View > Tool Windows > Test).
4. Select the test class or package you want to run:
5. To run all tests in a class: Click the green play button next to the class name.
   To run a specific test: Right-click on the test method and choose "Run 'testMethodName'".
   The test results will be displayed in the Test view, indicating success, failure, or errors.

- Running UI Tests (Instrumented Tests)
  UI tests verify the behavior of your app's user interface and interactions. They require an emulator or physical device to run.

  Instructions:
1. Locate UI Tests:  UI tests (instrumented tests) are placed in the androidTest/java directory of the Android module.
2. Set Up Dependencies: Ensure build.gradle file for the app module is synced.
3. Run Tests from Android Studio:
4. Connected Devices: Connect an emulator or physical device to your computer.
5. Open the Test view.
   Select the test class or package you want to run.
   Click the green play button.
   Android Studio will deploy the test app to the connected device and run the UI tests.




## Future Scope
  
- Animations 
- Code Optimisations


## Tested on devices 

- Oneplus 9 pro 
- Samsung S20 FE
- Samsung A31 
- Samsung M31s 
- Pixel Emulators 
