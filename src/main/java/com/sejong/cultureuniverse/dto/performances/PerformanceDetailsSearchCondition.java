package com.sejong.cultureuniverse.dto.performances;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PerformanceDetailsSearchCondition {
    
    private String title;
    private String[] genreList;
    private String[] placeList;
    private String dateRangeStart; //endDate가 dateRangeStart 와 같거나 뒤에 존재해야함
    private String dateRangeEnd; //startDate가 dateRangeEnd 와 같거나 앞에 존재해야함
}
