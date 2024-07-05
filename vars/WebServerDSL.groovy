class WebServer {
    String name
    int port
    List<Map<String, String>> routes = []

    def name(String name) {
        this.name = name
    }

    def port(int port) {
        this.port = port
    }

    def route(Closure closure) {
        def routeConfig = [:]
        closure.delegate = routeConfig
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure()
        routes << routeConfig
    }

    def start() {
        println "Starting server '$name' on port $port"
        routes.each { route ->
            println "Route: ${route.method} ${route.path} -> ${route.handler}"
        }
    }
}

def webServer(Closure closure) {
    def server = new WebServer()
    closure.delegate = server
    closure.resolveStrategy = Closure.DELEGATE_FIRST
    closure()
    server.start()
}
