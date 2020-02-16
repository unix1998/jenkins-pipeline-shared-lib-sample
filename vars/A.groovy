class A {
    Script script;
    public void a() {
        script.echo("Hello from A")

        def b = new B(script)
        echo "Calling B.b()"
        b.b()
    }
}
