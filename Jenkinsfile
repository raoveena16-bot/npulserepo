pipeline {
    agent any

    stages {
        stage('Nexus_healthcheck') {
            steps {
               bat 'ping 82.197.92.72 -n 5'
            }
        }
        stage('Download_Code_From_Github') {
            steps {
                git branch: 'main', url: 'https://github.com/raoveena16-bot/npulserepo.git'
            }
        }
         stage('Execute_SeleniumTest') {
            steps {
                dir('nexuspulse') {
    bat 'mvn clean test'
}
            }
        }
    }
}
