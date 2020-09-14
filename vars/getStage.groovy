import groovy.lang.GroovyShell

def call(String input) {
    String stage = """
{ it ->
    agent none
    steps {
        echo "The input was ${input}"
    }
}
"""
    return (Closure<?>) new GroovyShell().evaluate(stage);
}
