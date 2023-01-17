package kristileka.cleanarch.domain.model


data class Book(
    var id: Long? = 0L,
    var name: String?,
    var author: String?,
    var quantity: Int? = null,
    var categories: List<String> = emptyList(),
)
