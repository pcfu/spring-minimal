#! /bin/bash

oninterrupt() {
    trap - SIGINT

    pid=$(lsof -t -i:8080)
    if [[ -n "$pid" ]]; then
        kill -9 $pid
    fi

    exit
}


./gradlew bootRun &

trap oninterrupt SIGINT

inotifywait -m -e modify,create,delete,move -r ./src/ | while read dir events basename; do
    echo "[inotifywait] $dir$basename - $events"
    echo "Re-assembling..."
    ./gradlew --build-cache assemble
done
