# API Client Utilities

# Usage
    * To run the C++ project
```sh
cd CPP/
# move the setup script
cp ../Script/setup.sh ../CPP/

chmod +x setup.sh

./setup.sh

```
    * To run the Python project
```sh
cd api_client_utilities/
python setup.py install
```

    * Run the Java files
```sh
cd Java/

# Compile directly
javac Main.java # not always neccecary, will generate classfiles

java Main.java # compile directly

# Use Maven
chmod +x maven.sh
mvn verify
mvn archetype:generate -DgroupId=com.yourapp.app -DartifactId=your-app DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DinteractiveMode=false

# build the package
mvn package

# run the project
java -cp target/your-app-1.0-SNAPSHOT.jar com.yourapp.app App
```