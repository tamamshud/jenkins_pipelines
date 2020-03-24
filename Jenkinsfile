@Library('my-shared-library@master') _
 
pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
            gitCheckout(
                branch: "master",
                url: "https://github.com/tamamshud/jenkins_pipelines"
            )
            }
    }
    }
}
