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

    @ColumnDefault(value = "'NonTitle'")
    private String title;

    private String description;

    //Kakao Map 데이터로 입력됨.
    private Integer distance;   //거리
    private String address;     //주소
    private Double lat;         //위도
    private Double lng;         //경도
    @Column(columnDefinition = "TEXT")
    private String routePath;   //코스 경로
    
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

    @Column(name = "heart_rate_max")
    private Integer heartRateMax;

    @Column(name = "heart_rate_avg")
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

    //게시물 update
    //수정필요한 사항: title, difficulty, hr, min, s, avg, max, description.
    public void change(String title, Difficulty difficulty,
                       Integer durationHr, Integer durationMin, Integer durationS,
                       Integer heartRateAvg, Integer heartRateMax, String description,
                       Integer distance, String address, Double lat, Double lng,
                       String routePath) {
        this.title = title;
        this.difficulty = difficulty;
        this.durationHr = durationHr;
        this.durationMin = durationMin;
        this.durationS = durationS;
        this.heartRateAvg = heartRateAvg;
        this.heartRateMax = heartRateMax;
        this.description = description;
        this.distance = distance;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.routePath = routePath;
    }

}
