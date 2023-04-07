package com.czq.back.entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "research")
public class Research {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "topic")
    private String topic;

    @Column(name = "published_papers")
    private int publishedPapers;

    @Column(name = "awards")
    private String awards;

    // constructors, getters, and setters

    public Research() {
    }

    public Research(String topic, int publishedPapers, String awards) {
        this.topic = topic;
        this.publishedPapers = publishedPapers;
        this.awards = awards;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getPublishedPapers() {
        return publishedPapers;
    }

    public void setPublishedPapers(int publishedPapers) {
        this.publishedPapers = publishedPapers;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

}
