def foo = {
  put('var1', "foo value 1")
}

def call(body) {
   def config = [:]
   body.resolveStrategy = Closure.DELEGATE_FIRST
   body.delegate = config
   body()

   println config.var1 // display foo value 1 : for me the magic is here !!
}

call(foo)
