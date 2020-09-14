import groovy.lang.GroovyShell

def call(string input) {
    String stage = """
{
    agent none
    steps {
        echo "The input was ${input}"
    }
}
"""
    return (Closure<?>) new GroovyShell().evaluate(stage);
}
