# CashDemo - Quick Start Guide

Get your CashDemo app running in 5 minutes! 🚀

## What You'll Need

- **Android Studio** (free download from [developer.android.com](https://developer.android.com/studio))
- **An Android device or emulator** (Android 7.0+)
- **USB cable** (if using physical device)

## 5-Minute Setup

### Step 1: Open the Project (1 min)
1. Download and install Android Studio
2. Open Android Studio
3. Click **File → Open**
4. Select the `CashDemoAndroid` folder
5. Click **OK**

### Step 2: Wait for Sync (2 min)
- Android Studio will automatically sync Gradle files
- You'll see a progress bar at the bottom
- Wait for it to complete (don't close the window)

### Step 3: Build & Run (2 min)

**Option A: On Physical Device**
1. Connect your Android phone via USB
2. Enable USB Debugging (Settings → Developer Options → USB Debugging)
3. Click the green **Run** button (▶) in Android Studio
4. Select your device
5. Click **OK**

**Option B: On Emulator**
1. Click **Tools → Device Manager**
2. Click the play button next to any device
3. Wait for emulator to start
4. Click the green **Run** button in Android Studio
5. Select the emulator
6. Click **OK**

## First Time Using the App

### Login
- **Email:** demo@example.com
- **Password:** demo123

Or create your own account!

### Explore Features
- 💰 **Home:** See your balance and recent transactions
- 📤 **Send Money:** Transfer funds to contacts
- 📊 **History:** View all your transactions
- 📱 **Settings:** Manage your account

## Building the APK (to install on other devices)

### Quick Method
1. Click **Build → Build Bundle(s) / APK(s) → Build APK(s)**
2. Wait for build to complete
3. Click **Locate** in the notification
4. Copy the APK file to your phone
5. Open the APK on your phone to install

### Command Line Method
```bash
cd /home/ubuntu/CashDemoAndroid
./gradlew assembleDebug
```

The APK will be at: `app/build/outputs/apk/debug/app-debug.apk`

## Common Issues

### "Gradle sync failed"
```bash
./gradlew clean
./gradlew build
```

### "Device not found"
- Ensure USB Debugging is enabled
- Try a different USB cable
- Restart Android Studio

### "App won't install"
- Uninstall old version first
- Ensure 50MB+ free space on device
- Try the debug APK first

## What's Inside?

| Feature | What It Does |
|---------|-------------|
| **Login/Sign Up** | Create account or login |
| **Dashboard** | View balance & transactions |
| **Send Money** | Simulate sending funds |
| **History** | See all past transactions |
| **Local Database** | All data saved on your phone |

## Important ⚠️

**This is an educational demo only!**
- No real money involved
- All data is simulated
- For learning purposes
- Safe to use and modify

## Next Steps

- Read the full [README.md](README.md) for detailed info
- Check [BUILD_GUIDE.md](BUILD_GUIDE.md) for advanced setup
- Modify the code to add your own features
- Share with friends to show off your Android knowledge!

## Need Help?

1. Check the [BUILD_GUIDE.md](BUILD_GUIDE.md) troubleshooting section
2. Search your error on [Stack Overflow](https://stackoverflow.com)
3. Check [Android Developer Docs](https://developer.android.com)

---

**Happy coding! 🎉**

Questions? Check the full documentation or modify the code to learn!

