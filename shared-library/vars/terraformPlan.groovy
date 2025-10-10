def call(String TARGET_DIR = '.') {
    echo "===== Running Terraform Plan in ${TARGET_DIR} ====="
    dir(TARGET_DIR) {
        withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'AWS_Configure']]) {
            sh 'terraform plan -input=false -lock=false -no-color'
        }
    }
}
