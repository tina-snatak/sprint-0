def call(String TARGET_DIR = '.') {
    echo "===== Running Terraform Validate in ${TARGET_DIR} ====="
    dir(TARGET_DIR) {
        withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'AWS_Configure']]) {
            sh 'terraform validate'
        }
    }
}
