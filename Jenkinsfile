@Library('jenkins_pipelines@master') _
 
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
         stage ('Execute Maven') {
            withMaven(
                jdk: "${jdkVersion}",
                maven: "${mavenVersion}",
                mavenOpts: "${jvmOptions}"
            )
            {
                sh "mvn clean install"
            }
        }
    }
}
