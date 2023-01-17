package kristileka.cleanarch.infrastructure.config

import java.util.*
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class StringListConverter : AttributeConverter<List<String?>?, String?> {
    override fun convertToDatabaseColumn(stringList: List<String?>?): String {
        return if (stringList != null) java.lang.String.join(SPLIT_CHAR, stringList) else ""
    }

    override fun convertToEntityAttribute(string: String?): List<String> {
        return string?.split(SPLIT_CHAR.toRegex())?.dropLastWhile { it.isEmpty() } ?: emptyList()
    }

    companion object {
        private const val SPLIT_CHAR = ";"
    }
}