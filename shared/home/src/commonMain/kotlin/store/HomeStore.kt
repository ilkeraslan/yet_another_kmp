package store

import com.arkivanov.mvikotlin.core.store.Store
import me.ilker.yet_another_kmp.models.Diet

internal interface HomeStore : Store<HomeStore.Intent, HomeStore.State, Nothing> {

    sealed class Intent {
        data class SetItemDone(val id: Long, val isDone: Boolean) : Intent()
        data class DeleteItem(val id: Long) : Intent()
        data class SetText(val text: String) : Intent()
        object AddItem : Intent()
    }

    data class State(
        val items: List<Diet> = emptyList(),
        val text: String = ""
    )
}