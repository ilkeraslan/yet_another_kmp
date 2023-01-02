package routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val customerStorage = mutableListOf<Customer>()

fun Route.customerRoutes() {
    route("/customer") {
        get {
            call.respond(customerStorage)
        }

        get("{id?}") {

        }

        post {

        }

        delete("{id?}") {

        }
    }
}
