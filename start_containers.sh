#!/bin/bash

# set up
docker-compose up -d --build

# Let docker start before starting debugger
sleep 1