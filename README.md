# Math Health - Maven Library example

![Java CI with Maven](https://github.com/math-health/mhef-library-maven/workflows/Java%20CI%20with%20Maven/badge.svg)

## References

- Articles
    1. [Hello GitHub Actions CI + Package Registry + Maven](https://github.com/TobseF/HelloMaven).
    1. [Publish Java package with maven on GitHub packages](https://github.com/devopshint/publish-java-package-with-maven-on-github-packages).

- Video tutorials
    1. [Publishing Java packages with Maven on GitHub Packages | Publishing Java Packages to GitHub Packages](https://www.youtube.com/watch?v=0nZjf4_1Npc).

## Description

This is the usage example about how to execute the **Java CI with Maven** from every commited pushed to the `main` branch. Furthermore, this is also about how to publish a Java library package into **Maven repository** in every tag created and pushed. These features are possible by using the **GitHub Actions** features.

The aim of the project is to configure your own project, using the result from this library to display the single `"Hello, World!"` message. **Nothing more!**

## Installation setup

The following instructions are dedicated to install this example library into your Maven project.

### Requirements

- Requirements tools
    1. [x] Java JDK version >= 1.8.0.
    1. [x] Your prefencered IDE software (such Eclipse, IntelliJ, NetBeans, Visual Studio Code or Vim).

### Manual installation setup

Once the `maven-0.0.3.jar` file is downloaded from the **GitHub releases**, set it up by inserting into the `src/main/resources/libs/` directory path. Check it out the instructions below to know more:

- File tree structure

```markdown
.           
├── pom.xml
├── **src**
│   ├── **main**
│   │   ├── java
│   │   │   └── com
│   │   │       └── mhef
│   │   │           └── project
│   │   │               └── App.java
│   │   └── **resources**
│   │       └── **libs**
│   │           └── **maven-0.0.3.jar**
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
        <version>0.0.3</version>
        <scope>system</scope>
        <systemPath>${pom.basedir}/src/main/resources/libs/maven-0.0.3.jar</systemPath>
    </dependency>
</dependencies>
```

### Maven installation setup

#### From GitHub repository (using a private token access)

It is required a token value to procedure to work whose it is a **private key** access. This token value is the same as the one configured from **GitHub Actions** in **Setup variables** settings page (from the video in the reference section). You **must** have this token to download automatically the repository.

- Edit the `pom.xml` file

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <!-- Math Health Maven -->

    <dependencies>
        <dependency>
            <groupId>com.mhef.library</groupId>
            <artifactId>maven</artifactId>
            <version>0.0.3</version>
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
</project>
```

- Edit the `settings.xml` file from `.m2` directory
  1. [x] In case you are using BSD, Linux or MacOS operating system, edit the `$HOME/.m2/settings.xml` file.
  1. [x] In case you are using Windows operating system, edit the `C:\Users\YourUserName\.m2\settings.xml` file.

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">
    <servers>
        <server>
            <!-- This a default value about the place where the library is stored -->
            <id>github</id>
            
            <!-- My GitHub username, not the organization -->
            <username>henrikbeck95</username>
            
            <!-- Insert the private token value here by replacing the tag content value -->
            <password>JAVA_TOKEN</password>
        </server>
    </servers>
</settings>
```

#### From Maven Central repository (no private token access is required)

As long as I do not how to publish this library public into **Maven Central Repository** directly, this instruction section is not available for a while.

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