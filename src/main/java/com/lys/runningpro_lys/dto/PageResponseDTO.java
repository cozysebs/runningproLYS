package com.lys.runningpro_lys.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {
    private int page;
    private int size;
    private int total;

    private int start;
    private int end;
    private boolean next;
    private boolean prev;
    public List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;

        this.end = (int)(Math.ceil(this.page/(double)size))*size; // end==3
        this.start = this.end - (size-1);
        int last = (int)(Math.ceil(this.total/(double)size)); // last==2
        this.end = end>last?last:end;
        this.prev = this.start > 1;
        this.next = this.end<last;
    }
}
