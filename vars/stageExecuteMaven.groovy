def call(Closure body) {
    stage ('Execute Maven') {
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()

        withMaven(
            maven: "${config.mavenVersion}",
            mavenOpts: "${config.jvmOptions}"
        ){
            sh "${config.mavenCommand}"
        }
    }
}
