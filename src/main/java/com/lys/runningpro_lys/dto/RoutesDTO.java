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

    //Kakao API 데이터로 입력됨.
    private Object routeData;

    //Kakao API 데이터로 입력됨.
    private Double distance;

    private Difficulty difficulty;

    private Integer durationHr;

    private Integer durationMin;

    private Integer durationS;

    private Integer heartRateMax;

    private Integer heartRateAvg;

    private Integer views;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
