package com.example.survey.service.imp;


import com.example.survey.entity.Survey;
import com.example.survey.entity.TopicAnswer;
import com.example.survey.repository.SurveyRepository;
import com.example.survey.service.SurveyService;
import org.springframework.stereotype.Service;
@Service
public class SurveyServiceImp implements SurveyService {

    private final SurveyRepository surveyRepo;

    public SurveyServiceImp(SurveyRepository surveyRepo) {
        this.surveyRepo = surveyRepo;
    }

    @Override
    public Survey saveSurvey(Survey survey) {
        if (!survey.getTopic().getTopicAnswers().isEmpty()) {
            for (TopicAnswer t : survey.getTopic().getTopicAnswers()) {
                t.setTopic(survey.getTopic());
            }
        }
        return surveyRepo.save(survey);
    }

  /*@Override
    public List<Survey> getSurveyList() {
        return surveyRepo.findAll();
    }*/
}
