def call(Closure body) {
    stage ('Parallel Tests') {
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()

        parallel {
             stage ('Performance test') {
                 steps {
                    sh 'config.performanceCommand'
                 }
             }
             stage ('Regression test') {
                 steps {
                    sh 'config.regressionCommand'
                 }
             }
             stage ('Integration test') {
                 steps {
                    sh 'config.integrationCommand'
                 }
             }
         }
    }
}

