package com.lys.runningpro_lys.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoutes is a Querydsl query type for Routes
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoutes extends EntityPathBase<Routes> {

    private static final long serialVersionUID = 1944689201L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoutes routes = new QRoutes("routes");

    public final StringPath address = createString("address");

    public final NumberPath<Double> averageRating = createNumber("averageRating", Double.class);

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath description = createString("description");

    public final EnumPath<com.lys.runningpro_lys.entity.fieldenum.Difficulty> difficulty = createEnum("difficulty", com.lys.runningpro_lys.entity.fieldenum.Difficulty.class);

    public final NumberPath<Integer> distance = createNumber("distance", Integer.class);

    public final NumberPath<Integer> durationHr = createNumber("durationHr", Integer.class);

    public final NumberPath<Integer> durationMin = createNumber("durationMin", Integer.class);

    public final NumberPath<Integer> durationS = createNumber("durationS", Integer.class);

    public final NumberPath<Integer> heartRateAvg = createNumber("heartRateAvg", Integer.class);

    public final NumberPath<Integer> heartRateMax = createNumber("heartRateMax", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final NumberPath<Double> lat = createNumber("lat", Double.class);

    public final NumberPath<Double> lng = createNumber("lng", Double.class);

    public final StringPath routePath = createString("routePath");

    public final StringPath title = createString("title");

    public final DateTimePath<java.time.LocalDateTime> updatedDate = createDateTime("updatedDate", java.time.LocalDateTime.class);

    public final QUsers users;

    public final NumberPath<Integer> views = createNumber("views", Integer.class);

    public QRoutes(String variable) {
        this(Routes.class, forVariable(variable), INITS);
    }

    public QRoutes(Path<? extends Routes> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoutes(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoutes(PathMetadata metadata, PathInits inits) {
        this(Routes.class, metadata, inits);
    }

    public QRoutes(Class<? extends Routes> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.users = inits.isInitialized("users") ? new QUsers(forProperty("users")) : null;
    }

}

