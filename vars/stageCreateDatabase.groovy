def call(Closure body) {
    stage ('Create DB') {
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()

        sh "${config.dbCommand}"

    }
}

