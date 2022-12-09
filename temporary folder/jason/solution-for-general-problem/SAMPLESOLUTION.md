
# Solution for the jar file problem of JASON

```bash
mvn install:install-file -Dfile=libs/jason-3.1.jar -DgroupId=org.jason -DartifactId=supplyChainAgents -Dversion=1.0 -Dpackaging=jar
```

Open a folder named libs and put the jason-3.1.jar into the folder

Put the following configuration

```bash
<dependency>
    <groupId>org.jason</groupId>
    <artifactId>jason</artifactId>
    <version>3.1</version>
    <scope>system</scope>
    <systemPath>${basedir}/libs/jason-3.1.jar</systemPath>
</dependency>
```

Put the following property configuration into the maven file

```bash
<properties>
    <maven.compiler.source>11 </maven.compiler.source>
    <maven.compiler.target>11 </maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
</properties>
```


Do not use the following configuration in the web3j maven configuration

```
<scope>runtime</scope>
```

Runtime scope is only useful for unit tests at runtime or database connection parameters for JDBC drivers. We need compile time features of Web3j.

When I run the main method with the following command, there is no runtime issue.

```bash
mvn compile exec:java -Dexec.mainClass="thesis.SupplyChain.connect"
```


@Source: https://intellipaat.com/community/6786/how-to-add-local-jar-files-to-a-maven-project 