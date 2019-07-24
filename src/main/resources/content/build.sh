#!/bin/bash
docker rmi jbjares/phtonfhir
docker build -t jbjares/phtonfhir ./

docker push jbjares/phtonfhir
