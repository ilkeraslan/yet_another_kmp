import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface Root {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        data class Home(val component: DietHome) : Child()
    }
}