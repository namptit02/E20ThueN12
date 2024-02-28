package com.example.hotrotinhthue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tokhaithue")
public class ToKhaiThue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String kyTinhThue;

    private int quyKeKhai;

    private int thangKeKhai;

    private int namKeKhai;

    private String loaiToKhai;

    private String hoTen;

    private String maSoThue;

    private String tinhThanh;

    private String quanHuyen;

    private String diaChi;

    private String email;

    private String sdt;

    private String fax;

    @Column(nullable = false)
    private boolean daiLyThue;

    private String tenDaiLyThue;

    private String maSoThueDLT;

    private String tinhThanhDLT;

    private String quanHuyenDLT;

    private String diaChiDLT;

    private String emailDLT;

    private String sdtDLT;

    private String faxDLT;

    private String soHopDong;

    private String ngayHopDong;

    private boolean cuTru;

    @CreationTimestamp
	@Column(updatable = false)
    private Date ngayNop;

    private long chiTieu20;

    private long chiTieu21;

    private long chiTieu22;

    private long chiTieu23;

    private long chiTieu24;

    private long chiTieu25;

    private long chiTieu26;

    private long chiTieu27;

    private long chiTieu28;

    private long chiTieu29;

    private long chiTieu30;

    private long chiTieu31;

    private long chiTieu32;

    @ManyToOne(fetch = FetchType.EAGER)
    private NguoiDung nguoiDung;
    
    @PrePersist
	void createdAt() {
		this.ngayNop = new Date(System.currentTimeMillis()) ;
	}

}