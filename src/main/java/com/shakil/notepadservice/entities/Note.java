package com.shakil.notepadservice.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Note implements Serializable {
    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false , updatable = false, unique = true)
    private String id;

    @Column
    private String title;

    @Column
    private String body;

}
