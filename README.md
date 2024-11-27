# LearnConnect
LearnConnect is an Android application built using modern development practices, focusing on performance, modularity, and clean architecture.

## Features
MVVM Design Pattern: Ensures separation of concerns and scalable architecture.
Room Database: Local database for managing application data with built-in dummy data initialization.
Kotlin Coroutines: Used to prevent UI blocking during operations.
Navigation Component & Safe Args: Handles seamless page transitions and safe data transfer between screens.
Dependency Injection with Hilt: Simplifies dependency management across the application.

## Installation
To run this project locally, follow these steps:
1. Clone the repository:
```bash
git clone https://github.com/oktydeniz/learnconnect.git
```
or
```bash
git@github.com:oktydeniz/learnconnect.git 
```
2. Open the project in Android Studio.
3. Build and run the project.

## Application Details
Database Initialization: Upon startup, the app adds dummy data to the database using an initializer class.
User Access Control: Users must register to access the app's content.
Course content is locked until the user enrolls in the course.
Core Tables: Includes entities such as Wishlist, User, Course, Video, VideoProgress, and UserVideo.
XML Structure and Components
XML layouts use ViewBinding and/or DataBinding to simplify and optimize UI logic.
Key components include ConstraintLayout for structured UI designs and RecyclerView for data display.
Localization: The app support multiple languages, which accessibility for English-speaking and Turkish users.

## Known Limitations
Unit Testing: Unit tests have not yet been implemented.
Scalability: The app currently lacks support for features like large-scale data synchronization or offline mode.
