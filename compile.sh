#!/bin/bash

declare -a DIRS=(src/)

for file in ${DIRS[@]}
do
    javac ${file}*.java
done