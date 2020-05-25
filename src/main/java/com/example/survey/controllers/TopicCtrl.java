package com.example.survey.controllers;

import com.example.survey.entity.dto.NPS;
import com.example.survey.entity.Topic;
import com.example.survey.entity.dto.TopicList;
import com.example.survey.service.TopicService;
import com.example.survey.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value ="Topic Controller")
@RequestMapping(ApiPaths.TopicCtrl.CTRL)
@RestController
public class TopicCtrl {
	private final TopicService topicService;

	@Autowired
	public TopicCtrl(TopicService topicService) {
		this.topicService = topicService;
	}

	@PostMapping(path = "/save-topic")
	@ApiOperation(value = "Submit Topic", response = Topic.class)
	public Topic saveTopic(@RequestBody Topic topic) {
		return topicService.saveTopic(topic);
	}

	@GetMapping("/get-topic-by-id/{topicId}")
	@ApiOperation(value = "List Survey Answers", response = Topic.class)
	public List<TopicList> getTopicById(@PathVariable Long topicId) {
		return topicService.getTopicById(topicId);

	}
	@GetMapping("/get-topic-nps")
	@ApiOperation(value = "List Survey Topics", response = Topic.class)
	public List<NPS> getTopicNPS() {
		return topicService.getTopicNPS();
	}

/*	@GetMapping("/get-topic-list")
	@ApiOperation(value = "Get Topic List", response = Topic.class)
	public List<Topic> getTopicList() {
		return topicService.getTopicList();
	}*/


}
