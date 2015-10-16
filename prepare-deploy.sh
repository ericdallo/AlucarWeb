#!/bin/bash
EC2TCC=$1
echo "Iniciando deploy na maquina: $EC2TCC"

ssh -i /etc/amazon/tcckey.pem  ec2-user@$EC2TCC '/home/ec2-user/initDeploy.sh'
