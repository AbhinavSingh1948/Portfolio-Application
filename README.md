# Portfolio-Application
An Android app built with Kotlin and modern Gradle (KTS) configuration.

Project Structure
Copy
Portfolio-Application/  
├── app/                  # Main application module  
├── gradle/               # Gradle wrapper files  
├── build.gradle.kts      # Top-level build configuration  
├── settings.gradle.kts   # Project modules & repositories  
├── gradle.properties     # Build optimizations (JVM memory, AndroidX)  
├── local.properties      # Local SDK path (ignored in Git)  
└── .gitignore           # Excludes build files, IDE configs  
Key Features
Gradle Kotlin DSL (KTS):

Type-safe build scripts (*.gradle.kts) for better maintainability.

Example:

kotlin
Copy
plugins {  
    alias(libs.plugins.android.application) apply false  
}  
Optimized Builds:

Non-transitive R classes: Reduces APK size (android.nonTransitiveRClass=true).

JVM Memory: Allocates 2GB heap (org.gradle.jvmargs=-Xmx2048m).

Centralized Repositories:

Plugins/dependencies fetched from Google Maven and Maven Central (configured in settings.gradle.kts).

Local Configuration:

local.properties stores your Android SDK path (e.g., sdk.dir=C:\Users\...\Sdk).

How to Build
Clone the repo:

bash
Copy
git clone https://github.com/your-username/portfolio-app.git  
Open in Android Studio:

The project will sync Gradle automatically.

Run the app:

Use ./gradlew assembleDebug (command line) or the Android Studio GUI.

Customization
Add a new module:
Update settings.gradle.kts:

kotlin
Copy
include(":app", ":new-module")  
Change dependencies:
Edit app/build.gradle.kts:

kotlin
Copy
dependencies {  
    implementation("androidx.core:core-ktx:1.12.0")  
}  
