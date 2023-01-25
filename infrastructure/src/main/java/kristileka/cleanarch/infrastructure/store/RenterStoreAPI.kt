package kristileka.cleanarch.infrastructure.store

import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.domain.store.IRenterStoreAPI
import kristileka.cleanarch.infrastructure.repository.RenterRepository
import kristileka.cleanarch.infrastructure.mappers.RenterEntityMapper.toDomain
import kristileka.cleanarch.infrastructure.mappers.RenterEntityMapper.toEntity
import org.springframework.stereotype.Service

@Service
class RenterStoreAPI(
    val renterRepository: RenterRepository
) : IRenterStoreAPI {
    override fun findAll(): List<Renter> {
        return renterRepository.findAll().map { it.toDomain() }
    }

    override fun findRenterById(renterId: String): Renter? {
        return renterRepository.findById(renterId)?.toDomain()
    }

    override fun save(renter: Renter): Renter {
        return renterRepository.save(renter.toEntity()).toDomain()
    }

    override fun returnBook(bookId: Long, renterId: String): Int? {
        return renterRepository.returnBook(bookId, renterId)
    }
}