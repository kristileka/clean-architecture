package kristileka.cleanarch.presentation.controller.book.manage

import kristileka.cleanarch.application.base.UseCaseInvoker
import kristileka.cleanarch.application.usecases.book.ExportBookUseCase
import kristileka.cleanarch.application.usecases.book.ImportBookUseCase
import kristileka.cleanarch.presentation.dto.book.BookExportREST
import kristileka.cleanarch.presentation.dto.book.BookREST
import kristileka.cleanarch.presentation.mappers.BookMapper.toDomain
import kristileka.cleanarch.presentation.mappers.BookMapper.toREST
import org.springframework.web.bind.annotation.RestController

@RestController
class BookManageController(
    val useCaseInvoker: UseCaseInvoker,
    val importBookUseCase: ImportBookUseCase,
    val exportBookUseCase: ExportBookUseCase,
) : BookManageResource {

    override fun importBook(book: BookREST): BookREST {
        return useCaseInvoker.execute(
            importBookUseCase,
            ImportBookUseCase.Input(book.toDomain()),
        ).book.toREST()
    }

    override fun exportBook(bookId: String): BookExportREST {
        return BookExportREST().apply {
            this.exported = useCaseInvoker.execute(
                exportBookUseCase,
                ExportBookUseCase.Input(bookId.toLong()),
            ).exported
        }
    }
}
