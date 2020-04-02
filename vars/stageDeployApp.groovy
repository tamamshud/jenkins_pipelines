def call(Closure body) {
    stage ('Deploy') {
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()

        sh "${config.deployCommand}"

    }
}

