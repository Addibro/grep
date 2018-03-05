#!/bin/bash

declare -a DIRS=(
    src/
)

for DIR in ${DIRS[@]}
do
    javac ${DIR}*.java
done