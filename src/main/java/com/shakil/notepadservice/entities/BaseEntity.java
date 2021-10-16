package com.shakil.notepadservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity{

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false , updatable = false, unique = true)
    private String id;

    @Column
    private Date createdAt;

    @Column
    private Date updatedAt;

    public BaseEntity() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

}
