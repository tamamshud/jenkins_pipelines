def call (Closure body) {
    stage ('GitCheckout') {

checkout([$class: 'GitSCM', 
	branches: [[name: "${config.branchName}"]], 
	doGenerateSubmoduleConfigurations: false, 
	extensions: [],
	submoduleCfg: [],
	userRemoteConfigs: [[credentialsId: 'GitHub_User',
	url: 'https://github.com/tamamshud/test-maven-project']]])
    }
}
