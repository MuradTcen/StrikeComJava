package ru.smartel.strike.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Embeddable
public class Post {

    @Column(name = "title_ru")
    private String titleRu;

    @Column(name = "title_en")
    private String titleEn;

    @Column(name = "title_es")
    private String titleEs;

    @Column(name = "title_de")
    private String titleDe;

    @Column(name = "content_ru", columnDefinition = "TEXT")
    private String contentRu;

    @Column(name = "content_en", columnDefinition = "TEXT")
    private String contentEn;

    @Column(name = "content_es", columnDefinition = "TEXT")
    private String contentEs;

    @Column(name = "content_de", columnDefinition = "TEXT")
    private String contentDe;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "views", nullable = false)
    private Integer views = 0;

    @Column(name = "published", nullable = false)
    private boolean published = false;

    @Column(name = "source_link", length = 500)
    private String sourceLink;

    @Column(name = "sent_to_ok")
    private boolean sentToOk = false;

    @Column(name = "sent_to_vk")
    private boolean sentToVk = false;

    @Column(name = "sent_to_telegram")
    private boolean sentToTelegram = false;

    @Column(name = "sent_to_twitter")
    private boolean sentToTwitter = false;

    @Column(name = "sent_to_instagram")
    private boolean sentToInstagram = false;

    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitleRu() {
        return titleRu;
    }

    public void setTitleRu(String titleRu) {
        this.titleRu = titleRu;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleEs() {
        return titleEs;
    }

    public void setTitleEs(String titleEs) {
        this.titleEs = titleEs;
    }

    public String getTitleDe() {
        return titleDe;
    }

    public void setTitleDe(String titleDe) {
        this.titleDe = titleDe;
    }

    public String getContentRu() {
        return contentRu;
    }

    public void setContentRu(String contentRu) {
        this.contentRu = contentRu;
    }

    public String getContentEn() {
        return contentEn;
    }

    public void setContentEn(String contentEn) {
        this.contentEn = contentEn;
    }

    public String getContentEs() {
        return contentEs;
    }

    public void setContentEs(String contentEs) {
        this.contentEs = contentEs;
    }

    public String getContentDe() {
        return contentDe;
    }

    public void setContentDe(String contentDe) {
        this.contentDe = contentDe;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public String getSourceLink() {
        return sourceLink;
    }

    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
    }

    public boolean isSentToOk() {
        return sentToOk;
    }

    public void setSentToOk(boolean sentToOk) {
        this.sentToOk = sentToOk;
    }

    public boolean isSentToVk() {
        return sentToVk;
    }

    public void setSentToVk(boolean sentToVk) {
        this.sentToVk = sentToVk;
    }

    public boolean isSentToTelegram() {
        return sentToTelegram;
    }

    public void setSentToTelegram(boolean sentToTelegram) {
        this.sentToTelegram = sentToTelegram;
    }

    public boolean isSentToTwitter() {
        return sentToTwitter;
    }

    public void setSentToTwitter(boolean sentToTwitter) {
        this.sentToTwitter = sentToTwitter;
    }

    public boolean isSentToInstagram() {
        return sentToInstagram;
    }

    public void setSentToInstagram(boolean sentToInstagram) {
        this.sentToInstagram = sentToInstagram;
    }
}
