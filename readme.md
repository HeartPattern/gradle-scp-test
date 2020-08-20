# Sample project to show how to use scp in gradle task

Execute upload task with following properties. 
Properties can set via command line argument or gradle properties file.

## host
Host address of remote server

## remote_path
Path to save file in remote server

## username
Username to login

## identity
Identity file to login

## port
SSH port of remote server

## Example usage
```
./gradlew upload -Pport=22 -Pidentity=/Users/heartpattern/.ssh/id_rsa -Pusername=heartpattern -Phost=heartpattern.io -Premote_path=/home/heartpattern
```