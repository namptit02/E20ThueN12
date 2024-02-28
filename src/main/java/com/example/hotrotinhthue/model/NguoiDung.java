package com.example.hotrotinhthue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nguoidung")
public class NguoiDung implements UserDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@NotBlank(message = "* Trường không để trống")
    private String maSoThue;

    @Column(nullable = false)
    private String matKhau;

    @Column(nullable = false)
    @NotBlank(message = "* Trường không để trống")
//    @Pattern(regexp = "^([A-Z a-z]+)(\\s{1}[A-Z a-z]+)$", message = "* Họ tên không hợp lệ (không dấu)")
    private String hoTen;

	@NotBlank(message = "* Trường không để trống")
    private String diaChi;

    @Column(nullable = false)
    @NotBlank(message = "* Trường không để trống")
    @Pattern(regexp = "^[0-9]+$", message = "* Số căn cước công dân không hợp lệ")
    private String cccd;
    
    @NotBlank(message = "* Trường không để trống")
    private String coQuanThue;

    @NotBlank(message = "* Trường không để trống")
    @Pattern(regexp = "^[0-9]+$", message = "* Số điện thoại không hợp lệ")
    private String sdt;

    @NotBlank(message = "* Trường không để trống")
    @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "* Email không hợp lệ")
    private String email;

    @Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return matKhau;
	}

	@Override
	public String getUsername() {
		return maSoThue;
	}

	@ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "nguoiDung")
    private List<ToKhaiThue> toKhaiThueList = new ArrayList<>();

}
