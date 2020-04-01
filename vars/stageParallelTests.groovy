def call() {
pipeline {
  agent none
  stages {
    stage('Test') {
      parallel {
        
        stage('performance') {
          agent {
            node {
              label 'master'
            }
          }
          steps { sh "${config.performanceCommand}"  }
        }

        stage('regression') {
          agent {
            node {
              label 'master'
            }
          }
          steps { sh "${config.regressionCommand}" }
        }
      }
    }
  }
}
}
