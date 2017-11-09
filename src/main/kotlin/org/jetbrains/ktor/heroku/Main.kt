package org.jetbrains.ktor.heroku


import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.application.install
import org.jetbrains.ktor.features.DefaultHeaders
import org.jetbrains.ktor.host.embeddedServer
import org.jetbrains.ktor.http.ContentType
import org.jetbrains.ktor.logging.CallLogging
import org.jetbrains.ktor.netty.Netty
import org.jetbrains.ktor.response.respondText
import org.jetbrains.ktor.routing.Routing
import org.jetbrains.ktor.routing.get


fun main(args: Array<String>) {
    val port = Integer.valueOf(System.getenv("PORT"))
    embeddedServer(Netty, port, reloadPackages = listOf("heroku"), module = Application::main).start()
//    val port = Integer.valueOf(System.getenv("PORT"))
//    embeddedServer(Netty,port) {
//        routing {
//            get("/room/{id}") {
//                call.respondText("My Example Blog" , ContentType.Text.Html)
//            }
//        }
//    }.start(wait = true)
}


fun Application.main(){
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
        get("/demo") {
            call.respondText("Hello " , ContentType.Text.Html)
        }
    }

}






