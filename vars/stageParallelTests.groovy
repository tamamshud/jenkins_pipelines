def call(Closure body) {
    stage ('Test') {
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()
           parallel performance: { 
               stage("perf"){
                   node("master"){
                         sh "${config.performanceCommand}"
                   }
               }
           }, regression: {
              stage("perf"){
                   node("master"){
                         sh """ hostname """
                   }
               }
           }
     }
}









               
