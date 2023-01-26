package store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import me.ilker.yet_another_kmp.models.Diet
import store.HomeStore.Intent
import store.HomeStore.State

internal class HomeStoreProvider(
    private val storeFactory: StoreFactory
) {
    fun provide(): HomeStore =
        object : HomeStore, Store<Intent, State, Nothing> by storeFactory.create(
            name = name,
            initialState = State(),
            bootstrapper = SimpleBootstrapper(Unit),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}

    private sealed class Message {
        data class ItemsLoaded(val items: List<Diet>) : Message()
        data class ItemDoneChanged(val id: Long, val isDone: Boolean) : Message()
        data class ItemDeleted(val id: Long) : Message()
        data class TextChanged(val text: String) : Message()
    }

    private class ExecutorImpl : CoroutineExecutor<Intent, Unit, State, Message, Nothing>() {
        override fun executeIntent(intent: Intent, getState: () -> State) =
            when (intent) {
                Intent.AddItem -> dispatch(Message.TextChanged(""))
                is Intent.DeleteItem -> dispatch(Message.ItemDeleted(intent.id))
                is Intent.SetItemDone -> dispatch(Message.ItemDoneChanged(id = intent.id, isDone = intent.isDone))
                is Intent.SetText -> dispatch(Message.TextChanged(""))
            }
    }

    private object ReducerImpl : Reducer<State, Message> {
        override fun State.reduce(message: Message): State =
            when (message) {
                is Message.ItemDeleted -> TODO()
                is Message.ItemDoneChanged -> TODO()
                is Message.ItemsLoaded -> copy(items = items)
                is Message.TextChanged -> TODO()
            }
    }

    companion object {
        private const val name = "HomeStore"
    }
}
