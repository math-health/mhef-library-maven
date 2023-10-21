# Math Health - Maven Library example

![Java CI with Maven](https://github.com/math-health/mhef-library-maven/workflows/Java%20CI%20with%20Maven/badge.svg)

## References

1. [Publishing Java packages with Maven on GitHub Packages | Publishing Java Packages to GitHub Packages](https://www.youtube.com/watch?v=0nZjf4_1Npc).

## Description

This is an usage example about how to publish a Java libraries packages into **Maven repository** in every tag and execute the **Java CI with Maven** from every pushed commit to `main` branch.

The aim of the project is to configure the **GitHub Action** and your own project until display a single `"Hello, World!"` world using this library. **Nothing more!**

## Installation example

The following instructions are dedicated to install this example library into your Maven project.

- Requirements
    1. Java version >= 1.8.0.

### Manual installation setup

Once the `maven-0.0.2` file is downloaded from the **GitHub releases**, set it up by using the following instructions below:

- File tree structure

```plain
.           
├── pom.xml 
├── src     
│   ├── main
│   │   ├── java   
│   │   │   └── com
│   │   │       └── mhef
│   │   │           └── project     
│   │   │               └── App.java
│   │   └── resources
│   │       └── libs    
│   │           └── maven-0.0.2.jar
│   └── test            
│       └── java
│           └── com
│               └── mhef
│                   └── project
└── target     
    ├── classes
    │   └── com     
    │       └── mhef
    │           └── project      
    │               └── App.class
    └── generated-sources        
        └── annotations

```

- Edit the `pom.xml` file

```xml
<!-- Math Health Maven -->

<dependencies>
    <dependency>
        <groupId>com.mhef.library</groupId>
        <artifactId>maven</artifactId>
        <version>0.0.2</version>
        <scope>system</scope>
        <systemPath>${pom.basedir}/src/main/resources/libs/maven-0.0.2.jar</systemPath>
    </dependency>
</dependencies>
```

### Maven installation setup

As long as I do not how to publish this library public into Maven repositories directly, it requires one step more and also a token value to work. In fact, this mentioned token value is a private key and it is the same as the one configured from GitHub Actions Setup variables page. You **must** have this token to download automatically the repository.

- Edit the `pom.xml` file

```xml
<!-- Math Health Maven -->

<dependencies>
    <dependency>
        <groupId>com.mhef.library</groupId>
        <artifactId>maven</artifactId>
        <version>0.0.2</version>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-deploy-plugin</artifactId>
            <version>2.8.2</version>
            <configuration>
                <altDeploymentRepository>github::default::https://maven.pkg.github.com/math-health/mhef-library-maven</altDeploymentRepository>
            </configuration>
        </plugin>
    </plugins>
</build>
```

- Edit the `C:\Users\ReplaceWithYourUserName\.m2\settings.xml` file

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">
    <servers>
        <server>
            <id>github</id>
            
            <!-- My GitHub username -->
            <username>henrikbeck95</username>
            
            <!-- Insert the private token value here -->
            <password>JAVA_TOKEN</password>
        </server>
    </servers>
</settings>
```

## Usage example

Once the installation setup procedure is completed, it is time edit your own project

- Edit the class where it is located the main method

```java
package com.mhef.project;

import com.mhef.library.maven.Greetings;

public class App {
    public static void main(String[] args) {
        System.out.println(Greetings.helloWorld());
    }
}
```

- The output result

```plain
Hello, World!
```