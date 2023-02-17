package kr.co.toppings.api.domain.user.persistence

import kr.co.toppings.api.domain.user.UserHabit
import org.springframework.data.jpa.repository.JpaRepository

interface UserHabitRepository : JpaRepository<UserHabit, Long> {
}