def call(Closure body) {
    stage ('Test') {
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()
	steps {
           parallel (
                "performance test": { sh "${config.performanceCommand}" }
                "regression test": { sh "${config.regressionCommand}" }
                "integration test": { sh "${config.integrationCommand}" }
           )
       }
   }
}  
