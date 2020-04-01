def call (Closure body) {
    stage ('GitCheckout') {
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()

checkout([$class: 'GitSCM', 
	branches: [[name: "${config.branchName}"]], 
	doGenerateSubmoduleConfigurations: false, 
	extensions: [],
	submoduleCfg: [],
	userRemoteConfigs: [[credentialsId: 'GitHub_User',
	url: 'https://github.com/tamamshud/test-maven-project']]])
    }
}
