package com.lys.runningpro_lys.dto;

import com.lys.runningpro_lys.entity.fieldenum.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class PageRequestDTO {

    @Builder.Default
    private int page = 1;
    @Builder.Default
    private int size = 6;

    private String link;
    private String type;
    private String keyword;

    private Integer distance;
    private Difficulty difficulty;

    // 정렬 키 추가: "popular" | "latest"
//    private String sort = "latest";

    public String[] getTypes(){
        if(type==null || type.isEmpty()){
            return null;
        }
        return type.split("");
    }

    // 추가! 정렬 키("latest" | "popular")
    private String sort = "latest";

//    public Pageable getPageable(String...props){
//        return PageRequest.of(page - 1, size, Sort.by(props).descending());
//    }

    // 추가! 정렬 없는 페이저 (QueryDSL orderBy만 쓰기 위함)
    public Pageable getPageableNoSort() {
        return PageRequest.of(this.page - 1, this.size); // Sort.unsorted()
    }

    public String getLink() {
        if(link==null){
            StringBuilder builder = new StringBuilder();
            builder.append("page="+this.page);
            builder.append("&size="+this.size);
            if(type!=null && type.length()>0){
                builder.append("&type="+type);
            }
            if(keyword!=null && keyword.length()>0){
                builder.append("&keyword="+keyword);
            }
            if(distance!=null && distance>0){
                builder.append("&distance="+distance);
            }
            if(difficulty!=null){
                builder.append("&difficulty="+difficulty);
            }
            if(sort!=null){
                builder.append("&sort="+sort);
            }
            link=builder.toString();
        }
        return link;
    }
}
