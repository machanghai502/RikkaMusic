package com.rikkathewrold.rikkamusic.main.bean;

public class Song {

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    private String singerId;

    /** $column.columnComment */
    private String name;

    /** $column.columnComment */
    private String introduction;

    /** $column.columnComment */
    private String pic;

    /** $column.columnComment */
    private String lyric;

    /** $column.columnComment */
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSingerId(String singerId)
    {
        this.singerId = singerId;
    }

    public String getSingerId()
    {
        return singerId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setIntroduction(String introduction)
    {
        this.introduction = introduction;
    }

    public String getIntroduction()
    {
        return introduction;
    }
    public void setPic(String pic)
    {
        this.pic = pic;
    }

    public String getPic()
    {
        return pic;
    }
    public void setLyric(String lyric)
    {
        this.lyric = lyric;
    }

    public String getLyric()
    {
        return lyric;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", singerId='" + singerId + '\'' +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", pic='" + pic + '\'' +
                ", lyric='" + lyric + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
