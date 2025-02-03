FROM mcr.microsoft.com/mssql/server:2022-CU17-ubuntu-22.04

WORKDIR /usr/src/app

COPY . /usr/src/app

ENV SA_PASSWORD T@skmanager123
ENV ACCEPT_EULA Y
ENV MSSQL_PID Express

EXPOSE 1433

CMD /bin/bash ./entrypoint.sh