#!/bin/sh
set -eu

# git setting
git config --global user.name github-actions
git config --global user.email noreply@github.com

export GIT_BRANCH="$(git symbolic-ref HEAD --short 2>/dev/null)"
if [ "$GIT_BRANCH" = "" ] ; then
  GIT_BRANCH="$(git branch -a --contains HEAD | sed -n 2p | awk '{ printf $1 }')";
  export GIT_BRANCH=${GIT_BRANCH#remotes/origin/};
fi

git remote set-url origin https://github.com/katsulau/restful_api-manage.git
git checkout $GIT_BRANCH

# OpenAPI Generate
export JAR_PATH=./pkg-openapi-generator/code-gen/openapi-generator-cli.jar
## validation
java -jar ${JAR_PATH} validate -i swagger.yaml
## remove old generated code
rm -rf kotlin-client kotlin-spring swift typescript go-gin dart-client dart-dio-client dart-jagauar-client
## generate kotlin-spring
java -jar ${JAR_PATH} generate -i swagger.yaml -g org.openapitools.codegen.languages.TlbKotlinSpringServerCodegen -o kotlin-spring --enable-post-process-file  -p useBeanValidation=true,serializationLibrary=moshi,moshiCodeGen=true,enumPropertyNaming=UPPERCASE,sortParamsByRequiredFlag=true,sortModelPropertiesByRequiredFlag=true,dateLibrary=java8,requestDateConverter=toJson,packageName=org.openapitools.spring
rm -rf kotlin-spring/docs \
  kotlin-spring/build.gradle.kts \
  kotlin-spring/pom.xml \
  kotlin-spring/settings.gradle \
  kotlin-spring/src/main/resources \
  kotlin-spring/src/main/kotlin/org/openapitools/Application.kt \
  kotlin-spring/src/main/kotlin/org/openapitools/spring/apis/ApiUtil.kt \
  kotlin-spring/src/test
## generate kotlin-client
java -jar ${JAR_PATH} generate -i swagger.yaml -g org.openapitools.codegen.languages.TlbKotlinClientCodegen -o kotlin-client -p parcelizeModels=true,serializationLibrary=moshi,moshiCodeGen=true,collectionType=list,enumPropertyNaming=UPPERCASE,sortParamsByRequiredFlag=true,sortModelPropertiesByRequiredFlag=true,dateLibrary=threetenbp,requestDateConverter=toJson,useRxJava2=false --library jvm-retrofit2
rm -rf kotlin-client/docs
## generate typescript
java -jar ${JAR_PATH} generate -i swagger.yaml -g typescript-axios -o typescript

## remove all README.md
find kotlin-client kotlin-spring swift typescript go-gin -name "README.md" | xargs rm

# ignore no diff
set +e

git add .
git commit -m "add generated code"
git push origin $GIT_BRANCH