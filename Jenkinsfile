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
                bat "docker build -t=rupakrpk93/selenium ."
            }
        }

        stage('Push Image') {
            environment{
                DOCKER_HUB = credentials('dockerhub-credentials')
            }
            steps{
                bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
                bat "docker push rupakrpk93/selenium"
            }
        }
    }

    post {
        always {
            bat "docker logout"
        }
    }
}