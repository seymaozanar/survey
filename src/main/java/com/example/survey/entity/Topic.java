package com.example.survey.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String question;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<TopicAnswer> topicAnswers;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Survey> surveys;


}
