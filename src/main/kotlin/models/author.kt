package models

import org.litote.kmongo.*
import java.lang.Exception

// Book and Author datatypes
data class Book(val title: String, val genre: String)
data class Author(val name: String, val age: Int, val drink: String, val books: Array<Book>)

private val client = KMongo.createClient()
private val database = client.getDatabase("kmongotest")
private val col = database.getCollection<Author>()

// Push Author to MongoDB
 fun createAuthor(author: Author){
   try {
       col.save(author)
       println("\n Successfully Created an Author Object \n")
   }
   catch (error: Exception){
       println(error)
   }
}

//Get Author from MongoDB
fun getAuthor(name: String): Author?{
    var author: Author? =  null
   try{
       author = col.findOne { Author::name eq name}
   }
   catch (error: Exception){
       println(error)
   }
    return author
}

//Delete Author from MongoDB
 fun deleteAuthor(name: String){
    try {
        col.deleteOne(Author::name eq name)
        println("\n Author Successfully Deleted \n")
    }
    catch (error: Exception){
        println(error)
    }
}

//Update Author in MongoDB
fun updateAuthor(name: String, author: Author){
    try {
        println("todo")
    }
    catch (error: Exception){
        println(error)
    }
}
