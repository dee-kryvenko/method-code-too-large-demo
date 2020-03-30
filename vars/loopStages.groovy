def call(int stages) {
    String pipeline = """
pipeline {
  agent none
  stages {
"""
    for (stage = 1; stage <= stages; stages++) {
        pipeline += """
    stage('Stage ${stage}') {
        agent {
            kubernetes {
                yaml getPod(${stage})
            }
        }
        steps {
            doSomethingBasedOnStageNameOrWhatever(${stage})
        }
    }
"""
    }
    pipeline += """
  }
}
"""
    echo pipeline
    evaluate(pipeline)
}
