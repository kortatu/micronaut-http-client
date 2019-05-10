#!/usr/bin/env bash
mvn clean package
native-image --no-server -cp target/micronaut-http-client-*.jar