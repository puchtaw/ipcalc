#!/bin/sh

# Simple wrapper for running ipcalc test suite

echo "runTest.sh, v 1.0\n"

# create bin directory if it doesn`t exist
if [ ! -d bin ]; then
    mkdir bin
fi

CLSS_PATH=bin
JUNIT_JAR=/usr/local/junit # should be changed to match your installation
TEST_CLSS_PATH=$CLSS_PATH:tst/bin:$JUNIT_JAR/*
SOURCE_FILE=src/IpCalc.java
TEST_SRC="tst/IpCalcTest.java tst/TestSuite.java tst/TestRunner.java"
TEST_BIN=ipcalc/TestRunner

# check if JUNIT_JAR exists
if [ -d $JUNIT_JAR ]; then
    echo "\tjunit directory: $JUNIT_JAR \n\tOK!"
else 
    echo "Change JUNIT_JAR variable to match your installation!"
    echo "Current junit directory is set to $JUNIT_JAR"
    exit 1
fi


echo "\n\tcompiling IpCalc.java..."
javac -d bin $SOURCE_FILE && \
                        echo "\tOK!" 

echo "\n\tcompiling tests..."
javac  -d tst/bin -cp $TEST_CLSS_PATH $TEST_SRC && \
                  echo "\tOK!" && \
                  echo "\n\trunning test suite:\n" && \
OUT_FILE=`realpath $CLSS_PATH/ipcalc/IpCalc.class` && \
java -cp $TEST_CLSS_PATH $TEST_BIN && \
echo "\n\tNow you can run ipcalc with:" &&\
echo "\$ java -cp bin  "$OUT_FILE &&\
echo "\n\tor:\n\$ ./ipcalc" 

if [ ! -x ipcalc ]; then
    echo "#!/bin/sh" > ipcalc
    ABS_CLASS_P=`realpath $CLSS_PATH`
    echo "java -cp $ABS_CLASS_P $OUT_FILE"
    chmod 755 ipcalc
fi
