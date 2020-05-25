package com.example.survey.service.imp;


import com.example.survey.entity.dto.NPS;
import com.example.survey.entity.Topic;
import com.example.survey.entity.TopicAnswer;
import com.example.survey.entity.dto.TopicList;
import com.example.survey.repository.TopicRepository;
import com.example.survey.service.TopicService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

	private final TopicRepository topicRepo;

	public TopicServiceImpl(TopicRepository topicRepo) {
		this.topicRepo = topicRepo;
	}

	@Override
	public Topic saveTopic(Topic topic) {
		if (!topic.getTopicAnswers().isEmpty()) {
			for (TopicAnswer t : topic.getTopicAnswers()) {
				t.setTopic(topic);
			}
		}
		return topicRepo.save(topic);
	}

	/*@Override
	public List<Topic> getTopicList() {
		return topicRepo.findAll();
	}
*/
	@Override
	public List<TopicList> getTopicById(Long topicId) {
		Optional<Topic> optTopic = topicRepo.findById(topicId);
	    int size = optTopic.get().getTopicAnswers().size();

	  	List<TopicList> topicList=new ArrayList<>();
		if (optTopic.isPresent()) {
			for (int a=0;a<size;a++){
				TopicList list =new TopicList();
				list.setFeedback(optTopic.get().getTopicAnswers().get(a).getFeedback());
				list.setScore(optTopic.get().getTopicAnswers().get(a).getScore());
				list.setSubmitId(optTopic.get().getTopicAnswers().get(a).getId());
				topicList.add(list);
			}
		}
		return topicList;

	}

	@Override
	public List<NPS> getTopicNPS() {
		List<NPS> npsList = new ArrayList<>();
		List<Topic> tList = topicRepo.findAll();
		for (Topic t : tList) {
			NPS nps = new NPS();
			if (!t.getTopicAnswers().isEmpty()) {
				nps.setTopicId(t.getId());
				nps.setName(t.getName());
				Integer totalScore = calculateTotal(t.getTopicAnswers());
				Integer scoreDetractor = calculateTotalDetractors(t.getTopicAnswers());
				Integer scorePromoter = calculateTotalPromoters(t.getTopicAnswers());
				nps.setNpsScore((scorePromoter*100/totalScore) - (scoreDetractor*100/totalScore));
			}
			npsList.add(nps);
		}
		return npsList;
	}

	private Integer calculateTotal(List<TopicAnswer> taList) {
		Integer total = 0;
		for (TopicAnswer ta : taList) {
			total += ta.getScore();
		}
		return total;
	}

	private Integer calculateTotalDetractors(List<TopicAnswer> taList) {
		Integer total = 0;
		for (TopicAnswer ta : taList) {
			if (ta.getScore() < 7) {
				total += ta.getScore();
			}
		}
		return total;
	}

	private Integer calculateTotalPromoters(List<TopicAnswer> taList) {
		Integer total = 0;
		for (TopicAnswer ta : taList) {
			if (ta.getScore() > 8) {
				total += ta.getScore();
			}
		}
		return total;
	}
}
