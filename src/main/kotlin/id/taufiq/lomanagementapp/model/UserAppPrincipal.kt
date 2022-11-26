package id.taufiq.lomanagementapp.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class UserAppPrincipal(val user: User) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return user.roles.map { SimpleGrantedAuthority(it.name) }
    }

    override fun getPassword(): String {
        return user.password!!
    }

    override fun getUsername(): String {
        return user.username!!
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return user.isEnabled!!
    }

}
