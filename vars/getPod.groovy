def call(int stage) {
    return """
apiVersion: v1
kind: Pod
metadata:
  labels:
    my-label: my-pod-${stage}
spec:
  containers:
  - name: busybox-${stage}
    image: busybox
    command:
    - cat
    tty: true
"""
}
