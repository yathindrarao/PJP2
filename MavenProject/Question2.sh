#!/bin/sh
echo "================ LOCAL REPOSITORY ================"


output= $(mvn help:evaluate -Dexpression=settings.localRepository -q -DforceStdout)
echo $output
cd $output
ls

$SHELL
