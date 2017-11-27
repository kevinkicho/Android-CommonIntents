# Android-CommonIntents

Android-CommonIntents is an Android Application that uses ListView to display commonly used intents.
It utilizes various hardware components to execute intents.

<img src="https://firebasestorage.googleapis.com/v0/b/cfmvw-cf878.appspot.com/o/GitHub%2Fintents_image.PNG?alt=media&token=ee082714-f2c9-494e-a19b-454f3e663ee0">

Read More at my <a href="https://cfmvw.com/Android_Application_tutorial.html">blog</a>

<h1>Description</h1>
Intents are often used to facilitate communication between activities, applications. Application uses ListView, ArrayAdapter to provide User Interface. It uses Intents to start: call, camera, web-search, map activities.

<h2>Functions</h2>
Application is composed of MainActivity that Lists various Intents into categories, and 8 Activities for specific functions. 8 Activities contains methods to start intents within category, for example: camera has 2 methods(photo, video). ArrayAdapter class has 2 parts: constructor, getItemId(). A constructor is used in activity to bind string-array. String-array contains lists of intent-names that are to be displayed on ListView. getItemId() method recognizes the position of item that is returned for communciation with switch/case phrase in Activities. 
Switch/case phrases are loaded with methods that presents ListView for display. Every methods are of type void, with simple Intent to start activities.
                    
<h2>Set-Up</h2>
Blank Android Application is created. Main Activity chooses Item by ListView, with Switch/cases as available lists. Context is said in Android Developer Reference: "It allows access to application-specific resources and clases, as well as up-calls for application-level operations such as launching activities, broadcasting and receiving intents, etc." View is a variable that listing function takes in, and it can be simply described as what shall be displayed in the layout.

<h2>MainActivity</h2>
Taking captureVideo() method at CameraLVActivity, two things are observed. First is intent declaration and execution, Second is resolveActivity() with packageManager loaded. Intent constructor looks like this:<br>
<code>Intent i = new Intent(packageContext, class);<br>startActivity(i);</code><br>

startActivity() execute the intent, i.e. intent to start activity that is declared within the constructor by its name. resolveActivity() method loads in packageManager to check if application to handle the event is present within application. Intents that requires access to hardware or different application needs permission to use them or reach them. Such permission are declared within Android Manifest.

<h2>ListView</h2>
ListView is composed of four parts: ListView item noted on Layout xml file, ListView object declared within Activity, ListAdapter, Data to display. ListView in layout file requires id to communicate with activity and declaration. In Activity, for the item to display is string, string-array is recognized as array object. Often is the case that ListView item contain what is: fragment, with images often attached. ListView Adapter is a custom class which extends ArrayList interface. RecyclerView presents enhanced displaying ability for long list of itmes, for it adds/removes items as it enters/exits view.

<h2>Photo Capturing Activity</h2>

There are two common types of permission that are associated with intents. First is request for permission to use hardware, and Second is request for permission to access appropriate software. Hardware access is declared as child of manifest declaration.<br>
<code>&lt;uses-permision android:name="android.permission.CAMERA"/&gt;</code><br>
                    
Photo capturing activity is associated with application's access to resulting photo. Intent-Filter provides 2 tests to enable application to execute what are implicit intents: which does not require specific component(class). IMAGE_CAPTURE action declared within intent-filter notes requirements to access media folder.

<h2>Web Activity</h2>
Web Search activity requires &lt;data&gt; phrase which helps process URL object.
<code>&lt;data android:scheme="http"/&gt;<br>&lt;data android:scheme="https"/&gt;</code><br>

<h1>List of Activities<h1>
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


                    
