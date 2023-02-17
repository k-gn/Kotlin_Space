package kr.co.toppings.api.domain.user

import kr.co.toppings.api.domain.user.constants.Auth
import javax.persistence.*

@Entity
@Table(name = "t_user")
class User constructor(

    @Column(name = "user_username", columnDefinition = "varchar(100)", unique = true)
    val username: String,

    @Column(name = "user_password", columnDefinition = "varchar(200)")
    val password: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", columnDefinition = "varchar(20)")
    val role: Auth = Auth.TEMP,

    @Column(name = "user_email", columnDefinition = "varchar(255)")
    val email: String,

    @Column(name = "user_country", columnDefinition = "varchar(200)")
    val country: String,

    @Column(name = "user_name", columnDefinition = "varchar(100)")
    val name: String,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val habits: MutableList<UserHabit> = mutableListOf(),

    @Column(name = "user_profile", columnDefinition = "text")
    val profile: String,

    @Column(name = "user_profile_path", columnDefinition = "varchar(200)")
    val profilePath: String,

    @Column(name = "deleted", columnDefinition = "varchar(1) default false")
    var deleted: Boolean = false,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Long? = null,
) {

    fun addHabit(title: String, content: String) {
        this.habits.add(UserHabit(title, content, this))
    }
}