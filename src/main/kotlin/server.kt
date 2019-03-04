import io.javalin.Javalin
import models.*
import java.lang.Exception

fun main(args: Array<String>) {
    val app = Javalin.create().start(7000)

    app.get("/"){ctx ->
        ctx.status(200)
        ctx.result("Welcome to my API")
    }

    app.get("/author/:name"){ctx ->
        try {
            val author = getAuthor(ctx.pathParam("name"))
            ctx.status(200)
            ctx.result(author.toString())
        }
        catch (error: Exception){
            println(error)
            ctx.status(500)
        }
    }

    app.post("/author"){ctx ->
        try {
            val authorObj = ctx.body<Author>()
            createAuthor(authorObj)
            ctx.status(201)
        }catch (error: Exception){
            println(error)
            ctx.status(500)
        }
    }

    app.delete("/author"){ctx ->
        try {
            val authorObj = ctx.body<Author>()
            val name: String = authorObj.name.toString()
            deleteAuthor(name)
            ctx.status(202)
        }
        catch (error: Exception){
            println(error)
            ctx.status(500)
        }
    }



// Middleware functions
//    app.before{ ctx ->
//        println("\n \n A request has been sent to the server! \n \n")
//    }
}