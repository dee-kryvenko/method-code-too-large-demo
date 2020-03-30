def call(int stage) {
    container("busybox-${stage}") {
      sh "echo Hi from ${stage}"
    }
}
