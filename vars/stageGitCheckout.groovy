def call (Closure body) {
    stage ('GitCheckout') {
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()
        
        checkout([$class: 'GitSCM',
            branches: [[name: "${config.branchName}"]],
            doGenerateSubmoduleConfigurations: false,
            extensions: [[$class: 'RelativeTargetDirectory',
            submoduleCfg: [],
            userRemoteConfigs: [[
                credentialsId: "${config.credentialsID}" , 
                url: "${config.gitRepository}" 
            ]]
        ])
    }
}
