# Introduction

This is an example of a spring-boot application with JPA and Angular which works on SAP's HCP platform. If the 
server is running, you can find a demo [here](https://datalakep1941749386trial.hanatrial.ondemand.com/server/)
 
## Initial deployment
 
Build the deployable .war-file with 
 
    mvn -P production clean package
    
If you configure your server in the HCP frontend, do not forget to set
    
    -Dspring.profiles.active=production
    
otherwise no database connection can be established.    
 
 
## Local development
 
Start local development by simply executing ```com.mlesniak.sap.playground.Main```.
    
    

## TODOs
 
- Better documentation of initial and continous deployment; see scripts/update-production.sh for an example
- I18N in Angular
- Fancy animation on adding text