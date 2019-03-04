import io.javalin.Javalin

fun main(args: Array<String>) {
    val app = Javalin.create().start(7000)

    app.get("/"){ctx ->
        ctx.result("Hello World")
    }

// Middleware functions 
//    app.before{ ctx ->
//        println("\n \n A request has been sent to the server! \n \n")
//    }
}