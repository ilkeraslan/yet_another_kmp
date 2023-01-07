package routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.indexRoutes() {
    route("/") {
        get {
            call.respondText(
                text = "Welcome",
                status = HttpStatusCode.OK
            )
        }
    }
}
