#!/bin/bash
cd /home/ec2-user/AlucarDeploy

mvn package

WAR_PATH=$(ls target/*.war |awk '{print $1}' |tail -1)

rm -rfv /usr/share/tomcat7/webapps/AlucarWeb
sudo cp -rfv $WAR_PATH /usr/share/tomcat7/webapps/AlucarWeb.war

sudo cp -rfv ../alucar.properties /usr/share/tomcat7/webapps/AlucarWeb/WEB-INF/classes/com/alucarweb/util/alucar.properties

sudo service tomcat7 restart

