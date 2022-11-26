package id.taufiq.lomanagementapp.service

import id.taufiq.lomanagementapp.model.adm.Role
import id.taufiq.lomanagementapp.model.adm.User
import id.taufiq.lomanagementapp.model.adm.UserAppPrincipal
import id.taufiq.lomanagementapp.repository.RoleRepository
import id.taufiq.lomanagementapp.repository.UserRepository
import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
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

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByUsername(username!!).orElseThrow { UsernameNotFoundException("User not found") }

        return UserAppPrincipal(user)
    }

    @PostConstruct
    fun init() {
        val superuserRole = roleRepository.save(Role(null, "SU"))
        val superuserUser = userRepository.save(
            User(
                id = null,
                username = "SU",
                password = passwordEncoder.encode("SU"),
                email = "su@app.com",
                isEnabled = true,
                roles = listOf(superuserRole).toMutableList()
            )
        )

        log.info(superuserUser.toString())
    }

}
