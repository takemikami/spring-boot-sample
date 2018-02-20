# gae-spring-boot-sample

spring-boot-sample for Google App Engine Standard Environment.

## install appengine sdk for java

download and install
see. https://cloud.google.com/sdk/downloads?hl=ja

install appengine sdk for java

```
gcloud components install app-engine-java --quiet
```

set environment variable APPENGINE_HOME
```
export APPENGINE_HOME=$GLOUD_SDK_HOME/platform/google_appengine/google/appengine/tools/java/
```

## build

```
gradle build
```

## execute spring-boot local

```
gradle bootRun
```

open http://localhost:8080/

## execute spring-boot local appengine sdk

```
export JAVA_HOME=`/usr/libexec/java_home -v 1.7.0`
```

```
gradle appengineRun
```

open http://localhost:8080/

## reference

- Spring Boot QUICK START: https://projects.spring.io/spring-boot/#quick-start
- gradle-appengine-plugin: https://github.com/GoogleCloudPlatform/gradle-appengine-plugin
- Spring Boot Traditional deployment: https://docs.spring.io/spring-boot/docs/current/reference/html/howto-traditional-deployment.html
- spring-boot-legacy: https://github.com/dsyer/spring-boot-legacy
