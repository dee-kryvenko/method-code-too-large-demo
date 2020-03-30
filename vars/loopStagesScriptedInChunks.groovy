def call(int stages) {
    for (stage = 1; stage <= stages; stage++) {
        String pipeline = """
stage('Stage ${stage}') {
    podTemplate(yaml: getPod(${stage})) {
        node(POD_LABEL) {
            doSomethingBasedOnStageNameOrWhatever(${stage})
        }
    }
}
"""
        echo pipeline
        evaluate(pipeline)
    }
}
