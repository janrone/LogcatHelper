
[![](https://jitpack.io/v/janrone/LogcatHelper.svg)](https://jitpack.io/#janrone/LogcatHelper)

How to use:

Add it to your build.gradle with:

        allprojects {
            repositories {
                maven { url "https://jitpack.io" }
            }
        }

and:

        dependencies {
            implementation 'com.github.janrone:LogcatHelper:1.0'
        }



[![](1562839165293.jpg)](https://jitpack.io/#janrone/LogcatHelper)


16:45:02.885 11394 11394 I pp.logcathelpe: Late-enabling -Xcheck:jni
2019-07-11 16:45:03  07-11 16:45:02.955 11394 11403 E pp.logcathelpe: Failed to send DDMS packet REAQ to debugger (-1 of 20): Broken pipe
2019-07-11 16:45:03  07-11 16:45:03.324 11394 11394 W pp.logcathelpe: JIT profile information will not be recorded: profile file does not exits.
2019-07-11 16:45:03  07-11 16:45:03.327 11394 11394 I chatty  : uid=10132(com.github.janrone.app.logcathelper) identical 10 lines
2019-07-11 16:45:03  07-11 16:45:03.328 11394 11394 W pp.logcathelpe: JIT profile information will not be recorded: profile file does not exits.
2019-07-11 16:45:03  07-11 16:45:03.363 11394 11394 I Perf    : Connecting to perf service.
2019-07-11 16:45:03  07-11 16:45:03.380 11394 11394 I InstantRun: starting instant run server: is main process
2019-07-11 16:45:03  07-11 16:45:03.561 11394 11394 I DecorView: It support bigbang
2019-07-11 16:45:03  07-11 16:45:03.565 11394 11394 I PhoneWindow: isNeedChangeNaviBarColor taskInfo: [android.app.ActivityManager$RunningTaskInfo@9436b2e] size: 1
2019-07-11 16:45:03  07-11 16:45:03.565 11394 11394 I PhoneWindow: isAPPNeedChange pkgName: com.github.janrone.app.logcathelper needKeep: false
2019-07-11 16:45:03  07-11 16:45:03.565 11394 11394 I PhoneWindow: isNeedChangeNaviBarColor false
2019-07-11 16:45:03  07-11 16:45:03.565 11394 11394 I PhoneWindow: generateLayout mNavigationBarColor: ff000000
2019-07-11 16:45:03  07-11 16:45:03.565 11394 11394 I PhoneWindow: generateLayout isLightNavi false, Visibility: 0
2019-07-11 16:45:03  07-11 16:45:03.613 11394 11394 W pp.logcathelpe: Accessing hidden method Landroid/view/View;->getAccessibilityDelegate()Landroid/view/View$AccessibilityDelegate; (light greylist, linking)
2019-07-11 16:45:03  07-11 16:45:03.662 11394 11394 W pp.logcathelpe: Accessing hidden method Landroid/view/View;->computeFitSystemWindows(Landroid/graphics/Rect;Landroid/graphics/Rect;)Z (light greylist, reflection)
2019-07-11 16:45:03  07-11 16:45:03.663 11394 11394 W pp.logcathelpe: Accessing hidden method Landroid/view/ViewGroup;->makeOptionalFitsSystemWindows()V (light greylist, reflection)
2019-07-11 16:45:03  07-11 16:45:03.741 11394 11394 I LogcatHelper: TEST
2019-07-11 16:45:03  07-11 16:45:03.741 11394 11394 D LogcatHelper: TEST
2019-07-11 16:45:03  07-11 16:45:03.741 11394 11394 W LogcatHelper: TEST
2019-07-11 16:45:03  07-11 16:45:03.741 11394 11394 E LogcatHelper: TEST
2019-07-11 16:45:03  07-11 16:45:03.760 11394 11394 D OpenGLRenderer: Skia GL Pipeline
2019-07-11 16:45:03  07-11 16:45:03.803 11394 11394 I PressGestureDetector: deviceProvisioned=true
2019-07-11 16:45:03  07-11 16:45:03.834 11394 11422 I Adreno  : QUALCOMM build                   : a4d39a0, I6fd668c4d3
2019-07-11 16:45:03  07-11 16:45:03.834 11394 11422 I Adreno  : Build Date                       : 10/05/18
2019-07-11 16:45:03  07-11 16:45:03.834 11394 11422 I Adreno  : OpenGL ES Shader Compiler Version: EV031.25.03.01
2019-07-11 16:45:03  07-11 16:45:03.834 11394 11422 I Adreno  : Local Branch                     :
2019-07-11 16:45:03  07-11 16:45:03.834 11394 11422 I Adreno  : Remote Branch                    : refs/tags/AU_LINUX_ANDROID_LA.UM.7.2.R1.09.00.00.442.049
2019-07-11 16:45:03  07-11 16:45:03.834 11394 11422 I Adreno  : Remote Branch                    : NONE
2019-07-11 16:45:03  07-11 16:45:03.834 11394 11422 I Adreno  : Reconstruct Branch               : NOTHING
2019-07-11 16:45:03  07-11 16:45:03.834 11394 11422 I Adreno  : Build Config                     : S L 6.0.7 AArch64
2019-07-11 16:45:03  07-11 16:45:03.841 11394 11422 I Adreno  : PFP: 0x005ff112, ME: 0x005ff066
2019-07-11 16:45:03  07-11 16:45:03.850 11394 11422 I ConfigStore: android::hardware::configstore::V1_0::ISurfaceFlingerConfigs::hasWideColorDisplay retrieved: 0
2019-07-11 16:45:03  07-11 16:45:03.851 11394 11422 I ConfigStore: android::hardware::configstore::V1_0::ISurfaceFlingerConfigs::hasHDRDisplay retrieved: 0
2019-07-11 16:45:03  07-11 16:45:03.851 11394 11422 I OpenGLRenderer: Initialized EGL, version 1.4
2019-07-11 16:45:03  07-11 16:45:03.851 11394 11422 D OpenGLRenderer: Swap behavior 2
