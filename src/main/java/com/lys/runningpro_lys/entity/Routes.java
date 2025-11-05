package com.lys.runningpro_lys.entity;

import com.lys.runningpro_lys.entity.convert.JsonConverter;
import com.lys.runningpro_lys.entity.fieldenum.Difficulty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users; // foreignKey -> Users의 id

    @Column(nullable = false)
    private String title;

    private String description;

    @Convert(converter = JsonConverter.class)
    @Column(name = "route_data", columnDefinition = "json")
    private Object routeData; // JSON 타입

    private Double distance;

    @Enumerated(EnumType.STRING)
    @ColumnDefault(value = "'MEDIUM'")
    private Difficulty difficulty; // Enum(easy, medium, hard)

    @Column(name = "duration_hr")
    @ColumnDefault(value = "0")
    private Integer durationHr;

    @Column(name = "duration_min")
    @ColumnDefault(value = "0")
    private Integer durationMin;

    @Column(name = "duration_s")
    @ColumnDefault(value = "0")
    private Integer durationS;

    @Column(nullable = false, name = "heart_rate_max")
    private Integer heartRateMax;

    @Column(nullable = false, name = "heart_rate_avg")
    private Integer heartRateAvg;

    private String image;

    @Column(name = "average_rating")
    @ColumnDefault(value="0")
    private Double averageRating;

    @ColumnDefault(value = "0")
    private int views;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="created_at")
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="updated_at")
    private LocalDateTime updatedDate;

    //조회수 올리기
    public void updateViews(){ this.views = views+1; }
}
