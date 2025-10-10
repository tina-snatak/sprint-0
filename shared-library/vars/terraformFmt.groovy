def call(String TARGET_DIR = '.') {
    echo "===== Running Terraform FMT in ${TARGET_DIR} ====="
    dir(TARGET_DIR) {
        sh 'terraform fmt -check -recursive'
    }
}
