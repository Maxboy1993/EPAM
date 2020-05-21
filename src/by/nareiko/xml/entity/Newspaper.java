package by.nareiko.xml.entity;

import java.util.Date;
import java.util.Objects;

public class Newspaper extends Paper {
    private long id;
    private String title;
    private String periodical;
    private boolean isColour;
    private int volume;
    private boolean subscription;
    private Date publishingDate;

    public Newspaper(long id, String title, String periodical, boolean isColour, int volume, boolean subscription, Date publishingDate) {
        super(id, title, periodical, isColour, volume, subscription, publishingDate);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPeriodical() {
        return periodical;
    }

    public void setPeriodical(String periodical) {
        this.periodical = periodical;
    }

    public boolean isColour() {
        return isColour;
    }

    public void setColour(boolean colour) {
        isColour = colour;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isSubscription() {
        return subscription;
    }

    public void setSubscription(boolean subscription) {
        this.subscription = subscription;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Newspaper newspaper = (Newspaper) o;
        return id == newspaper.id &&
                isColour == newspaper.isColour &&
                volume == newspaper.volume &&
                subscription == newspaper.subscription &&
                Objects.equals(title, newspaper.title) &&
                Objects.equals(periodical, newspaper.periodical) &&
                Objects.equals(publishingDate, newspaper.publishingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, periodical, isColour, volume, subscription, publishingDate);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder.append(getClass().getName())
                .append(", id=" + id)
                .append(", title='" + title)
                .append(", periodical='" + periodical)
                .append(", isColour=" + isColour)
                .append(", volume=" + volume)
                .append(", subscription=" + subscription)
                .append(", publishingDate=" + publishingDate)
                .toString();
    }
}
