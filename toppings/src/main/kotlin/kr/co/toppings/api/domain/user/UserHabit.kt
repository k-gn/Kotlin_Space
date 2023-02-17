package kr.co.toppings.api.domain.user

import javax.persistence.*

@Entity
class UserHabit constructor(

    @Column(name = "user_habit_title", columnDefinition = "varchar(100)")
    val title: String,

    @Column(name = "user_habit_content", columnDefinition = "varchar(100)")
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_habit_id")
    val id: Long? = null,
) {
}