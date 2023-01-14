import me.ilker.yet_another_kmp.models.Diet
import me.ilker.yet_another_kmp.shared.cache.Database
import me.ilker.yet_another_kmp.shared.cache.DatabaseDriverFactory
import meilkeryetanotherkmpsharedcache.DietTable

class DietSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = DietApi()

    @Throws(Exception::class)
    suspend fun getDiets(forceReload: Boolean): List<Diet> {
        val cachedDiets = database.getDiets().map { diet ->
            Diet(name = diet.name)
        }

        return if (cachedDiets.isNotEmpty() && !forceReload) {
            cachedDiets
        } else {
            api.getDiets().also { diets ->
                database.clearDatabase()
                database.createDiets(
                    diets.map { diet ->
                        DietTable(
                            id = 0L,
                            name = diet.name
                        )
                    }
                )
            }
        }
    }
}
