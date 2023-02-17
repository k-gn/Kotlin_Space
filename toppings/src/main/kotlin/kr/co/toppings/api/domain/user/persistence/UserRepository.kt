package kr.co.toppings.api.domain.user.persistence

import kr.co.toppings.api.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}