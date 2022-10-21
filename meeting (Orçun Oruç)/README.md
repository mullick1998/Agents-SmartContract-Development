# Meeting Description

## 1st meeting (21st September 2022) [15:05 - 15:25]

- Discussed the current implementations and asked about the solution to change contract owner in web3j. <span style="color: yellow"> _(General info)_  </span>
- solution provided ~ Proxy contract, use cli(not a good option, might have to use shell file or change everytime using cli), interface separator(no good) <span style="color: red"> _(not successful)_  </span>
- increase solidity version to use @openzeppelin/contracts-upgradeable <span style="color: green"> _(done)_  </span>
- also asked to create 1 agent at a time (e.g. retailer agent) and check if it's running by checking string <span style="color: green"> _(done)_  </span>


## 2nd meeting (07th October 2022) [09:31 - 09:55]
- Downgrade the solidity version to check the compatibility with gradle <span style="color: orange"> _(Checked several versions for compatibilty, even tried to find compatible version between web3j with Jason)_  </span>
- Put readme.md file for each folder for better understanding <span style="color: green"> _(done)_  </span>
- Write the directory structure <span style="color: green"> _(done)_  </span>
- asked to write `mailto:infscis.dse@mailbox.tu-dresden.de`  to request for the APPLICATION FORM for **MASTER THESIS** <span style="color: green"> _(done)_  </span>


## 3rd meeting (14th October 2022) [17:00 - 17:15]
- Only has AgentSpeak compiler, compiler error basically, Find AgentSpeak jason compiler that works with java compiler.
- Try with `maven` instead of `gradle`. <span style="color: orange"> _(tried but didn't work)_  </span>

`**error: could not find artifact org.jason:jason:pom:3.1 in central (https://repo.maven.apache.org/maven2)`
![Jason package fail in maven](../images/mavenFail_jason.png)
- Start writing paper.

## 4th meeting (14th October 2022) []

