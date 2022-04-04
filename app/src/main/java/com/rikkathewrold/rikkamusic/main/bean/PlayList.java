package com.rikkathewrold.rikkamusic.main.bean;


/**
 * 歌单信息
 */
public class PlayList {


    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** $column.columnComment */
    private String title;

    /** $column.columnComment */
    private String pic;

    /** $column.columnComment */
    private String introduction;

    /** $column.columnComment */
    private String style;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setPic(String pic)
    {
        this.pic = pic;
    }

    public String getPic()
    {
        return pic;
    }
    public void setIntroduction(String introduction)
    {
        this.introduction = introduction;
    }

    public String getIntroduction()
    {
        return introduction;
    }
    public void setStyle(String style)
    {
        this.style = style;
    }

    public String getStyle()
    {
        return style;
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", pic='" + pic + '\'' +
                ", introduction='" + introduction + '\'' +
                ", style='" + style + '\'' +
                '}';
    }
}
