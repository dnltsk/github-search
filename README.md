[![Build Status](https://travis-ci.org/dnltsk/github-search.svg?branch=master)](https://travis-ci.org/dnltsk/github-search)
[![codebeat badge](https://codebeat.co/badges/16e07903-1a52-49f8-b79d-4f6440db770c)](https://codebeat.co/projects/github-com-dnltsk-github-search-master)
[![codecov](https://codecov.io/gh/dnltsk/github-search/branch/master/graph/badge.svg)](https://codecov.io/gh/dnltsk/gihub-search)

# github-search
searching users by programming language

## test

`./gradlew clean test`

## build

`./gradlew clean bootJar`

## start

`java -jar build/libs/bowling-*.jar samples/game.txt`

## build docker

`docker build . -t github-search`

## start docker

`docker run -it -p 8080:8080 github-search`

## access

http://localhost:8080/search?language=kotlin

