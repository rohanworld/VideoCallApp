# VideoCallApp
This is the Video Call I built as an attempt to integrate this feature into my App for final year project in College

Created using Zego CLoud Video - Audio Call SDK Provider
Doumentation: https://docs.zegocloud.com/article/14824 

Create account in Zegocloud, create an project in the dashboard, get your AppID(long) and AppSign(String)

Add dependencies in module level gradle as well as in settings.gradle 
when you are using the Kotlin DSL for build.gradle.kts the repository information should be in Kotlin format: 
repositories { maven { url = uri("https://www.jitpack.io" ) } }

Target and Compile SDK at 34

userName and UserID both are same
Initialise the SDK in the onCreate() and run the same when clicked on a corresponding buttons 
Create button using ZegoCallButton View availble in XML file for Video and Voice, when you import the class 

Note: both the users should be using the app i.e. online 
and the target name should be getText().toString().toLower().trim() for seamless working of the app
