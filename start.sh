#!/bin/bash
nohup java -classpath ".:./lib/*"  com.asiainfo.a4.gathersend.myGatherSend.App> stdout.log &
echo $! > ./iap.pid