# OPSC Mobile Application

An Android application built with **Kotlin** and **XML / Jetpack UI components**, designed to provide secure user authentication, interactive dashboard navigation, and customizable settings management.

This project was developed as part of practical software engineering coursework to demonstrate native Android activity lifecycles, user authentication workflows (including social login layouts), and structured mobile UI navigation.

---

## 🚀 Key Features
* **Secure Authentication Flows:** Complete login and registration screens (`MainActivity`, `signUpSection`, `signUpDetailsActivity`) with validation support.
* **Interactive Home Dashboard:** Post-authentication landing interface (`HomeActivity`) for core app features and navigation.
* **Customized User Settings:** Dedicated settings management screen (`SettingsActivity`) for user preferences.
* **Custom UI & Styling:** Tailored gradients, custom buttons, borders, and responsive theme configurations (`Themes`, `Colors`, `Type`).

---

## 🛠️ Technology Stack & Architecture
* **Language:** Kotlin
* **UI Framework:** Android XML Layouts, Material Components, View Binding
* **Architecture / Components:** Activities (`MainActivity`, `HomeActivity`, `SettingsActivity`, `signUpDetailsActivity`), Intent-based navigation
* **Build System:** Gradle with Kotlin DSL (`build.gradle.kts`)
* **Version Control & CI:** GitHub Actions workflows configured for automated Android testing (`android-tests.yml`)

---

## 📂 Project Structure
```text
OPSC/
│
├── .github/workflows/         # Automated Android testing CI pipelines
├── app/src/main/
│   ├── java/com/example/opsc/ # Core Activities (MainActivity, Home, Settings, Sign-up)
│   └── res/                   # XML layouts, drawables, gradients, colors, and mipmaps
├── build.gradle.kts           # Project build configurations (Kotlin DSL)
└── settings.gradle.kts        # Gradle settings and repositories
```

---

## ⚙️ Setup & Local Installation

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/ethan1ol/opsc.git
   ```
2. **Open in Android Studio:**
   Launch Android Studio, select **Open**, and choose the cloned `OPSC` root directory.
3. **Sync Gradle:**
   Allow Android Studio to sync and download the required Gradle dependencies (`build.gradle.kts`).
4. **Run the Application:**
   Start an Android Emulator (API 24+) or connect a physical Android device, then click the **Run ('>')** button in Android Studio.

---

## 🧪 Testing & CI
* Includes local unit test configurations (`ExampleUnitTest.kt`).
* Automated CI pipeline (`android-tests.yml`) set up via GitHub Actions to run tests on code pushes.
