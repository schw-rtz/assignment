#!/bin/sh

mvn compile test exec:java -Dexec.args="$1 $2"