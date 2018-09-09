pipeline {
    agent any
    stages {

        stage('Build') {
            steps {
                sh '''cd petsafety-mock-service
                      mvn clean install'''
            }
        }
        stage('Azure FTP Publish') {
           steps {
               sh ''' cd petsafety-mock-service/target/
                      az login --service-principal -u "deec0b6d-d853-4f85-8391-c9bd8c97c0e3" --password "secure_password" --tenant "c98d2fc9-def0-43ca-a603-a8a1e287fa9d"
                      az webapp stop --name "Group4Hackathon" --resource-group "MBRDI_Hackathon_RS"
                      sleep 15
                      echo "Web App stopped"
                      curl -v --ftp-ssl --upload-file  "petsafety-mock-service-0.0.1-SNAPSHOT.jar" --user "Group4Hackathon\\hackaton04":"hackaton123" ftp://waws-prod-dm1-087.ftp.azurewebsites.windows.net/site/wwwroot/
                      sleep 10
                      az webapp start --name "Group4Hackathon" --resource-group "MBRDI_Hackathon_RS"
                      '''
           }
        }

    }
}
