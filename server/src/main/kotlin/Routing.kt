import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import routes.customerRoutes
import routes.indexRoutes

fun Application.configureRouting() {
    routing {
        indexRoutes()
        customerRoutes()
    }
}
