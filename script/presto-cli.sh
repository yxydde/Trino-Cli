#!/usr/bin/env bash

base_dir=$(cd "$(dirname "$0")";pwd)
for i in ${base_dir}/../lib/*.jar ; do
    CLASSPATH=$CLASSPATH:$i
done
JAVA_OPTS=-Xmx512m

java $JAVA_OPTS -cp $CLASSPATH com.hexun.App "$@"