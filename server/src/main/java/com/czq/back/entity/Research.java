package com.czq.back.entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Research")
public class Research {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "research_id")
    private Long researchId;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private Teacher teacher;

    @Column( name ="research_topic")
    private String researchTopic;

    @Column( name = "paper_title")
    private String paperTitle;

    @Column(name = "paper_journal")
    private String paperJournal;

    @Column(name = "paper_date")
    private String paperDate;

    @Column(name = "paper_volume")
    private String paperVolume;

    @Column(name = "paper_issue")
    private String paperIssue;

    @Column(name = "paper_pages")
    private String paperPages;

    @Column(name = "award_name")
    private String awardName;

    @Column(name = "award_date")
    private String awardDate;

    public Long getResearchId() {
        return researchId;
    }

    public void setResearchId(Long researchId) {
        this.researchId = researchId;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        this.researchTopic = researchTopic;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getPaperJournal() {
        return paperJournal;
    }

    public void setPaperJournal(String paperJournal) {
        this.paperJournal = paperJournal;
    }

    public String getPaperDate() {
        return paperDate;
    }

    public void setPaperDate(String paperDate) {
        this.paperDate = paperDate;
    }

    public String getPaperVolume() {
        return paperVolume;
    }

    public void setPaperVolume(String paperVolume) {
        this.paperVolume = paperVolume;
    }

    public String getPaperIssue() {
        return paperIssue;
    }

    public void setPaperIssue(String paperIssue) {
        this.paperIssue = paperIssue;
    }

    public String getPaperPages() {
        return paperPages;
    }

    public void setPaperPages(String paperPages) {
        this.paperPages = paperPages;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardDate() {
        return awardDate;
    }

    public void setAwardDate(String awardDate) {
        this.awardDate = awardDate;
    }
}
