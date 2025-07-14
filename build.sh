#!/bin/bash

# Java Build Script for Cursor with Gradle
# This script compiles and runs Java code using Gradle

set -e

# Colors for output
GREEN='\033[0;32m'
BLUE='\033[0;34m'
RED='\033[0;31m'
NC='\033[0m' # No Color

echo -e "${BLUE}🚀 Java Gradle Build Script${NC}"

# Check if Gradle wrapper exists, if not, download it
if [ ! -f "./gradlew" ]; then
    echo -e "${BLUE}📥 Setting up Gradle wrapper...${NC}"
    gradle wrapper --gradle-version 8.5
fi

# Clean and compile
echo -e "${BLUE}🧹 Cleaning previous build...${NC}"
./gradlew clean

echo -e "${BLUE}📦 Compiling Java sources...${NC}"
./gradlew compileJava

if [ $? -eq 0 ]; then
    echo -e "${GREEN}✅ Compilation successful!${NC}"
else
    echo -e "${RED}❌ Compilation failed!${NC}"
    exit 1
fi

# Run the application
echo -e "${BLUE}🎯 Running application...${NC}"
echo -e "${GREEN}--- Output ---${NC}"
./gradlew run --quiet --console=plain
echo -e "${GREEN}--- End ---${NC}"

echo -e "${GREEN}🎉 Done!${NC}" 