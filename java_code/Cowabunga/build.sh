#!/bin/sh

SERVER=$HOME/minecraft-plugins/server

# Make the build directories if they aren't there.
# Throw away any error if they are.
mkdir bin 2>/dev/null
mkdir dist 2>/dev/null

# Remove any previous build products
rm -f bin/*/*.class
rm -f dist/*.jar

# Get the name of this plugin
# from the directory it's in
HERE=`pwd`
NAME=`basename $HERE`

# 1. Compile
echo "Compiling with javac..."
javac src/*.java -d bin -classpath $SERVER/craftbukkit.jar -sourcepath src -target 1.6 -g:lines,vars,source -source 1.6 || exit 1

# 2. Build the jar
echo "Creating jar file..."
jar -cf dist/$NAME.jar *.yml -C bin . || exit 1

# 3. Copy to server
echo "Deploying jar to $SERVER/plugins..."

test ! -d "$SERVER/plugins" && mkdir -p "$SERVER/plugins"

cp dist/$NAME.jar $SERVER/plugins || exit 1

echo "Completed Successfully."
