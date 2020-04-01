def call(Closure body) {
    stage ('Test') {
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()
           parallel performance: { 
               stage("Performance"){
                   node("master"){
                         sh "${config.testDirectory} && ${config.performanceCommand}"
                   }
               }
           }, regression: {
              stage("Regression"){
                   node("master"){
                         sh "${config.testDirectory} && ${config.regressionCommand}"
                   }
               }
           }, integration: {
              stage("Integration"){
                   node("master"){
                         sh "${config.testDirectory} && ${config.integrationCommand}"
                   }
              }
           }
     }
}









               
