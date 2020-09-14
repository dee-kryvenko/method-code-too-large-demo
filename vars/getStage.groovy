import groovy.lang.GroovyShell

def call(String input) {
    String stage = """
L:{
    agent none
    steps {
        echo "The input was ${input}"
    }
}
"""
    return (Closure<?>) new GroovyShell().evaluate(stage);
}
