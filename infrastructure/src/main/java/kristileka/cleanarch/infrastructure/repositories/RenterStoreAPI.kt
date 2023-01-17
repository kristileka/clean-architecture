package kristileka.cleanarch.infrastructure.repositories

import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.domain.store.IRenterStoreAPI
import kristileka.cleanarch.infrastructure.datasource.RenterRepository
import kristileka.cleanarch.infrastructure.mappers.BookEntityMapper.toEntity
import kristileka.cleanarch.infrastructure.mappers.RenterEntityMapper.toDomain
import kristileka.cleanarch.infrastructure.mappers.RenterEntityMapper.toEntity
import kristileka.cleanarch.infrastructure.models.RentedBookEntity
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class RenterStoreAPI(
    val renterRepository: RenterRepository
) : IRenterStoreAPI {
    override fun getAllRenters(): List<Renter> {
        return renterRepository.findAll().map { it.toDomain() }
    }

    override fun getRenterById(renterId: String): Renter? {
        return renterRepository.findById(renterId)?.toDomain()
    }

    override fun save(renter: Renter): Renter {
        return renterRepository.save(renter.toEntity()).toDomain()
    }

    override fun returnBook(bookId: Long, renterId: String): Int? {
        return renterRepository.returnBook(bookId, renterId)
    }
}