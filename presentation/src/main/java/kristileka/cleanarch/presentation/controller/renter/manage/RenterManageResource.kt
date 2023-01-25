package kristileka.cleanarch.presentation.controller.renter.manage

import kristileka.cleanarch.presentation.dto.renter.RenterREST
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/api/v1/renters")
interface RenterManageResource {
    @PostMapping("/rent/{bookId}")
    fun rentBook(
        @PathVariable("bookId") bookId: String,
        @RequestBody renterRest: RenterREST,
    ): RenterREST

    @PostMapping("/return/{bookId}")
    fun returnBook(
        @PathVariable("bookId") bookId: String,
        @RequestBody renterRest: RenterREST,
    ): RenterREST
}
