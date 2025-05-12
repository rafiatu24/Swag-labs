#!/bin/bash
set -e

echo " Starting Tests with Docker Compose..."
docker compose up --build
https://hub.docker.com/repository/docker/rafiatu24/swag_lab_test

echo " Tests completed. Check reports in ./reports"

echo "Running allure to generate test report"
mvn allure:serve
