#!/bin/bash

# Install CPR from Github and setup the C++ project

set -e # if any errors are caugth, exit the program

echo "pwd" # check current path

CPR_REPO="https://github.com/libcpr/cpr.git"
INSTALL_DIR="/usr/local"

check_gcc_version() {
    local MIN_VERSION=9
    local INSTALLED_VERSION=$(gcc -dumpversion | cut -d. -f1)
    if [[$INSTALLED_VERSION -lt $MIN_VERSION]]; then
        echo "Update GCC to the newest version $MIN_VERSION or never.."
        sudo apt install -y software-properties-common
        sudo add-apt-repository -y ppa:ubuntu-toolchain-r/test
        sudo apt update
        sudo apt install -y gcc g++ # install g++
    else 
        echo "GCC version $INSTALLED_VERSION will suffice"
    fi
}

# install depencies
echo "Installing required depencies..."
sudo apt update
sudo apt install -y cmake libssl-dev git

# check whether or not gcc needs to be updated
echo "Checking gcc-version"
check_gcc_version

#clone the repo
echo "Cloning from Github..."
git clone --depth 1 "$CPR_REPO"
cd cpr


# build CPR

echo "Building and installing CPR..."

cmake -H. -Bbuild -DCPR_BUILD_TESTS=OFF -DCPR_USE_SYSTEM_CURL=ON -DCMAKE_INSTALL_PREFIX=$INSTALL_DIR
cmake --build build --target install

# clean up
echo "Running clean up..."
cd ..
rm -rf cpr

echo "CPR and all required depencies installed!"