def call(int stages) {
    String pipeline = """
pipeline {
  agent none
  stages {"""
    stages.times { stage ->
        pipeline += """    stage('Stage ${stage}') {
        agent {
            kubernetes {
                yaml getPod(${stage})
            }
        }
        steps {
            doSomethingBasedOnStageNameOrWhatever(${stage})
        }
    }"""
    }
    pipeline += """  }
}"""
    echo pipeline
    evaluate(pipeline)
}
