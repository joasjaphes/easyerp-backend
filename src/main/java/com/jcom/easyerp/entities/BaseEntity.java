package com.jcom.easyerp.entities;

import java.util.Date;

import jakarta.persistence.ManyToOne;

public class BaseEntity {
    @ManyToOne()
    public User createdBy;
    @ManyToOne()
    public User updatedBy;
    public Date createdAt;
    public Date updatedAt;

}
