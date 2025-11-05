package com.lys.runningpro_lys.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRouteReviews is a Querydsl query type for RouteReviews
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRouteReviews extends EntityPathBase<RouteReviews> {

    private static final long serialVersionUID = -1573167303L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRouteReviews routeReviews = new QRouteReviews("routeReviews");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> rating = createNumber("rating", Integer.class);

    public final StringPath reviewText = createString("reviewText");

    public final QRoutes routes;

    public final QUsers users;

    public QRouteReviews(String variable) {
        this(RouteReviews.class, forVariable(variable), INITS);
    }

    public QRouteReviews(Path<? extends RouteReviews> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRouteReviews(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRouteReviews(PathMetadata metadata, PathInits inits) {
        this(RouteReviews.class, metadata, inits);
    }

    public QRouteReviews(Class<? extends RouteReviews> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.routes = inits.isInitialized("routes") ? new QRoutes(forProperty("routes"), inits.get("routes")) : null;
        this.users = inits.isInitialized("users") ? new QUsers(forProperty("users")) : null;
    }

}

