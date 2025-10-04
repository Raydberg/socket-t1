package com.client.client.entity;


import java.util.Objects;

public class PackageEntity {
    private String code;
    private String recipientName;
    private Integer state;

    public PackageEntity(String code, String recipientName, Integer state) {
        this.code = code;
        this.recipientName = recipientName;
        this.state = state;
    }

    public PackageEntity() {
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PackageEntity that))
            return false;
        return Objects.equals(code, that.code) && Objects.equals(recipientName, that.recipientName) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, recipientName, state);
    }

    @Override
    public String toString() {
        return "PackageEntity{" +
                "code='" + code + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", state=" + state +
                '}';
    }
}
