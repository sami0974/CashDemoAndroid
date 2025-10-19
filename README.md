# CashDemo - Payment Simulator Android App

A fully functional Android application that simulates a payment/cash management system. This is an **educational demo app** for learning purposes only. No real money transactions occur.

## Features

✅ **User Authentication**
- Login and Sign Up functionality
- Demo credentials: demo@example.com / demo123

✅ **Account Management**
- Display user balance
- Manage account information
- View transaction history

✅ **Money Transfer Simulation**
- Send money to other users
- Receive money from contacts
- Transaction descriptions and notes

✅ **Transaction History**
- View all past transactions
- Filter by sent/received
- See transaction details and timestamps

✅ **Modern UI**
- Built with Jetpack Compose
- Material Design 3
- Responsive layout
- Dark/Light theme support

✅ **Local Database**
- SQLite database with Room ORM
- Persistent data storage
- User and transaction data management

## Project Structure

```
CashDemoAndroid/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── kotlin/com/cashdemo/app/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── data/
│   │   │   │   │   ├── AppDatabase.kt
│   │   │   │   │   ├── dao/
│   │   │   │   │   │   ├── UserDao.kt
│   │   │   │   │   │   └── TransactionDao.kt
│   │   │   │   │   └── entity/
│   │   │   │   │       ├── User.kt
│   │   │   │   │       └── Transaction.kt
│   │   │   │   └── ui/
│   │   │   │       ├── screens/
│   │   │   │       │   ├── LoginScreen.kt
│   │   │   │       │   ├── HomeScreen.kt
│   │   │   │       │   ├── SendMoneyScreen.kt
│   │   │   │       │   └── TransactionHistoryScreen.kt
│   │   │   │       └── theme/
│   │   │   │           ├── Theme.kt
│   │   │   │           ├── Color.kt
│   │   │   │           └── Type.kt
│   │   │   ├── AndroidManifest.xml
│   │   │   └── res/
│   │   │       └── values/
│   │   │           ├── strings.xml
│   │   │           ├── colors.xml
│   │   │           └── themes.xml
│   │   └── test/
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Requirements

- **Android Studio** (2023.1 or later)
- **Android SDK** (API 24 or higher)
- **Gradle** (included with Android Studio)
- **Java/Kotlin** compiler

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/CashDemoAndroid.git
cd CashDemoAndroid
```

### 2. Open in Android Studio

1. Open Android Studio
2. Select **File → Open**
3. Navigate to the `CashDemoAndroid` folder
4. Click **OK**

### 3. Sync Gradle Files

Android Studio will automatically prompt you to sync Gradle files. Click **Sync Now**.

### 4. Build the Project

```bash
./gradlew build
```

Or use Android Studio: **Build → Make Project**

## Running the App

### On Emulator

1. Open **AVD Manager** (Tools → Device Manager)
2. Create or select an Android Virtual Device (API 24+)
3. Click the play button to start the emulator
4. In Android Studio, click **Run → Run 'app'**

### On Physical Device

1. Enable **Developer Mode** on your Android device
   - Go to Settings → About Phone
   - Tap Build Number 7 times
   - Go back to Settings → Developer Options
   - Enable USB Debugging

2. Connect your device via USB

3. In Android Studio, click **Run → Run 'app'**

4. Select your device from the list

## Building the APK

### Debug APK

```bash
./gradlew assembleDebug
```

The APK will be generated at: `app/build/outputs/apk/debug/app-debug.apk`

### Release APK

```bash
./gradlew assembleRelease
```

The APK will be generated at: `app/build/outputs/apk/release/app-release.apk`

## Installing the APK

### Via ADB (Android Debug Bridge)

```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Via File Transfer

1. Transfer the APK file to your Android device
2. Open a file manager on your device
3. Navigate to the APK file
4. Tap it to install
5. Grant necessary permissions

### Via Android Studio

1. Build the APK
2. In Android Studio, go to **Build → Analyze APK**
3. Select the APK file
4. Click **Install** (if device is connected)

## Demo Credentials

Use these credentials to test the app:

- **Email:** demo@example.com
- **Password:** demo123

Or create a new account with any email and password.

## Important Legal Notice

⚠️ **This is an educational demo application only**

- **No real money transactions occur**
- **All data is simulated and stored locally**
- **Do not use this app for any commercial purposes**
- **Do not clone or modify existing payment app branding**
- **This is for learning purposes only**

## Features Explained

### Login Screen
- Create new account or login with existing credentials
- Demo credentials provided for testing
- Password validation

### Home Screen
- Display current balance
- Quick action buttons (Send, Request, History)
- Recent transactions list
- Transaction details (amount, recipient, date)

### Send Money Screen
- Enter recipient name
- Specify amount to send
- Optional transaction description
- Success confirmation

### Transaction History
- View all past transactions
- Summary statistics (total sent/received)
- Transaction details with timestamps
- Filter and sort options

## Database Schema

### Users Table
```sql
CREATE TABLE users (
    id TEXT PRIMARY KEY,
    username TEXT,
    email TEXT,
    password TEXT,
    balance REAL DEFAULT 1000.0,
    createdAt INTEGER
);
```

### Transactions Table
```sql
CREATE TABLE transactions (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    userId TEXT,
    recipientName TEXT,
    amount REAL,
    type TEXT, -- 'sent' or 'received'
    timestamp INTEGER,
    description TEXT
);
```

## Technologies Used

- **Language:** Kotlin
- **UI Framework:** Jetpack Compose
- **Database:** Room ORM + SQLite
- **Navigation:** Jetpack Navigation Compose
- **Build System:** Gradle
- **Design:** Material Design 3

## Troubleshooting

### Build Fails
- Update Android Studio to the latest version
- Clear Gradle cache: `./gradlew clean`
- Sync Gradle files again

### App Crashes on Startup
- Ensure minimum SDK is 24 or higher
- Check that all dependencies are installed
- Review logcat for error messages

### APK Installation Fails
- Ensure device has enough storage space
- Uninstall previous version first
- Enable installation from unknown sources (if needed)

## Future Enhancements

- Real backend integration
- User profile customization
- Payment notifications
- Transaction search and filtering
- Multi-currency support
- Biometric authentication
- Dark mode improvements

## License

This project is provided as-is for educational purposes. Modify and use freely for learning.

## Disclaimer

This application is a **simulation only**. It does not perform real financial transactions. Use it solely for educational purposes to understand how payment applications work.

---

**Version:** 1.0.0
**Last Updated:** 2025

