#!/bin/sh

# Simple wrapper for running ipcalc test suite
echo "runTest.sh, v 1.0"

CLSS_PATH=bin/
JUNIT_JAR=/usr/local/junit/* # should be changed to match your installation
TEST_CLSS_PATH=$CLSS_PATH:tst/bin:$JUNIT_JAR
SOURCE_FILE=src/IpCalc.java
TEST_SRC="tst/IpCalcTest.java tst/TestSuite.java tst/TestRunner.java"
TEST_BIN=ipcalc/TestRunner


echo "\n\tcompiling IpCalc.java"
javac -d $CLSS_PATH $SOURCE_FILE && \ 
                        echo "\tOK!" 

echo "\n\tcompiling tests..."
javac   -d tst/bin -cp $TEST_CLSS_PATH $TEST_SRC && \
                                    echo "\tOK!" && \
                echo "\n\trunning test suite..." && \
java -cp $TEST_CLSS_PATH $TEST_BIN
