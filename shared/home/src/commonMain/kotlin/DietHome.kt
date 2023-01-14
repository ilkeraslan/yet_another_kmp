import com.arkivanov.decompose.value.Value
import me.ilker.yet_another_kmp.models.Diet

interface DietHome {
    val models: Value<Model>

    fun onItemClicked(id: Long)

    data class Model(
        val items: List<Diet>,
        val text: String
    )
}