pipeline {
    agent any

    stages{
        stage('Build Jar') {
            steps{
                bat "mvn clean package -DskipTests"
            }
        }

        stage('Build Image') {
            steps{
                bat "docker build -t=rupakrpk93/selenium:latest ."
            }
        }

        stage('Push Image') {
            environment{
                DOCKER_HUB = credentials('dockerhub-credentials')
            }
            steps{
                bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
                bat 'docker push rupakrpk93/selenium:latest'
                bat "docker tag rupakrpk93/selenium:latest rupakrpk93/selenium:${env.BUILD_NUMBER}"
                bat "docker push rupakrpk93/selenium:${env.BUILD_NUMBER}"
            }
        }
    }

    post {
        always {
            bat "docker logout"
        }
    }
}