package com.example.hotrotinhthue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dailythue")
public class DaiLyThue {
    @Id
    private String id;

    @Column(length = 255, nullable = false)
    private String ten;
}
