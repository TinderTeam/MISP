

set CURRENT_PATH=%cd%

set /p DB_USER=pls input database user name:
set /p DB_PASSWORD=pls input database password:

 
set DB_NAME=fuegodb

set CREATE_TALBE_PATH=%CURRENT_PATH%/CreateTable
set STATIC_DATA_PATH=%CURRENT_PATH%/StaticData


for /R  %%s in (CreateTable\*.sql) do  (
mysql -u%DB_USER% -p%DB_PASSWORD% < %%s
 )

 
for /R  %%s in (StaticData\*.sql) do  (
mysql -u%DB_USER% -p%DB_PASSWORD% < %%s
 )


pause
