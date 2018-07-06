# Docker and Git info spike
Just a spike how to to capture the meta data from git into a project.

This is done with some examples from https://blog.scottlowe.org/2017/11/08/how-tag-docker-images-git-commit-information/

## Build arg
Command like `docker build -t spike --build-arg GIT_COMMIT=$(git rev-parse HEAD) .`
and you need values specified in the docker file like
```
ARG GIT_COMMIT=unspecified
LABEL git_commit=$GIT_COMMIT
```

## Label command at build time
Command like `docker build -t spike --label GIT_COMMIT=$(git rev-parse HEAD) .`

## To see the labels on a docker image
To see all the labels
`docker inspect -f {{.Config.Labels}} spike`

To see a specific label
`docker inspect   --format "{{ index .Config.Labels \"GIT_COMMIT\"}}" spike`

## Get maven info at runtime
There are commands that you can run to get the info that is required like
`mvn --batch-mode org.apache.maven.plugins:maven-help-plugin:3.1.0:evaluate -Dexpression=project.groupId`

However an alternative might be to build a json file and that cat that file to the label argument.
