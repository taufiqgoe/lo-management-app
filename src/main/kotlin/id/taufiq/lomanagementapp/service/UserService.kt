package id.taufiq.lomanagementapp.service

import id.taufiq.lomanagementapp.dto.adm.UserDto
import id.taufiq.lomanagementapp.model.adm.Role
import id.taufiq.lomanagementapp.model.adm.User
import id.taufiq.lomanagementapp.model.adm.UserAppPrincipal
import id.taufiq.lomanagementapp.repository.RoleRepository
import id.taufiq.lomanagementapp.repository.UserRepository
import jakarta.annotation.PostConstruct
import org.modelmapper.ModelMapper
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val mapper: ModelMapper,
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByUsername(username!!).orElseThrow { UsernameNotFoundException("User not found") }
        return UserAppPrincipal(user)
    }

    fun createUser(userDto: UserDto): UserDto {
        userDto.id = null
        userDto.password = passwordEncoder.encode(userDto.password)
        return userDtoMapAndSave(userDto)
    }

    fun updateUser(userDto: UserDto): UserDto {
        userDto.password = passwordEncoder.encode(userDto.password)
        return userDtoMapAndSave(userDto)
    }

    fun findUser(username: String): UserDto {
        val user = userRepository.findByUsername(username).orElseThrow { UsernameNotFoundException("User not found") }
        return mapper.map(user, UserDto::class.java)
    }

    fun userDtoMapAndSave(userDto: UserDto): UserDto {
        val user = mapper.map(userDto, User::class.java)
        return mapper.map(userRepository.save(user), UserDto::class.java)
    }

    @PostConstruct
    fun init() {
        if (roleRepository.count() < 1) {
            val superuserRole = roleRepository.save(Role(null, "SU"))
            userRepository.save(
                User(
                    id = null,
                    username = "SU",
                    password = passwordEncoder.encode("SU"),
                    email = "su@app.com",
                    isEnabled = true,
                    roles = listOf(superuserRole).toMutableList()
                )
            )
        }
    }

}
