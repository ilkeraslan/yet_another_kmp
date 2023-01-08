package routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.ilker.yet_another_kmp.models.Diet

val dietStorage = mutableListOf<Diet>()

fun Route.dietRoutes() {
    route("/diets") {
        get {
            call.respond(dietStorage)
        }
    }
}
