spring boot and swagger
---

## endpoint

swagger ui
http://localhost:8080/swagger-ui.html

sample api
http://localhost:8080/api/user/1

api-docs
http://localhost:8080/v2/api-docs

## client

// download codegen
wget http://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.3.1/swagger-codegen-cli-2.3.1.jar

// help
java -jar swagger-codegen-cli-2.3.1.jar config-help -l java

// generate
java -jar swagger-codegen-cli-2.3.1.jar generate \
  -i http://localhost:8080/v2/api-docs \
  -l java -Dlibrary=resttemplate \
  -o out/java


## works cited

REST API をタイプセーフに呼び出す(Spring Boot + Swagger Code Generator)
http://tc.hatenablog.com/entry/2016/01/11/003759
