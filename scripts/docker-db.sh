#!/bin/sh
docker run --name exercise -p 5434:5432 -d     -e POSTGRES_PASSWORD=postgres     -e POSTGRES_USER=postgres     -e POSTGRES_DB=exercise -v pgdata:/var/lib/postgres/data --restart unless-stopped  postgres