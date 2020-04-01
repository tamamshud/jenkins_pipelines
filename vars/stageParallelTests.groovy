def call() {
  stages {
    stage('Test') {
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()

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

