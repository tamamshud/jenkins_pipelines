@Library('jenkins_pipelines@master') _
 
pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
            gitCheckout(
                branch: "master",
                url: "https://github.com/Sanwel/JavaApp"
            )
            }
    }
    }
}
