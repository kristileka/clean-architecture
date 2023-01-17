package kristileka.cleanarch.presentation.domain.dto


data class TodoDto(
    var id: String? = null,
    var name: String,
    var status: String,
    var createdAt: String? = null,
    var description: String,
    var targetDate: String?
)
