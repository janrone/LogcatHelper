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