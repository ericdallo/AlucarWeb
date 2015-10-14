#!/bin/bash
cd /home/ec2-user/AlucarDeploy

mvn clean compile package

sudo cp -rfv target/*.war /usr/share/tomcat7/webapps/Alucar.war

sudo service tomcat7 restart

