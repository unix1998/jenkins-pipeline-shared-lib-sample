package org.example

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
        println 'route method called'
        def routeConfig = [:]
        closure.delegate = routeConfig
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure()
        println routeConfig
        routes << routeConfig
    }

    def start() {
        println "Starting server '$name' on port $port"
        routes.each { route ->
            println "Route: ${route.method} ${route.path} -> ${route.handler}"
        }
    }
}

