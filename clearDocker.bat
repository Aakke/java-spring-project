@ECHO OFF

ECHO Killing the application and removing containers

powershell "docker kill $(docker ps -a -q)"
powershell "docker rm $(docker ps -a -q)"

powershell "docker image prune -af"
