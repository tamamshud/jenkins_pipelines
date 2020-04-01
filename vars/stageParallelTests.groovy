def call(Closure body) {
    stage ('Test') {
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()
	steps {
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
