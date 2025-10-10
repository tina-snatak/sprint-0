def call(String TARGET_DIR = '.') {
    echo "===== Running Terraform Lint in ${TARGET_DIR} ====="
    dir(TARGET_DIR) {
        sh 'tflint --init'
        sh 'tflint'
    }
}
