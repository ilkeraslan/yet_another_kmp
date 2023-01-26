import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.mvikotlin.core.store.StoreFactory
import me.ilker.yet_another_kmp.getStore
import store.HomeStoreProvider
import DietHome.Model
import me.ilker.yet_another_kmp.asValue

class DietHomeComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
) : DietHome, ComponentContext by componentContext {
    private val store = instanceKeeper.getStore {
        HomeStoreProvider(storeFactory = storeFactory)
            .provide()
    }

    override val models: Value<Model> = store.asValue()

    override fun onItemClicked(id: Long) {
        TODO("Not yet implemented")
    }
}