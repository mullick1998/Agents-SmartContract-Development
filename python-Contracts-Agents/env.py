#!/usr/bin/env python

import os

import agentspeak
import agentspeak.runtime
import agentspeak.stdlib

env = agentspeak.runtime.Environment()

with open(os.path.join(os.path.dirname(__file__), "asl/supplyChainAgent.asl")) as source:
    agents = env.build_agents(source, 1, agentspeak.stdlib.actions)

with open(os.path.join(os.path.dirname(__file__), "asl/manufacturerAgent.asl")) as source:
    agents.append(env.build_agent(source, agentspeak.stdlib.actions))
    
with open(os.path.join(os.path.dirname(__file__), "asl/wholesalerAgent.asl")) as source:
    agents.append(env.build_agent(source, agentspeak.stdlib.actions))

with open(os.path.join(os.path.dirname(__file__), "asl/retailerAgent.asl")) as source:
    agents.append(env.build_agent(source, agentspeak.stdlib.actions))

if __name__ == "__main__":
    env.run()