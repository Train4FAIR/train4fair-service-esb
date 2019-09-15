#!/bin/bash
curl -X GET "http://localhost:8000/disease?hepatitis=true" -H "accept: application/json"
