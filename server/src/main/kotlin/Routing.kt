import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import routes.customerRoutes

fun Application.configureRouting() {
    routing {
        customerRoutes()
    }
}
