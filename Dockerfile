FROM bellsoft/liberica-openjdk-alpine:21

RUN apk add curl jq

#Workspace
WORKDIR /home/selenium-docker

# Add the required files
ADD target/docker-resources ./
ADD runner.sh               runner.sh

# Environment variables
# BROWSER
# HUB_HOST
# TEST_SUITE
# THREAD_COUNT

#start the runner.sh
ENTRYPOINT sh runner.sh