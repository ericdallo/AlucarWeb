# :diamond_shape_with_a_dot_inside: Projeto Alucar :diamond_shape_with_a_dot_inside:

Projeto sobre locação de veículos referente ao curso de Ciẽncia da Computação.

O Projeto WEB utiliza:

- VRaptor4 (Framework MVC)
- JPA (Especificção do JAVA EE para persistência de dados)
- Bootstrap (Framework de front-end)
- Maven (Gerenciador de dependencias)

### Instalacao / Configuração

__Maven__ 

``sudo apt-get install maven``

Importar o projeto no eclipse como ``Existing Maven Projects``

__Banco de Dados__

O sistema de login usa MD5 como criptografia nas senhas, por isso deve ter previamente uma senha salva em MD5 para autenticação no login.

[MD5 Generator](http://www.miraclesalad.com/webtools/md5.php)

Editar as credencias do banco no arquivo ``src/main/resources/META-INF/persistence.xml``


### Deploy

Para inicar o deploy da aplicacao, executar o script ``prepare-deploy.sh`` passando como argumento o IP da maquina.
Por exemplo: 
```bash
./prepare-deploy.sh $EC2TCC
```

Usuarios padrão
SUPERVIDOR - user: eric, senha: 123mudar
ATENDENTE -  user: ramon, senha: 123mudar

Um DUMP do banco se encontra na pasta scripts


