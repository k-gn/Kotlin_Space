package kr.co.toppings.api.application.user.facade

import kr.co.toppings.api.application.user.service.UserCreateService
import kr.co.toppings.api.application.user.service.UserDeleteService
import kr.co.toppings.api.application.user.service.UserSelectService
import kr.co.toppings.api.application.user.service.UserUpdateService
import org.springframework.stereotype.Service

@Service
class UserServiceFacadeImpl(
    private val userCreateService: UserCreateService,
    private val userSelectService: UserSelectService,
    private val userUpdateService: UserUpdateService,
    private val userDeleteService: UserDeleteService
) : UserServiceFacade {




}