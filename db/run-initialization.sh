sleep 15s
/opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P T@skmanager123 -d master -C -i create-database.sql