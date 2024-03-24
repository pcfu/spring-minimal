#! /bin/bash

./gradlew bootRun &

inotifywait -m -e modify,create,delete,move -r ./src/ | while read dir events basename; do
    echo "[inotifywait] $dir$basename - $events"
    echo "Re-assembling..."
    ./gradlew --build-cache assemble
done
