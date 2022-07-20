# Config App
This application is build on spring java and packages in a public docker image 
>docker pull iamvictorabedi/config-app:latest
## Problem definition

The aim of test is to create a simple HTTP service that stores and returns configurations that satisfy certain conditions.
Since we love automating things, the service should be automatically deployed to kubernetes.

### Endpoints
Following are the endpoints are implemented:

| Name   | Method      | URL
| ---    | ---         | ---
| List   | `GET`       | `/configs`
| Create | `POST`      | `/configs`
| Get    | `GET`       | `/configs/{name}`
| Update | `PUT/PATCH` | `/configs/{name}`
| Delete | `DELETE`    | `/configs/{name}`
| Query  | `GET`       | `/search?metadata.key=value`

#### Query

The query endpoint **MUST** return all configs that satisfy the query argument.

Query example-1:

```sh
curl http://config-service/name=datacenter-1
```

Response example:

```json
[
  {
    "name": "datacenter-1",
    "metadata": {
      "monitoring": {
        "enabled": "true"
      },
      "limits": {
        "cpu": {
          "enabled": "false",
          "value": "300m"
        }
      }
    }
  }
]
```

#### Schema

- **Config**
  - Name (string)
  - Metadata (nested key:value pairs where both key and value are strings of arbitrary length)

### Build and Push Image to Docker
This project uses jib https://cloud.google.com/blog/products/application-development/introducing-jib-build-java-docker-images-better

You can replace `DOCKER_IMAGE_URL` , `DOCKER_USERNAME` and `DOCKER_PASSWORD`
with your docker.io credentials and this will automatically build and package the micronaut app for you then push it to your docker registry.


```
jib {
    to {
        image = DOCKER_IMAGE_URL
        tags = ["latest"]

        auth {
            username = DOCKER_USERNAME
            password = DOCKER_PASSWORD
        }
    }
    container {
        jvmFlags = [
                "-Djava.security.egd=file:/dev/./urandom",
                "-Dfile.encoding=UTF-8",
                "-Dlogback.debug=true",
                "-XX:+UnlockDiagnosticVMOptions",
                "-XX:+HeapDumpOnOutOfMemoryError",
                "-XX:HeapDumpPath=/tmp/dump.hprof",
                "-XX:MaxMetaspaceSize=256m"
        ]
        ports = ["5000"]
    }
}
```
