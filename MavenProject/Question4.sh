#!/bin/sh
echo "=================Prevent maven from downloading dependencies every time================= "

mvn -o clean install

$SHELL