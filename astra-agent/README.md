## ASTRA (Agent programming Language)
ASTRA is based upon AgentSpeak(L). 
ASTRA programs are designed to be familiar and the syntax is based on Java.
Agent programs are written in a text file that has a ".astra" extension
```
<plugin>
    <groupId>com.astralanguage</groupId>
    <artifactId>astra-maven-plugin</artifactId>
    <version>1.3.2</version>
</plugin>
```
## Run Agents
To run the program, you can either add a properties setting to the maven build file:
````
<properties>
    <astra.main>Hello</astra.main>
</properties>
````
Alternatively, you can override the default agent program name at the command line:
````
mvn -Dastra.main=Hello
````

## Error
`import java.math.BigInteger;` import successful

`import org.web3j.crypto.Credentials;` import unsuccessful

Same issue as JASON.

```
[INFO] --- astra-maven-plugin:1.3.2:compile (astra.compile) @ hello ---
[ASTRACompiler] Creating Target Folder: target/gen/java / full path: /home/mostakim/Downloads/thesis_maven/astra-agent/target/gen/java
Hello.java:17: error: package org does not exist
import org.web3j.crypto.Credentials;
          ^
Note: Some input files use unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error

```