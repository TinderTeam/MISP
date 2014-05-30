

set CURRENT_PATH=%cd%

set /p DB_USER=pls input database user name:
set /p DB_PASSWORD=pls input database password:

 
set DB_NAME=MISPDB

set CREATE_TALBE_PATH=%CURRENT_PATH%/CreateTable
set STATIC_DATA_PATH=%CURRENT_PATH%/StaticData


mysql -u%DB_USER% -p%DB_PASSWORD% <%CREATE_TALBE_PATH%/MISPDDL.sql



mysql -u%DB_USER% -p%DB_PASSWORD% <%STATIC_DATA_PATH%/system_menu.sql
mysql -u%DB_USER% -p%DB_PASSWORD% <%STATIC_DATA_PATH%/system_user.sql
mysql -u%DB_USER% -p%DB_PASSWORD% <%STATIC_DATA_PATH%/system_meta_data.sql

 
 
pause
