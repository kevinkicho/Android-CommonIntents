# Android-CommonIntents

Android-CommonIntents is an Android Application that uses ListView to display 28 common intents described in Android Developers.
It utilizes various hardware components to execute intents.

<div style="display: inline-block; align-content: center; position:relative; left: 15%">
                        
<img src="https://firebasestorage.googleapis.com/v0/b/cfmvw-cf878.appspot.com/o/images_cfmvw%2FMainMenu.PNG?alt=media&token=888831bc-7196-47cc-8d3e-c866ac115c93" style="width: 20%">
<img src="https://firebasestorage.googleapis.com/v0/b/cfmvw-cf878.appspot.com/o/images_cfmvw%2FIntents_Web.PNG?alt=media&token=65c2a0b2-44f2-4369-8dbf-e26a87a06a6d" style="width: 20%">
<img src="https://firebasestorage.googleapis.com/v0/b/cfmvw-cf878.appspot.com/o/images_cfmvw%2FIntents_Camera.PNG?alt=media&token=c42394c9-3159-4bd8-bca5-a9dac0223e39" style="width: 20%">
</div>
Main Menu
- Phone, Web, Map, Contacts, Camera, Settings, Storage, Calendar.
- ListView item triggers common Intent.

Phone
- Call, Open DialPad: ACTION_DIAL
- Send SMS: ACTION_SEND

Web
- Search: ACTION_WEB_SEARCH, ACTION_SEND
- OpenWebPage: ACTION_VIEW

Map
- Geo: ACTION_VIEW

Contacts
- Add Contacts: ACTTION_INSERT
- View Contacts: ACTION_VIEW
- Select Contact: ACTION_PICK

Calendar
- Add Event: ACTION_INSERT

Camera
- Take Photo: INTENT_ACTION_STILL_IMAGE_CAMERA
- Record Video: INTENT_ACTION_VIDEO_CAMERA

General
- Set Alarm: ACTION_SET_ALARM
- Play Media: INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH
- Open Document: ACTION_OPEN_DOCUMENT
- Set Timer: ACTION_INSERT
- Start Timer: ACTION_SET_TIMER

Settings
- openWifiSettings:  ACTION_WIFI_SETTINGS
- openSettings:  ACTION_SETTINGS
- openAMSettings:  ACTION_AIRPLANE_MODE_SETTINGS
- openWirelessSettings:  ACTION_WIRELESS_SETTINGS
- openAPNSettings:  ACTION_APN_SETTINGS
- openBlueToothSettings:  ACTION_BLUETOOTH_SETTINGS
- dateSettings:  ACTION_DATE_SETTINGS
- localeSettings:  ACTION_LOCALE_SETTINGS
- inputMethodSettings:  ACTION_INPUT_METHOD_SETTINGS
- displaySettings:  ACTION_DISPLAY_SETTINGS
- securitySettings:  ACTION_SECURITY_SETTINGS
- locationSourceSettings:  ACTION_LOCATION_SOURCE_SETTINGS
- internalStorageSettings:  ACTION_INTERNAL_STORAGE_SETTINGS
- memoryCardSettings:  ACTION_MEMORY_CARD_SETTINGS
