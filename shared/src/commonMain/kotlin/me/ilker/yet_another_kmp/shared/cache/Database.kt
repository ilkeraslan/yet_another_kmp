package me.ilker.yet_another_kmp.shared.cache

import meilkeryetanotherkmpsharedcache.DietTable

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = DietDatabase(databaseDriverFactory.createDriver())
    private val dietQueries = database.dietTableQueries

    internal fun clearDatabase() {
        dietQueries.transaction {
            dietQueries.deleteAll()
        }
    }

    internal fun getDiets(): List<DietTable> = dietQueries
        .getAll()
        .executeAsList()

    internal fun createDiets(diets: List<DietTable>) {
        dietQueries.transaction {
            diets.forEach { diet ->
                insertDiet(diet)
            }
        }
    }

    private fun insertDiet(diet: DietTable) {
        dietQueries.insertDiet(name = diet.name)
    }
}
