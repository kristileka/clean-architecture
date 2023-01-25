package kristileka.cleanarch.presentation.controller.book.manage

import kristileka.cleanarch.presentation.dto.book.BookExportREST
import kristileka.cleanarch.presentation.dto.book.BookREST
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/api/v1/manage")
interface BookManageResource {

    @PostMapping("/book")
    fun importBook(
        @RequestBody book: BookREST,
    ): BookREST

    @DeleteMapping("/book/{id}")
    fun exportBook(
        @PathVariable("id") bookId: String,
    ): BookExportREST
}
