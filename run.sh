#!/bin/bash

# docker ps --format '{{.Names}}'

# Delete all images
# docker rmi -f $(docker images -aq)

# Stop all running containers
# docker stop $(docker ps -a -q)
docker rm -f $(docker ps -a -q)
docker volume rm $(docker volume ls -q)

# Remove unnecessary network 
# docker network prune -f

# Delete build caches
rm -rf .gradle
rm -rf bin
rm -rf build
rm -rf hs*


# Start containers
docker-compose up -d


# Get log output from docker-compose
exec tmux new-session \; \
      send-keys 'docker stats --format "table {{.Container}}\t{{.Name}}\t{{.CPUPerc}}\t{{.MemUsage}}\t{{.PIDs}}"' C-m \; \
      split-window -v -p 70 \; \
      send-keys 'docker-compose logs -f spring-reloader spring' C-m \; \
      select-pane -t 0 \; \