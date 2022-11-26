package id.taufiq.lomanagementapp.service

import id.taufiq.lomanagementapp.model.Role
import id.taufiq.lomanagementapp.model.User
import id.taufiq.lomanagementapp.model.UserAppPrincipal
import id.taufiq.lomanagementapp.repository.RoleRepository
import id.taufiq.lomanagementapp.repository.UserRepository
import jakarta.annotation.PostConstruct
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByUsername(username!!).orElseThrow { UsernameNotFoundException("User not found") }

        return UserAppPrincipal(user)
    }

    @PostConstruct
    fun init() {
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
