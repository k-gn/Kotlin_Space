package kr.co.toppings.api.application.user.service

import kr.co.toppings.api.domain.user.persistence.UserRepository
import org.springframework.stereotype.Service

@Service
class UserUpdateService(
    private val userRepository: UserRepository
) {

}