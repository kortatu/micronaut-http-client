#!/usr/bin/env bash
siege -c 300 -d 1 -t 40s -l -m "Reandom search 300 NBB" http://localhost:8080/test/mixednbb