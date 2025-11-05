package com.lys.runningpro_lys.entity;

import com.lys.runningpro_lys.entity.fieldenum.Provider;
import com.lys.runningpro_lys.entity.fieldenum.Role;
import com.lys.runningpro_lys.entity.fieldenum.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = true, length = 255)
    private String password;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100, unique = true) // ← 추가
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Provider provider; // local, google, kakao

    @Column(name = "provider_id", length = 255)
    private String providerId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role; // GUEST / USER / ADMIN

    //임시 데이터 저장을 위한 수정
//    @Column(nullable = false, columnDefinition = "TINYINT(1)")
//    private boolean enabled;

    @Column(name = "profile_image", length = 512)
    private String profileImage;

    @Enumerated(EnumType.STRING)
    @Column(name = "subscription_status", nullable = false, length = 20)
    private SubscriptionStatus subscriptionStatus; // FREE, PREMIUM

    @Column(name = "total_posts", nullable = false)
    private Integer totalPosts = 0;

    @Column(name = "total_comments", nullable = false) // 추가
    private Integer totalComments = 0;

    @Column(name = "total_bookmarks", nullable = false) // 추가
    private Integer totalBookmarks = 0;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "join_date")
    private LocalDateTime joinDate;

//    @OneToMany(mappedBy = "createdByAdmin", fetch = FetchType.LAZY)
//    @ToString.Exclude
//    private List<Challenge> createdChallenges = new ArrayList<>();

    @Builder
    public Users(String email, String password, String username, String nickname, Provider provider, Role role) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.nickname = nickname;
        this.provider = provider;
        this.role = role;
//        this.enabled = true;
//        this.subscriptionStatus = SubscriptionStatus.ACTIVE; // 활성화로 초기화. free가 기본값이되어야 하면 type에서 추가해서 변경
        this.joinDate = LocalDateTime.now();
    }
}


