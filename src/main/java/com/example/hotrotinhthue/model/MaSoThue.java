package com.example.hotrotinhthue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "masothue")
public class MaSoThue {
    @Id
    private String id;

    @Column(length = 255, nullable = false)
    private String hoTen;

    @Column(length = 255, nullable = false)
    private String cccd;
}
