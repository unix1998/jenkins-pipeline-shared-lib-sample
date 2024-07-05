import org.example.WebServer

def call(Closure closure) {
    def server = new WebServer()
    closure.delegate = server
    closure.resolveStrategy = Closure.DELEGATE_FIRST
    closure()
    server.start()
}
