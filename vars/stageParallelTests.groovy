def call(Closure body) {
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


