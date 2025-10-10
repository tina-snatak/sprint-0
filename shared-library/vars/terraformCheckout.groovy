def call(String GIT_REPO, String GIT_BRANCH, String CRED_ID = 'git') {
    echo "===== Checking out ${GIT_BRANCH} from ${GIT_REPO} ====="
    checkout([
        $class: 'GitSCM',
        branches: [[name: GIT_BRANCH]],
        doGenerateSubmoduleConfigurations: false,
        extensions: [[$class: 'CleanBeforeCheckout']],
        userRemoteConfigs: [[url: GIT_REPO, credentialsId: CRED_ID]]
    ])
}
