# Cinema API

## ArangoDB

ArangoDB is required. The following docker containers can be used on Apple M1.

docker pull arangodb/arangodb:3.9.0-noavx

docker run -e ARANGO_RANDOM_ROOT_PASSWORD=root -p 8529:8529 -it arangodb/arangodb:3.9.0-noavx