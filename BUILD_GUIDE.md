# CashDemo Android App - Complete Build & Installation Guide

## Table of Contents
1. [Prerequisites](#prerequisites)
2. [Project Setup](#project-setup)
3. [Building the APK](#building-the-apk)
4. [Installing on Android](#installing-on-android)
5. [Troubleshooting](#troubleshooting)
6. [Understanding the App](#understanding-the-app)

---

## Prerequisites

Before you can build and run the CashDemo app, ensure you have the following installed:

### Required Software

| Software | Version | Purpose |
|----------|---------|---------|
| Android Studio | 2023.1+ | IDE for development |
| Java Development Kit (JDK) | 11 or later | Kotlin/Java compilation |
| Android SDK | API 24+ | Android platform libraries |
| Gradle | 8.0+ | Build system (included with Android Studio) |

### System Requirements

- **Operating System:** Windows, macOS, or Linux
- **RAM:** Minimum 4GB (8GB recommended)
- **Disk Space:** 5GB for Android Studio + SDKs
- **Internet Connection:** Required for downloading dependencies

### Android Device Requirements

- **Minimum Android Version:** Android 7.0 (API 24)
- **Recommended:** Android 10+ for best experience
- **Storage:** At least 50MB free space for app installation

---

## Project Setup

### Step 1: Clone or Download the Project

If you have Git installed:

```bash
git clone https://github.com/yourusername/CashDemoAndroid.git
cd CashDemoAndroid
```

Or download the ZIP file and extract it.

### Step 2: Open in Android Studio

1. Launch **Android Studio**
2. Click **File → Open**
3. Navigate to the `CashDemoAndroid` folder
4. Click **OK**

Android Studio will automatically detect it as an Android project.

### Step 3: Sync Gradle Files

When you open the project, Android Studio will prompt you to sync Gradle files:

1. Click **Sync Now** in the notification bar
2. Wait for the sync to complete (this may take 2-5 minutes)
3. Check the **Build** tab at the bottom for any errors

If you don't see the prompt, go to **File → Sync Project with Gradle Files**.

### Step 4: Install Missing SDKs (if needed)

If Android Studio shows SDK errors:

1. Go to **Tools → SDK Manager**
2. Under the **SDK Platforms** tab, ensure you have:
   - Android 14 (API 34) - Latest
   - Android 7.0 (API 24) - Minimum
3. Click **Apply** and **OK** to install
4. Sync Gradle files again

---

## Building the APK

### Method 1: Using Android Studio (Easiest)

#### Debug APK (for testing)

1. In Android Studio, click **Build → Build Bundle(s) / APK(s) → Build APK(s)**
2. Wait for the build to complete
3. A notification will appear with the location of the APK
4. Click **Locate** to open the folder

The debug APK will be at: `app/build/outputs/apk/debug/app-debug.apk`

#### Release APK (for distribution)

1. Click **Build → Generate Signed Bundle / APK**
2. Select **APK** and click **Next**
3. Click **Create new...** to create a signing key (or use existing)
4. Fill in the key details:
   - **Key store path:** Choose a location to save the keystore
   - **Key store password:** Create a secure password
   - **Key alias:** Name for your key (e.g., "cashdemo-key")
   - **Key password:** Same as keystore password
   - **Validity:** Set to 25+ years
5. Click **OK** and **Next**
6. Select **Release** build variant
7. Click **Finish**

The release APK will be at: `app/build/outputs/apk/release/app-release.apk`

### Method 2: Using Command Line

#### Debug APK

```bash
cd /home/ubuntu/CashDemoAndroid
./gradlew assembleDebug
```

Output: `app/build/outputs/apk/debug/app-debug.apk`

#### Release APK

```bash
./gradlew assembleRelease
```

Output: `app/build/outputs/apk/release/app-release.apk`

### Build Output Explanation

| File | Size | Use Case |
|------|------|----------|
| `app-debug.apk` | ~5-8 MB | Testing, development, emulator |
| `app-release.apk` | ~4-6 MB | Distribution, Google Play Store |

---

## Installing on Android

### Method 1: Direct Installation via Android Studio

1. **Connect your Android device** via USB cable
2. Enable **USB Debugging** on your device:
   - Settings → About Phone → Tap Build Number 7 times
   - Settings → Developer Options → Enable USB Debugging
3. In Android Studio, click **Run → Run 'app'**
4. Select your device from the list
5. Click **OK**

The app will automatically build and install.

### Method 2: Using ADB (Android Debug Bridge)

1. **Connect your device** via USB
2. Open a terminal/command prompt
3. Run:

```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

4. Wait for the installation to complete

### Method 3: Manual Installation via File Transfer

1. **Build the APK** (see Building section above)
2. **Transfer the APK** to your Android device:
   - Via USB cable: Copy to phone storage
   - Via cloud storage: Download from Google Drive/OneDrive
   - Via email: Send to yourself and download
3. **Open the APK** on your device:
   - Open Files app
   - Navigate to Downloads
   - Tap the APK file
   - Click **Install**
   - Grant permissions if prompted
4. **Launch the app** from your app drawer

### Method 4: Using Android Emulator

1. In Android Studio, click **Tools → Device Manager**
2. Click **Create Device**
3. Select a phone model (e.g., Pixel 4)
4. Select an Android version (API 24 or higher)
5. Click **Finish**
6. Click the play button to start the emulator
7. In Android Studio, click **Run → Run 'app'**
8. Select the emulator from the list
9. Click **OK**

---

## First Launch & Demo

### Login Credentials

The app comes with demo credentials for testing:

| Field | Value |
|-------|-------|
| Email | demo@example.com |
| Password | demo123 |

### Features to Test

1. **Login Screen**
   - Use demo credentials or create a new account
   - Test password field masking

2. **Home Screen**
   - View your balance ($1,250.50)
   - See recent transactions
   - Click action buttons

3. **Send Money**
   - Enter recipient name
   - Enter amount
   - Add optional description
   - Confirm transaction

4. **Transaction History**
   - View all transactions
   - See sent/received breakdown
   - Check transaction details

---

## Troubleshooting

### Build Issues

#### Error: "Gradle sync failed"

**Solution:**
```bash
cd /home/ubuntu/CashDemoAndroid
./gradlew clean
./gradlew build
```

#### Error: "SDK location not found"

**Solution:**
1. Go to **File → Project Structure**
2. Click **SDK Location** in the left panel
3. Set the Android SDK location (usually `~/Android/sdk`)
4. Click **OK**

#### Error: "Unsupported Java version"

**Solution:**
- Install JDK 11 or later
- Set JAVA_HOME environment variable:
  ```bash
  export JAVA_HOME=/path/to/jdk
  ```

### Installation Issues

#### "App not installed" error

**Solution:**
- Uninstall previous version: `adb uninstall com.cashdemo.app`
- Ensure device has 50MB+ free space
- Try installing debug APK first

#### "Unknown sources" error

**Solution:**
1. Go to **Settings → Apps & Notifications**
2. Click **Advanced → Special app access**
3. Select **Install unknown apps**
4. Enable for your file manager
5. Try installing again

#### Device not recognized

**Solution:**
1. Ensure USB cable is properly connected
2. Enable USB Debugging on device
3. Try different USB port
4. Install USB drivers (Windows):
   - Download from device manufacturer's website
   - Install and restart computer

### Runtime Issues

#### App crashes on startup

**Solution:**
1. Check logcat in Android Studio: **View → Tool Windows → Logcat**
2. Look for error messages
3. Ensure device has Android 7.0+ (API 24+)
4. Try clearing app data: **Settings → Apps → CashDemo → Storage → Clear Data**

#### Slow performance

**Solution:**
- Close background apps
- Restart the device
- Use a newer Android version
- Try on physical device instead of emulator

---

## Understanding the App

### Architecture Overview

The app uses a clean architecture with separation of concerns:

```
UI Layer (Screens)
    ↓
ViewModel/State Management
    ↓
Repository Pattern
    ↓
Database Layer (Room)
```

### Key Components

| Component | Purpose |
|-----------|---------|
| **MainActivity** | Entry point, navigation setup |
| **Screens** | UI for Login, Home, Send, History |
| **Database** | Room ORM for data persistence |
| **Theme** | Material Design 3 styling |

### Data Flow

1. **User Input** → UI Screen
2. **Action** → ViewModel processes
3. **Database** → Room queries data
4. **Display** → UI updates with results

### File Organization

```
app/src/main/
├── kotlin/com/cashdemo/app/
│   ├── MainActivity.kt          # App entry point
│   ├── data/                    # Database layer
│   │   ├── AppDatabase.kt       # Room database
│   │   ├── dao/                 # Data Access Objects
│   │   └── entity/              # Data models
│   └── ui/                      # UI layer
│       ├── screens/             # Screen composables
│       └── theme/               # Material Design theme
└── res/                         # Resources (strings, colors)
```

### Modifying the App

#### Change App Name

Edit `app/src/main/res/values/strings.xml`:
```xml
<string name="app_name">Your App Name</string>
```

#### Change Colors

Edit `app/src/main/kotlin/com/cashdemo/app/ui/theme/Color.kt`:
```kotlin
val PrimaryLight = Color(0xFFYourColor)
```

#### Add New Features

1. Create new data entities in `data/entity/`
2. Create DAOs in `data/dao/`
3. Create UI screens in `ui/screens/`
4. Update navigation in `MainActivity.kt`

---

## Advanced Topics

### Signing for Google Play Store

To publish on Google Play Store:

1. Create a signed release APK (see Method 1 above)
2. Go to [Google Play Console](https://play.google.com/console)
3. Create a new app
4. Upload the signed APK
5. Fill in app details, screenshots, description
6. Submit for review

### Building App Bundle (AAB)

For better compression and distribution:

```bash
./gradlew bundleRelease
```

Output: `app/build/outputs/bundle/release/app-release.aab`

### Continuous Integration

To automate builds with GitHub Actions:

1. Create `.github/workflows/build.yml`
2. Configure build steps
3. Push to GitHub
4. Builds run automatically on each commit

---

## Legal & Disclaimer

⚠️ **IMPORTANT NOTICE**

This application is provided **for educational purposes only**. 

- ✅ No real financial transactions
- ✅ All data is simulated and stored locally
- ✅ Safe to use for learning
- ❌ Do not use for commercial purposes
- ❌ Do not clone existing payment app branding
- ❌ Do not distribute as real payment app

By using this app, you agree to use it solely for educational and learning purposes.

---

## Support & Resources

### Official Documentation
- [Android Developer Guide](https://developer.android.com/)
- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Room Database Guide](https://developer.android.com/training/data-storage/room)

### Community
- Stack Overflow: Tag with `android` and `kotlin`
- Reddit: r/androiddev
- GitHub Issues: Report bugs in your fork

---

**Version:** 1.0.0  
**Last Updated:** 2025  
**Created by:** CashDemo Development Team

