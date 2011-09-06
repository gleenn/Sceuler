/*
#!/bin/sh
exec scala $0 $@
!#
*/

trait HelloWorldable {
	def sayHello {
		println("Hello, World!")
	}
}

object Foo extends App with HelloWorldable {
	Foo.sayHello	
}


