package com.oscar.bean;

public class AssignCustomer {
    private Integer assignId;

    private String segmentId;

    private Integer channel_type;

    private String advertiserId;

    public Integer getAssignId() {
        return assignId;
    }

    public void setAssignId(Integer assignId) {
        this.assignId = assignId;
    }

    public String getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(String segmentId) {
        this.segmentId = segmentId == null ? null : segmentId.trim();
    }

    public Integer getChannel_type() {
        return channel_type;
    }

    public void setChannel_type(Integer channel_type) {
        this.channel_type = channel_type;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId == null ? null : advertiserId.trim();
    }
}