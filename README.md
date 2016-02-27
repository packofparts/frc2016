frc2016 [![Build Status](https://travis-ci.org/FRC-1294/frc2016.svg)](https://travis-ci.org/FRC-1294/frc2016) [![Download](https://api.bintray.com/packages/frc-1294/Robot-Code/frc2016/images/download.svg) ](https://bintray.com/frc-1294/Robot-Code/frc2016/_latestVersion)
=========

The official robot code for the 2016 _FIRST_ Robotics Competition game, _FIRST_ Stronghold.

# Release Plugin instructions
* First, make sure that your local repo has all the tags, a normal git pull will not make that happen.

  ```
  git fetch --tag
  ```

* Then, you can create your new release

  * To create a new patch version (v0.0.1)

    ```
    gradlew release -Prelease.scope=PATCH -Prelease.stage=FINAL
    ```
  
  * To create a new minor version (v0.1.0)

    ```
    gradlew release -Prelease.scope=MINOR -Prelease.stage=FINAL
    ```
  
  * To create a new major version (v1.0.0)

    ```
    gradlew release -Prelease.scope=MAJOR -Prelease.stage=FINAL
    ```


