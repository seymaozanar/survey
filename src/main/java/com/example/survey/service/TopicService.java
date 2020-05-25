package com.example.survey.service;


import com.example.survey.entity.dto.NPS;
import com.example.survey.entity.Topic;
import com.example.survey.entity.dto.TopicList;

import java.util.List;

public interface TopicService {
	Topic saveTopic(Topic topic);

	//List<Topic> getTopicList();

	List<TopicList> getTopicById(Long topicId);

	List<NPS> getTopicNPS();

}
