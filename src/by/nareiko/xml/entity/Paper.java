package by.nareiko.xml.entity;

import java.util.Date;

public abstract class Paper {
    private long id;
    private String title;
    private String periodical;
    private boolean isColour;
    private int volume;
    private boolean subscription;
    private Date publishingDate;

    public Paper(long id, String title, String periodical, boolean isColour, int volume, boolean subscription, Date publishingDate) {
        this.id = id;
        this.title = title;
        this.periodical = periodical;
        this.isColour = isColour;
        this.volume = volume;
        this.subscription = subscription;
        this.publishingDate = publishingDate;
    }
}
