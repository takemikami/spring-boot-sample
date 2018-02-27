# session-redis

## reference

Securing a Web Application | spring.io  
https://spring.io/guides/gs/securing-web/

spring-boot-sample-session sample  
https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-session

## if you use redis session store

redis setup & start
```
brew install redis
redis-server
```

comment in spring-session-data-redis

build.gradle
```
dependencies {
  ...
  compile("org.springframework.session:spring-session-data-redis:1.3.2.RELEASE")
}
```

start webap
```
gradle bootRun
```
