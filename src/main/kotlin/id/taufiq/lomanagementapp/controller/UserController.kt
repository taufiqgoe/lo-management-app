package id.taufiq.lomanagementapp.controller

import id.taufiq.lomanagementapp.dto.adm.UserDto
import id.taufiq.lomanagementapp.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/user")
class UserController(
    private val service: UserService
) {

    @PostMapping
    fun createUser(@RequestBody userDto: UserDto): UserDto {
        return service.createUser(userDto)
    }

    @PutMapping
    fun updateUser(@RequestBody userDto: UserDto): UserDto {
        return service.updateUser(userDto)
    }

    @GetMapping("{username}")
    fun findUser(@PathVariable username: String): UserDto {
        return service.findUser(username)
    }

}
