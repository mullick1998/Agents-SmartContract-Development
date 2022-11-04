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

_(click on **supplyChainAgents** directory > **Add Framework Support** > click on **Maven**)_

`**error: could not find artifact org.jason:jason:pom:3.1 in central (https://repo.maven.apache.org/maven2)`
![Jason package fail in maven](../images/mavenFail_jason.png)
- Start writing paper.

## 4th meeting (21st October 2022) [10:00-10:20]
- Check for how to add jar files locally and try maven again. <span style="color: green"> _(done)_  </span>
**Remove** ```<scope>runtime</scope>``` and **Add** in _pom.xml_:
```
<scope>system</scope>
<systemPath>/home/mostakim/thesis/jason/libs/jason-3.1.jar</systemPath>
```
maven file build successful, but the same issue still persists regarding _package error_ while running _AGENTS_.
- Put the **related papers** inside folder in repository <span style="color: green"> _(done)_  </span>
- Take more notice on case studies, do intensive research. <span style="color: yellow"> _Still doing_  </span>

## 5th meeting (28th October 2022) [09:30-09:35]
- Look for solving the error; more research.
- Check the example how they are using packages (Already checked)
- Tried importing all `.jar` files locally, inside `dir:/jason/libs`
- With both `pom.xml` in maven and `build.gradle` separately.

## 6th meeting (4th November 2022) [09:30-09:45]
- Check [https://stackoverflow.com/questions/4955635/how-to-add-local-jar-files-to-a-maven-project](https://stackoverflow.com/questions/4955635/how-to-add-local-jar-files-to-a-maven-project)
- Check [https://github.com/niklasf/python-agentspeak](https://github.com/niklasf/python-agentspeak) and [http://astralanguage.com/wordpress/](http://astralanguage.com/wordpress/)
- Try to look alternate solutions. <span style="color: Yellow"> _(Still looking)_  </span>
- Create README file for opinions and error. <span style="color: green"> _(done)_  </span>
- Put the thesis folder as a main one. <span style="color: green"> _(done)_  </span>
- Change repo name, put abbv. Changed to **Agents-SmartContract-Development** <span style="color: green"> _(done)_  </span>