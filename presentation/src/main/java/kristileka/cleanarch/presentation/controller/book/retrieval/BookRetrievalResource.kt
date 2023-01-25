package kristileka.cleanarch.presentation.controller.book.retrieval

import kristileka.cleanarch.presentation.dto.book.BookAvailabilityREST
import kristileka.cleanarch.presentation.dto.book.BookREST
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("/api/v1/books")
interface BookRetrievalResource {
    @GetMapping
    fun getAllBooks(): List<BookREST>

    @GetMapping("/{id}")
    fun getBookById(
        @PathVariable("id") bookId: String,
    ): BookREST

    @GetMapping("/query")
    fun queryBooks(
        @RequestParam("author") author: String? = "",
        @RequestParam("category") category: String? = "",
        @RequestParam("name") name: String? = "",
    ): List<BookREST>

    @GetMapping("/availability/{id}")
    fun getBookAvailability(
        @PathVariable("id") bookId: String,
    ): BookAvailabilityREST
}
