def call(int stage) {
    container("busybox-${stage}") {
      sh "Hi from ${stage}"
    }
}
