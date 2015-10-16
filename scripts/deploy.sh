#!/bin/bash
cd /home/ec2-user/AlucarDeploy

mvn clean compile package

cp -rfv target/*.war /usr/share/tomcat7/webapps/Alucar.war

service tomcat7 restart

