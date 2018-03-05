#!/bin/bash

declare -a DIRS=(src/grep/)

for file in ${DIRS[@]}
do
    javac ${file}*.java
done