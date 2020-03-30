def call(int stages) {
    String pipeline = ""
    for (stage = 1; stage <= stages; stage++) {
        pipeline += """
stage('Stage ${stage}') {
    podTemplate(yaml: getPod(${stage})) {
        node(POD_LABEL) {
            doSomethingBasedOnStageNameOrWhatever(${stage})
        }
    }
}
"""
    }
    echo pipeline
    evaluate(pipeline)
}
