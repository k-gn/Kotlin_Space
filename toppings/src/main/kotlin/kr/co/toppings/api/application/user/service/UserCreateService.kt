package kr.co.toppings.api.application.user.service

import kr.co.toppings.api.domain.user.persistence.UserRepository
import org.springframework.stereotype.Service

@Service
class UserCreateService(
    private val userRepository: UserRepository
) {

}