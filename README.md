# survey

    In this project, customer satisfaction survey is displayed using with RESTful Web service (Java Springboot) and PostgreSQL.
It presents customer a survey on how likely they are recommend a topic to their friends or etc.
Application starts on 8085 port,controllers and details which exists in the project can be showed with swagger.(http://localhost:8085/swagger-ui.html#/)

First of all, topic determined by the company should be created in topic controller which endpoint is /topic/save-topic. 
In topic model there are id,name,question fields and surveys(mapped from Survey Entity) and topicAnswers(mapped from TopicAnswer Entity). While creating topic, topicAnswers' fields should be added as a null and fields from topic such as question, name etc. should be added.There is no need to save 'surveys' field because, survey will be added another controller.In the default, there exists Groove and Uber topics in the PostgreSql.

Submit Survey:
In the survey controller, ("survey/save-survey" endpoint) : Stores score and feedback answers of a customer topic.

List Survey Answers:
In the Topic Controller which contains "topic/get-topic-by-id/{topicId}" endpoint,the list of survey answers of a topic can be showed with this endpoint.(SubmitId,Score,Feedback).Listing the answers is based on the topic id.By the agency of topic id, user can shows the surveys answers which topic is choosed.Function returns the TopicList dto type which contains submitId,score,feedback.

List Survey Topics:
There is endpoint in Topic Controller which is "/topic/get-topic-nps". TopicId, Topic and Net Promoter Score can be listed. While calculating Net Promoter score, 2 ways can be used.
First one is calculations with the counts.Finding how many promoters, detractors and total number of survey in the topic and gets the percentage of the nps.
Second one is calculations about sum of scores with same fields and gets and percentage of net promoter score.In this application, second one is choosed.Application gets the total score of promoters,detractors and sum of all scores of the topic.(TopicId,Topic,NPS).


