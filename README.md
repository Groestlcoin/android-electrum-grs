Groestlcoin Electrum-GRS for Android
===============

## Version v1.5.22 Features
- Use Electrum-GRS for transaction
- Click on any addresses to edit the label or copy it
- Dedicated copy address button in the receive screen
- Ability to view recovery phrase in settings
- Manual receiving address management (enable in settings)
- Basic address book
- Local currency values in the sign transaction screen
- Exchange rates for various national currencies
- Optimized layouts for small screens
- Able to install app in external storage 

## An open source project https://github.com/GroestlCoin/android-electrum-grs
Source code licensed under GNU General Public License 3

Uses Groestlcoinj Library
https://github.com/GroestlCoin/groestlcoinj a fork of bitcoinj

Uses Electrum-GRS server software
https://github.com/GroestlCoin/electrum-grs-server

Influenced by Coinomi
https://github.com/Coinomi/coinomi-android

QR-code functionality by ZXing
https://github.com/zxing/zxing

Font-icons by Daniel Bruce
http://www.entypo.com

Exchange rates provided by
http://www.poloniex.com

## Building the app

Install [Android Studio](https://developer.android.com/sdk/installing/studio.html). Once it is
running, import coinomi-android by navigating to where you cloned or downloaded it and selecting
settings.gradle. When it is finished importing, click on the SDK Manager ![SDK Manager](https://developer.android.com/images/tools/sdk-manager-studio.png). You will need to install SDK version 21.

<br/>
Make sure that you have JDK 7 installed before building. You can get it [Here](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html). Once you have that installed, navigate to File > Project Structure > SDK Location and change the path of your current JDK to the path of the new JDK. **The project will not build with JDK 8**. 

<br/>
Once it is finished installing, you will need to enable developer options on your phone. To do so,
go into settings, About Phone, locate your Build Number, and tap it 7 times, or until it says
"You are now a Developer". Then, go back to the main Settings screen and scroll once again to the
bottom. Select Developer options and enable USB Debugging.

<br/>
Then plug your phone into your computer and hit the large green play button at the top of
Android Studio. It will load for a moment before prompting you to select which device to install
it on. Select your device from the list, and hit continue.

**NOTE**
If you are attempting to build on a Lollipop emulator, please ensure that you are using *Android 5.*.* armeabi-v7*. It will not build on an x86/x86_64 emulator.
