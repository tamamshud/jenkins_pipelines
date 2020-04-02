def call(Closure body) {
    stage ('Send Email') {
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()
            emailext(subject: "${env.JOB_NAME} was " + "${env.BUILD_STATUS}", body: "It's Alive", to: "${config.recipient}", replyTo: '');
    }
}
