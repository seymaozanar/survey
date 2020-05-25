package com.example.survey.entity.dto;

import lombok.Data;

@Data
public class NPS {

	private Long topicId;

	private Integer npsScore;

	private String name;
}
