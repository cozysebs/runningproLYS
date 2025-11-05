package com.lys.runningpro_lys.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUsers is a Querydsl query type for Users
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsers extends EntityPathBase<Users> {

    private static final long serialVersionUID = 65606209L;

    public static final QUsers users = new QUsers("users");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final DateTimePath<java.time.LocalDateTime> joinDate = createDateTime("joinDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> lastLogin = createDateTime("lastLogin", java.time.LocalDateTime.class);

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath profileImage = createString("profileImage");

    public final EnumPath<com.lys.runningpro_lys.entity.fieldenum.Provider> provider = createEnum("provider", com.lys.runningpro_lys.entity.fieldenum.Provider.class);

    public final StringPath providerId = createString("providerId");

    public final EnumPath<com.lys.runningpro_lys.entity.fieldenum.Role> role = createEnum("role", com.lys.runningpro_lys.entity.fieldenum.Role.class);

    public final EnumPath<com.lys.runningpro_lys.entity.fieldenum.SubscriptionStatus> subscriptionStatus = createEnum("subscriptionStatus", com.lys.runningpro_lys.entity.fieldenum.SubscriptionStatus.class);

    public final NumberPath<Integer> totalBookmarks = createNumber("totalBookmarks", Integer.class);

    public final NumberPath<Integer> totalComments = createNumber("totalComments", Integer.class);

    public final NumberPath<Integer> totalPosts = createNumber("totalPosts", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath username = createString("username");

    public QUsers(String variable) {
        super(Users.class, forVariable(variable));
    }

    public QUsers(Path<? extends Users> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsers(PathMetadata metadata) {
        super(Users.class, metadata);
    }

}

