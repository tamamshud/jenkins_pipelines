def call(Closure body) {
    stage ('Test') {
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()
           parallel 
                performance: { sh "${config.performanceCommand}" }
                regression: { sh "${config.regressionCommand}" }
                integration: { sh "${config.integrationCommand}" }
          
       
   }
}  
