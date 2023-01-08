package me.ilker.yet_another_kmp.shared.cache

import meilkeryetanotherkmpsharedcache.Diet

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = DietDatabase(databaseDriverFactory.createDriver())
    private val dietQueries = database.dietQueries

    internal fun clearDatabase() {
        dietQueries.transaction {
            dietQueries.deleteAll()
        }
    }

    internal fun getDiets(): List<Diet> = dietQueries
        .getAll()
        .executeAsList()

    internal fun createDiets(diets: List<Diet>) {
        dietQueries.transaction {
            diets.forEach { diet ->
                insertDiet(diet)
            }
        }
    }

    private fun insertDiet(diet: Diet) {
        dietQueries.insertDiet(name = diet.name)
    }
}
