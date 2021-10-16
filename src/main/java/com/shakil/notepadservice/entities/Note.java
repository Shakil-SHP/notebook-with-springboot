package com.shakil.notepadservice.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Note extends BaseEntity {

    @Column
    private String title;

    @Column
    private String body;

}
