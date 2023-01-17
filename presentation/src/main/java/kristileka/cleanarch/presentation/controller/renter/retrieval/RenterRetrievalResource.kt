package kristileka.cleanarch.presentation.controller.renter.retrieval

import kristileka.cleanarch.presentation.dto.renter.RenterREST
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/api/v1/renters")
interface RenterRetrievalResource {
    @GetMapping
    fun getAllRenters(): List<RenterREST>

    @GetMapping("/{id}")
    fun getRenterById(
        @PathVariable("id") renterId: String
    ): RenterREST

}