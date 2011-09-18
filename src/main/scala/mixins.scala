object Mixins extends App {
  trait HelloWorldable {
    def sayHello {
      println("Hello, World!")
    }
  }

  object Foo extends App with HelloWorldable {
    Foo.sayHello
  }
}