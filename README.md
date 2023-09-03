# Using Spring JPA with multiple Databases

___

## Resources
* Java 11
* Spring Boot 2.7.15
* H2

## Goal

Use of Spring JPA for persistence in multiple databases.

### Resume

In this project two configuration classes were built to manage connection and transaction control: *ConfigDBOne.class* and *ConfigDBTwo.class*.
In the configuration classes, the configuration properties and datasources are described by annotations. The difference is the assignment of configuration responsibilities by packages, onde cada classe de confiração se responsabiliza por um pacote ondes estão seus respectivos repositories e outro pelos persistences models.


---
Powered By
*__Carlos Alves__*

__casdeveloper@icloud.com__
