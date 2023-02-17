package kr.co.toppings.api.presentation.user

import kr.co.toppings.api.application.user.facade.UserServiceFacade
import kr.co.toppings.api.application.user.service.UserCreateService
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userServiceFacade: UserServiceFacade
) {
}