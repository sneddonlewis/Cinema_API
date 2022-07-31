# Cinema API

## ArangoDB

ArangoDB v3.8.0 is required and can be downloaded [here](https://www.arangodb.com/download-major/) for Windows, Linux and Intel Mac.
If using Apple Silicon, use the following docker image;

`docker pull arangodb/arangodb:3.9.0-noavx`

`docker run -e ARANGO_ROOT_PASSWORD=root -p 8529:8529 -it arangodb/arangodb:3.9.0-noavx`

Arango web interface can be found at localhost port 8529. Login with username: `root` and password: `root`
