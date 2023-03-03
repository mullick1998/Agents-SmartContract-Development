FROM alpine:latest
RUN apk --no-cache add python3
RUN python -m ensurepip --default-pip
RUN pip install agentspeak
COPY . .
WORKDIR /python-Contracts-Agents
CMD [ "python3", "env.py"]