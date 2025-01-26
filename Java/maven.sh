# unzip the tarball
tar xzvf apache-maven-3.9.9-bin.tar.gz 

# function to add Maven to PATH - source: https://codereview.stackexchange.com/questions/88236/unix-shell-function-for-adding-directories-to-path
add2path() {
  if ! echo "$PATH" | PATH=$(getconf PATH) grep -Eq '(^|:)'"${1:?missing argument}"'(:|\$)' ; then # Use the POSIX grep implementation
    if [ -d "$1" ]; then # Don't add a non existing directory to the PATH
      if [ "$2" = front ]; then # Use a standard shell test
        PATH="$1:$PATH"
      else
        PATH="$PATH:$1"
      fi
      export PATH
    fi
  fi
}

# check that the version install is correct
mnv --version


# example output
: ' 
Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: D:\apache-maven-3.6.3\apache-maven\bin\..
Java version: 1.8.0_232, vendor: AdoptOpenJDK, runtime: C:\Program Files\AdoptOpenJDK\jdk-8.0.232.09-hotspot\jre
Default locale: en_US, platform encoding: Cp1250
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
'