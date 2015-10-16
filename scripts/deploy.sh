#!/bin/bash
cd /home/ec2-user/AlucarDeploy

mvn package

cp -rfv target/*.war /usr/share/tomcat7/webapps/AlucarWeb.war

service tomcat7 restart

