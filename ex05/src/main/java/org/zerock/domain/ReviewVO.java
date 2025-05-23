package org.zerock.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewVO {
	   private Long review_id;
	   private String review_title;
	   private String restaurant_name;
	   private String review_content;
	   private String writer_name;
	   private Date register_date;
	   private int rating;
	   private int count;
	   private String region;
	   private String fileName;
	}
