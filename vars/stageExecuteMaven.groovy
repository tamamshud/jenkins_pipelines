def call(Closure body) {
    stage ('Execute Maven') {
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()

        sh "${config.mavenCommand}"
        
    }
}
