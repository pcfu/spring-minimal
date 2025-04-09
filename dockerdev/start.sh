#! /bin/sh

declare service
if [ "$#" -eq 0 ]; then
    read -p 'Select service: ' -a tokens
    service=${tokens[0]}
else
    service=$1
fi

case "$service" in
    cli|server)
        USERID=$(id -u) GROUPID=$(id -g) docker compose run --rm --service-ports --name=spring-container $service
        ;;
    full)
        USERID=$(id -u) GROUPID=$(id -g) docker compose --profile=full up
        ;;
    *)
        echo "Unknown service $service"
        exit 1
        ;;
esac
