package com.example.survey.controllers;

import com.example.survey.entity.Survey;
import com.example.survey.service.SurveyService;
import com.example.survey.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@Api(value = "Survey Controller")
@RequestMapping(ApiPaths.SurveyCtrl.CTRL)
@RestController
public class SurveyCtrl {
	private final SurveyService surveyService;

	public SurveyCtrl(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	@PostMapping(path = "/save-survey")
	@ApiOperation(value = "Save Survey", response = Survey.class)
	public Survey saveTopic(@RequestBody Survey survey) {
		return surveyService.saveSurvey(survey);
	}

	/*
	@GetMapping("/get-survey-list")
	@ApiOperation(value = "Get Survey List", response = Survey.class)
	public List<Survey> getTopicList() {

		return surveyService.getSurveyList();
	}*/
}
