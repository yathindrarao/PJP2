#!/bin/sh
echo "================= BUILD LOG ================="

mvn install -X | tee Question3_op.txt