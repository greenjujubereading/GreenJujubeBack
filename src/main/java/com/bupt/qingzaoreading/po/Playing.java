package com.bupt.qingzaoreading.po;

import javax.persistence.*;

public class Playing {
    /**
     * id；=1234
     */
    @Id
    @Column(name = "playing_id")
    private Long playingId;

    @Column(name = "video_id")
    private Long videoId;

    @Column(name = "picture_url")
    private String pictureUrl;

    /**
     * 获取id；=1234
     *
     * @return playing_id - id；=1234
     */
    public Long getPlayingId() {
        return playingId;
    }

    /**
     * 设置id；=1234
     *
     * @param playingId id；=1234
     */
    public void setPlayingId(Long playingId) {
        this.playingId = playingId;
    }

    /**
     * @return video_id
     */
    public Long getVideoId() {
        return videoId;
    }

    /**
     * @param videoId
     */
    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    /**
     * @return picture_url
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * @param pictureUrl
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}