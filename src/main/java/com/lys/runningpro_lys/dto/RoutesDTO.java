package com.lys.runningpro_lys.dto;

import com.lys.runningpro_lys.entity.BaseEntity;
import com.lys.runningpro_lys.entity.Users;
import com.lys.runningpro_lys.entity.fieldenum.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoutesDTO {

    private Long id;

    private String email;

    private String title;

    private String description;

    //Kakao Map 데이터로 입력됨.
    private Integer distance;       //거리
    private String address;         //주소
    private Double lat;             //위도
    private Double lng;             //경도
    private String routePath;       //코스 경로

    private Difficulty difficulty;

    private Integer durationHr;

    private Integer durationMin;

    private Integer durationS;

    private Integer heartRateMax;

    private Integer heartRateAvg;

    private int views;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
