$(document).ready(function () {
  //    $("#btnCon").click(function() {
  //        var mauTKhai = $("#mauTKhai option:selected").val();
  //        if (!mauTKhai) {
  //            alert("Bạn chưa chọn tờ khai!");
  //            return;
  //        }
  //        if (mauTKhai == "KKTNCN02") {
  //            window.location.href = "/khai-thue/to-khai";
  //        }
  //    });

  $("#namKeKhai").on("input", function () {
    var nam = $("#namKeKhai").val();
    let year = new Date().getFullYear();
    if (!nam) {
      $("#loiNamThang").text("* Năm không để trống");
      $("#loiNamThang").show();
      return;
    }
    if (nam < 2000 || nam > year) {
      $("#loiNamThang").text("* Năm ngoài phạm vi");
      $("#loiNamThang").show();
      return;
    }
    $("#loiNamThang").hide();
  });

  $("#daiLyThue").click(function (e) {
    var checkbox = $(this);
    if (!checkbox.is(":checked")) {
      $("#tenDaiLy").prop("disabled", true);
      $("#maSoThueDaiLy").prop("disabled", true);
      $("#diaChiDaiLy").prop("disabled", true);
      $("#tinhThanhDaiLy").prop("disabled", true);
      $("#quanHuyenDaiLy").prop("disabled", true);
      $("#dienThoaiDaiLy").prop("disabled", true);
      $("#faxDaiLy").prop("disabled", true);
      $("#emailDaiLy").prop("disabled", true);
      $("#soHopDong").prop("disabled", true);
      $("#ngayHopDong").prop("disabled", true);
    } else {
      $("#tenDaiLy").prop("disabled", false);
      $("#maSoThueDaiLy").prop("disabled", false);
      $("#diaChiDaiLy").prop("disabled", false);
      $("#tinhThanhDaiLy").prop("disabled", false);
      $("#quanHuyenDaiLy").prop("disabled", false);
      $("#dienThoaiDaiLy").prop("disabled", false);
      $("#faxDaiLy").prop("disabled", false);
      $("#emailDaiLy").prop("disabled", false);
      $("#soHopDong").prop("disabled", false);
      $("#ngayHopDong").prop("disabled", false);
    }
  });

  $("#hoTen").change(function () {
    var hoTen = $("#hoTen").val();
    if (!hoTen) {
      $("#loiTenNguoiNopThue").text("*Họ và tên không để trống");
      $("#loiTenNguoiNopThue").show();
      return;
    }
    $("#loiTenNguoiNopThue").hide();
  });

  $("#maSoThue").change(function () {
    var maSoThue = $("#maSoThue").val();
    if (!maSoThue) {
      $("#loiMaSoThue").text("*Mã số thuế không để trống");
      $("#loiMaSoThue").show();
      return;
    }
    if (!/^\d+$/.test(maSoThue)) {
      $("#loiMaSoThue").text("*Mã số thuế phải là số");
      $("#loiMaSoThue").show();
      return;
    }
    $("#loiMaSoThue").hide();
  });

  $("#diaChi").change(function () {
    var diaChi = $("#diaChi").val();
    if (!diaChi) {
      $("#loiDiaChi").text("*Địa chỉ không để trống");
      $("#loiDiaChi").show();
      return;
    }
    $("#loiDiaChi").hide();
  });

  $("#tinhThanh").change(function () {
    var tinhThanh = $("#tinhThanh").val();
    if (!tinhThanh) {
      $("#loiTinhThanh").text("*Hãy lựa chọn Tỉnh/Thành phố");
      $("#loiTinhThanh").show();
      return;
    }
    $("#loiTinhThanh").hide();
  });

  $("#quanHuyen").change(function () {
    var quanHuyen = $("#quanHuyen").val();
    if (!quanHuyen) {
      $("#loiQuanHuyen").text("*Hãy lựa chọn Quận/Huyện");
      $("#loiQuanHuyen").show();
      return;
    }
    $("#loiQuanHuyen").hide();
  });
  
  $("#dienThoai").change(function () {
    var dienThoai = $("#dienThoai").val();
    if (!/^\d{10}$/.test(dienThoai)) {
      $("#loiSdt").text("*Số điện thoại phải gồm 10 số");
      $("#loiSdt").show();
      return;
    }
    $("#loiSdt").hide();
  });
  
  $("#fax").change(function () {
    var fax = $("#fax").val();
    if (!/^\d{10}$/.test(fax)) {
      $("#loiFax").text("*Số fax phải gồm 10 số");
      $("#loiFax").show();
      return;
    }
    $("#loiFax").hide();
  });


  $("#tenDaiLy").change(function () {
    var hoTen = $("#tenDaiLy").val();
    if (!hoTen) {
      $("#loiTenDLT").text("*Tên đại lý thuế không để trống");
      $("#loiTenDLT").show();
      return;
    }
    $("#loiTenDLT").hide();
  });

  $("#maSoThueDaiLy").change(function () {
    var maSoThueDLT = $("#maSoThueDaiLy").val();
    if (!maSoThueDLT) {
      $("#loiMstDLT").text("*Mã số thuế không để trống");
      $("#loiMstDLT").show();
      return;
    }
    if (!/^\d+$/.test(maSoThueDLT)) {
      $("#loiMstDLT").text("*Mã số thuế phải là số");
      $("#loiMstDLT").show();
      return;
    }
    $("#loiMstDLT").hide();
  });

  $("#diaChiDaiLy").change(function () {
    var diaChi = $("#diaChiDaiLy").val();
    if (!diaChi) {
      $("#loiDiaChiDLT").text("*Địa chỉ không để trống");
      $("#loiDiaChiDLT").show();
      return;
    }
    $("#loiDiaChiDLT").hide();
  });

  $("#tinhThanhDaiLy").change(function () {
    var tinhThanh = $("#tinhThanhDaiLy").val();
    if (!tinhThanh) {
      $("#loiTinhThanhDLT").text("*Hãy lựa chọn Tỉnh/Thành phố");
      $("#loiTinhThanhDLT").show();
      return;
    }
    $("#loiTinhThanhDLT").hide();
  });

  $("#quanHuyenDaiLy").change(function () {
    var quanHuyen = $("#quanHuyenDaiLy").val();
    if (!quanHuyen) {
      $("#loiQuanHuyenDLT").text("*Hãy lựa chọn Quận/Huyện");
      $("#loiQuanHuyenDLT").show();
      return;
    }
    $("#loiQuanHuyenDLT").hide();
  });
  
  $("#dienThoaiDaiLy").change(function () {
    var dienThoai = $("#dienThoaiDaiLy").val();
    if (!/^\d{10}$/.test(dienThoai)) {
      $("#loiSdtDLT").text("*Số điện thoại phải gồm 10 số");
      $("#loiSdtDLT").show();
      return;
    }
    if (!dienThoai) {
      $("#loiSdtDLT").text("*Điện thoại không để trống");
      $("#loiSdtDLT").show();
      return;
    }
    $("#loiSdtDLT").hide();
  });


   $("#faxDaiLy").change(function () {
    var fax = $("#faxDaiLy").val();
    if (!/^\d{10}$/.test(fax)) {
      $("#loiFaxDLT").text("*Số fax phải gồm 10 số");
      $("#loiFaxDLT").show();
      return;
    }
    $("#loiFaxDLT").hide();
  });

 
  $("#emailDaiLy").change(function () {
    var email = $("#emailDaiLy").val();
    if (!email) {
      $("#loiEmailDLT").text("*Email không để trống");
      $("#loiEmailDLT").show();
      return;
    }
    $("#loiEmailDLT").hide();
  });

  $("#soHopDong").change(function () {
    var soHopDong = $("#soHopDong").val();

    if (!soHopDong) {
      $("#loiSoHopDong").text("*Số hợp đồng không để trống");
      $("#loiSoHopDong").show();
      return;
    }
    if (!/^\d+$/.test(soHopDong)) {
      $("#loiSoHopDong").text("*Số hợp đồng là số");
      $("#loiSoHopDong").show();
      return;
    }
    $("#loiSoHopDong").hide();
  });

  $("#ngayHopDong").change(function () {
    var ngayHopDong = $("#ngayHopDong").val();
    var date = new Date(ngayHopDong).toLocaleDateString('en-CA');
    var dateNow = new Date().toLocaleDateString('en-CA');
    if (!ngayHopDong) {
      $("#loiNgayHopDong").text("*Ngày hợp đồng không để trống");
      $("#loiNgayHopDong").show();
      return;
    }
    if (dateNow < date){
      $("#loiNgayHopDong").text("*Ngày hợp đồng ngoài phạm vi");
      $("#loiNgayHopDong").show();
      return;
    }
    $("#loiNgayHopDong").hide();
  });

  $("#coquanthue").change(function () {
    var coquanthue = $('#coquanthue').val();
    if(!coquanthue) {
      $("#coquanthue").focus();
      $("#loiCoQuanThue").text("*Cơ quan thuế không được để trống");
      $("#loiCoQuanThue").show();
      return;
    }
    $("#loiCoQuanThue").hide();
  });

  $("#sdt").change(function () {
    var sdt = $('#sdt').val();
    if(!sdt) {
      $("#sdt").focus();
      $("#loiSdt").text("*Số điện thoại không được để trống");
      $("#loiSdt").show();
      return;
    } else if (!/^\d{10}$/.test(sdt)) {
      $("#sdt").focus();
      $("#loiSdt").text("*Số điện thoại phải gồm 10 số");
      $("#loiSdt").show();
      return;
    }
    $("#loiSdt").hide();
  });

  $("#email").change(function () {
    var email = $('#email').val();
    if(!email) {
      $("#email").focus();
      $("#loiEmail").text("*Email không được để trống");
      $("#loiEmail").show();
      return;
    } else if (!/^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)$/.test(email)) {
      $("#email").focus();
      $("#loiEmail").text("*Email không hợp lệ");
      $("#loiEmail").show();
      return;
    }
    $("#loiEmail").hide();
  });

  $("#coquanthue").change(function () {
    var coquanthue = $('#coquanthue').val();
    if(!coquanthue) {
      $("#coquanthue").focus();
      $("#loiCoQuanThue").text("*Cơ quan thuế không được để trống");
      $("#loiCoQuanThue").show();
      return;
    }
    $("#loiCoQuanThue").hide();
  });

  $("#mst").change(function () {
    var maSoThue = $('#mst').val();
    if(!maSoThue) {
      $("#mst").focus();
      $("#loiMst").text("*Mã số thuế không được để trống");
      $("#loiMst").show();
      return;
    }
    $("#loiMst").hide();
  });

  $("#ten").change(function () {
    var hoTen = $('#ten').val();
    if(!hoTen) {
      $("#ten").focus();
      $("#loiHoTen").text("*Họ và tên không được để trống");
      $("#loiHoTen").show();
      return;
    }
    $("#loiHoTen").hide();
  });

  $("#cccd").change(function () {
    var cccd = $('#cccd').val();
    if(!cccd) {
      $("#cccd").focus();
      $("#loiCccd").text("*CCCD không được để trống");
      $("#loiCccd").show();
      return;
    } else if (!/^\d{12}$/.test(cccd)) {
      $("#cccd").focus();
      $("#loiCccd").text("*CCCD phải bao gồm 12 số");
      $("#loiCccd").show();
      return;
    }
    $("#loiCccd").hide();
  });

  $("#matKhau").change(function () {
    var password = $('#matKhau').val();
    if(!password) {
      $("#matKhau").focus();
      $("#loiMatKhau").text("*Mật khẩu không được để trống");
      $("#loiMatKhau").show();
      return;;
    } else if (!/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,16}$/.test(password)) {
      $("#matKhau").focus();
      $("#loiMatKhau").text("*Mật khẩu từ 8-16 kí tự, chứa ít nhất một chữ cái và một số");
      $("#loiMatKhau").show();
      return;
    }
    $("#loiMatKhau").hide();
  });

  $("#nhapLaiMatKhau").change(function () {
    var password = $('#matKhau').val();
    var rePassword = $('#nhapLaiMatKhau').val();
    if(!rePassword) {
      $("#nhapLaiMatKhau").focus();
      $("#loiNhapLaiMatKhau").text("*Nhập lại mật khẩu không được để trống");
      $("#loiNhapLaiMatKhau").show();
      return;
    } else if (!(password === rePassword)) {
      $("#nhapLaiMatKhau").focus();
      $("#loiNhapLaiMatKhau").text("*Nhập lại mật khẩu không khớp");
      $("#loiNhapLaiMatKhau").show();
      return;
    }
    $("#loiNhapLaiMatKhau").hide();
  });

  $('#matKhauMoi').change(function () {
    var newPass = $('#matKhauMoi').val();
    if(!newPass) {
      $("#matKhauMoi").focus();
      $("#loiMatKhauMoi").text("*Mật khẩu không được để trống");
      $("#loiMatKhauMoi").show();
      return;
    } else if (!/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,16}$/.test(newPass)) {
      $("#matKhauMoi").focus();
      $("#loiMatKhauMoi").text("*Mật khẩu từ 8-16 kí tự, chứa ít nhất một chữ cái và một số");
      $("#loiMatKhauMoi").show();
      return;
    }
    $("#loiMatKhauMoi").hide();
  });

  $("#nhapDoiLaiMatKhau").change(function () {
    var newPass = $('#matKhauMoi').val();
    var rePassword = $('#nhapDoiLaiMatKhau').val();
    if(!rePassword) {
      $("#nhapDoiLaiMatKhau").focus();
      $("#loiNhapDoiLaiMatKhau").text("*Nhập lại mật khẩu không được để trống");
      $("#loiNhapDoiLaiMatKhau").show();
      return;
    } else if (!(newPass === rePassword)) {
      $("#nhapDoiLaiMatKhau").focus();
      $("#loiNhapDoiLaiMatKhau").text("*Nhập lại mật khẩu không khớp");
      $("#loiNhapDoiLaiMatKhau").show();
      return;
    }
    $("#loiNhapDoiLaiMatKhau").hide();
  });

  $("#kyTinhThue").change(function () {
    var kyTinhThue = $("#kyTinhThue option:selected").val();
    if (kyTinhThue == "Tháng") {
      $("#quy").hide();
      $("#thang").show();
    }
    if (kyTinhThue == "Quý") {
      $("#thang").hide();
      $("#quy").show();
    }
    localStorage.setItem("kyTinhThue", kyTinhThue);
  });

  /*$("#btnConThongTinToKhai").click(function() {
        var kyTinhThue = $("#kyTinhThue option:selected").val();
       	var nam = $("#namKeKhai").val();
        if (!nam || nam < 2000 || nam > 2900) {
            $("#namKeKhai").focus();
            return;
        }
        localStorage.setItem("kyTinhThue", kyTinhThue);
        window.location.href = "/khai-thue/tinh-thue";
    }); */

  $("#coCuTru").click(function (e) {
    var checkbox = $(this);
    if (!checkbox.is(":checked")) {
      e.preventDefault();
      return;
    }
    $("#coCuTru").attr("checked", true);
    $("#khongCuTru").prop("checked", false);
    $("#khongCuTru").removeAttr("checked");

    $("#thuNhapTinhThueKCT").prop("disabled", true);

    $("#thueThuNhapCaNhanKCT").val(0);
    $("#thuNhapTinhThueKCT").val(0);
    $("#loiThuNhapKCT").hide();
    $("#loiThueSuat").hide();

    $("#thuNhapChiuThue").prop("disabled", false);
    $("#thuNhapChiuThueMienGiam").prop("disabled", false);
    $("#giamTruNguoiPhuThuoc").prop("disabled", false);
    $("#giamTruTuThien").prop("disabled", false);
    $("#giamTruBaoHiem").prop("disabled", false);
    $("#giamTruHuuTri").prop("disabled", false);
  });

  $("#khongCuTru").click(function (e) {
    var checkbox = $(this);
    if (!checkbox.is(":checked")) {
      e.preventDefault();
      return false;
    }

    $("#khongCuTru").attr("checked", true);
    $("#coCuTru").prop("checked", false);
    $("#coCuTru").removeAttr("checked");

    $("#thuNhapTinhThueKCT").prop("disabled", false);

    $("#thuNhapChiuThue").val(0);
    $("#thuNhapChiuThueMienGiam").val(0);
    var kyTinhThue = localStorage.getItem("kyTinhThue");
    if (kyTinhThue == "Tháng") {
      $("#giamTruBanThan").val(11000000);
      $("#tongGiamTru").val(11000000);
    } else {
      $("#giamTruBanThan").val(33000000);
      $("#tongGiamTru").val(33000000);
    }
    $("#giamTruNguoiPhuThuoc").val(0);
    $("#giamTruTuThien").val(0);
    $("#giamTruBaoHiem").val(0);
    $("#giamTruHuuTri").val(0);
    $("#thuNhapTinhThue").val(0);
    $("#thueThuNhapCaNhan").val(0);

    $("#loiThuNhap").hide();
    $("#loiMienGiam").hide();
    $("#loiGiamTruBanThan").hide();
    $("#loiGiamTruNPT").hide();
    $("#loiGiamTruTuThien").hide();
    $("#loiGiamTruBaoHiem").hide();
    $("#loiGiamTruHuuTri").hide();

    $("#thuNhapChiuThue").prop("disabled", true);
    $("#thuNhapChiuThueMienGiam").prop("disabled", true);
    $("#giamTruNguoiPhuThuoc").prop("disabled", true);
    $("#giamTruTuThien").prop("disabled", true);
    $("#giamTruBaoHiem").prop("disabled", true);
    $("#giamTruHuuTri").prop("disabled", true);
  });
  
  const largeNumber = BigInt('9223372036854775807');
  $("#thuNhapChiuThue").on("input", function () {
    var v = $("#thuNhapChiuThue").val();
    if (!v) {
      $("#loiThuNhap").text("* Không được để trống");
      $("#loiThuNhap").show();
      return;
    }
    if (v <= 0) {
      $("#loiThuNhap").text("* Thu nhập phải lớn hơn 0");
      $("#loiThuNhap").show();
      return;
    }
    if (BigInt(v) > largeNumber) {
      $("#loiThuNhap").text("* Giá trị ngoài phạm vi");
      $("#loiThuNhap").show();
      return;
    }
    $("#loiThuNhap").hide();
  });

  $("#thuNhapChiuThueMienGiam").on("input", function () {
    var v = $("#thuNhapChiuThueMienGiam").val();
    if (!v) {
      $("#loiMienGiam").text("* Không được để trống");
      $("#loiMienGiam").show();
      return;
    }
    if (v < 0) {
      $("#loiMienGiam").text("* Giá trị không nhỏ hơn 0");
      $("#loiMienGiam").show();
      return;
    }
    if (BigInt(v) > largeNumber) {
      $("#loiMienGiam").text("* Giá trị ngoài phạm vi");
      $("#loiMienGiam").show();
      return;
    }
    $("#loiMienGiam").hide();
  });

  $("#giamTruNguoiPhuThuoc").on("input", function () {
    var v = $("#giamTruNguoiPhuThuoc").val();
    if (!v) {
      $("#loiGiamTruNPT").text("* Không được để trống");
      $("#loiGiamTruNPT").show();
      return;
    }
    if (v < 0) {
      $("#loiGiamTruNPT").text("* Giá trị không nhỏ hơn 0");
      $("#loiGiamTruNPT").show();
      return;
    }
    
    if (BigInt(v) > largeNumber) {
      $("#loiGiamTruNPT").text("* Giá trị ngoài phạm vi");
      $("#loiGiamTruNPT").show();
      return;
    }
    var kyTinhThue = localStorage.getItem("kyTinhThue");
    if (kyTinhThue == "Tháng") {
      if (v % 4400000 !== 0) {
        $("#loiGiamTruNPT").text("* Mỗi người phụ thuộc giảm 4.400.000đ");
        $("#loiGiamTruNPT").show();
        return;
      }
    } else {
      if (v % 13200000 !== 0) {
        $("#loiGiamTruNPT").text("* Mỗi người phụ thuộc giảm 13.200.000đ");
        $("#loiGiamTruNPT").show();
        return;
      }
    }
    $("#loiGiamTruNPT").hide();
  });

  $("#giamTruTuThien").on("input", function () {
    var v = $("#giamTruTuThien").val();
    if (!v) {
      $("#loiGiamTruTuThien").text("* Không được để trống");
      $("#loiGiamTruTuThien").show();
      return;
    }
    if (v < 0) {
      $("#loiGiamTruTuThien").text("* Giá trị không nhỏ hơn 0");
      $("#loiGiamTruTuThien").show();
      return;
    }
    if (BigInt(v) > largeNumber) {
      $("#loiGiamTruTuThien").text("* Giá trị ngoài phạm vi");
      $("#loiGiamTruTuThien").show();
      return;
    }
    $("#loiGiamTruTuThien").hide();
  });

  $("#giamTruBaoHiem").on("input", function () {
    var v = $("#giamTruBaoHiem").val();
    if (!v) {
      $("#loiGiamTruBaoHiem").text("* Không được để trống");
      $("#loiGiamTruBaoHiem").show();
      return;
    }
    if (v < 0) {
      $("#loiGiamTruBaoHiem").text("* Giá trị không nhỏ hơn 0");
      $("#loiGiamTruBaoHiem").show();
      return;
    }
    if (BigInt(v) > largeNumber) {
      $("#loiGiamTruBaoHiem").text("* Giá trị ngoài phạm vi");
      $("#loiGiamTruBaoHiem").show();
      return;
    }
    $("#loiGiamTruBaoHiem").hide();
  });

  $("#giamTruHuuTri").on("input", function () {
    var v = $("#giamTruHuuTri").val();
    if (!v) {
      $("#loiGiamTruHuuTri").text("* Không được để trống");
      $("#loiGiamTruHuuTri").show();
      return;
    }
    if (v < 0) {
      $("#loiGiamTruHuuTri").text("* Giá trị không nhỏ hơn 0");
      $("#loiGiamTruHuuTri").show();
      return;
    }
    if (BigInt(v) > largeNumber) {
      $("#loiGiamTruHuuTri").text("* Giá trị ngoài phạm vi");
      $("#loiGiamTruHuuTri").show();
      return;
    }
    $("#loiGiamTruHuuTri").hide();
  });

  $("#thuNhapTinhThueKCT").on("input", function () {
    var v = $("#thuNhapTinhThueKCT").val();
    if (!v) {
      $("#loiThuNhapKCT").text("* Không được để trống");
      $("#loiThuNhapKCT").show();
      return;
    }
    if (v <= 0) {
      $("#loiThuNhapKCT").text("* Thu nhập phải lớn hơn 0");
      $("#loiThuNhapKCT").show();
      return;
    }
    if (BigInt(v) > largeNumber) {
      $("#loiThuNhapKCT").text("* Giá trị ngoài phạm vi");
      $("#loiThuNhapKCT").show();
      return;
    }
    $("#loiThuNhapKCT").hide();
  });

});

// tinh thue
function tinhThue() {
  var kyTinhThue = localStorage.getItem("kyTinhThue");
  const largeNumber = BigInt('9223372036854775807');
  if ($("#coCuTru").is(":checked")) {
    var thuNhapChiuThue = $("#thuNhapChiuThue").val();
    if (!thuNhapChiuThue || thuNhapChiuThue < 0 || BigInt(thuNhapChiuThue) > largeNumber) {
//      thuNhapChiuThue = 0;
//      $("#thuNhapChiuThue").val(thuNhapChiuThue);
//      $("#loiThuNhap").hide();
        return;
    }

    var mienGiam = $("#thuNhapChiuThueMienGiam").val();
    if (!mienGiam || mienGiam < 0 || BigInt(mienGiam) > largeNumber) {
//      mienGiam = 0;
//      $("#thuNhapChiuThueMienGiam").val(mienGiam);
//      $("#loiMienGiam").hide();
        return;
    }

    var banThan = $("#giamTruBanThan").val();

    var nguoiPhuThuoc = $("#giamTruNguoiPhuThuoc").val();
    if (kyTinhThue == "Tháng") {
      if (
        !nguoiPhuThuoc ||
        nguoiPhuThuoc < 0 ||
        nguoiPhuThuoc % 4400000 !== 0 ||
        BigInt(nguoiPhuThuoc) > largeNumber
      ) {
//        nguoiPhuThuoc = 0;
//        $("#giamTruNguoiPhuThuoc").val(nguoiPhuThuoc);
//        $("#loiGiamTruNPT").hide();
          return;
      }
    } else {
      if (
        !nguoiPhuThuoc ||
        nguoiPhuThuoc < 0 ||
        nguoiPhuThuoc % 13200000 !== 0 ||
        BigInt(nguoiPhuThuoc) > largeNumber
      ) {
//        nguoiPhuThuoc = 0;
//        $("#giamTruNguoiPhuThuoc").val(nguoiPhuThuoc);
//        $("#loiGiamTruNPT").hide();
          return;
      }
    }

    var tuThien = $("#giamTruTuThien").val();
    if (!tuThien || tuThien < 0 || BigInt(tuThien) > largeNumber) {
//      tuThien = 0;
//      $("#giamTruTuThien").val(tuThien);
//      $("#loiGiamTruTuThien").hide();
        return;
    }

    var baoHiem = $("#giamTruBaoHiem").val();
    if (!baoHiem || baoHiem < 0 || BigInt(baoHiem) > largeNumber) {
//      baoHiem = 0;
//      $("#giamTruBaoHiem").val(baoHiem);
//      $("#loiGiamTruBaoHiem").hide();
        return;
    }

    var huuTri = $("#giamTruHuuTri").val();
    if (!huuTri || huuTri < 0 || BigInt(huuTri) > largeNumber) {
//      huuTri = 0;
//      $("#giamTruHuuTri").val(huuTri);
//      $("#loiGiamTruHuuTri").hide();
        return;
    }
    var tongGiamTru =
      Number(banThan) +
      Number(nguoiPhuThuoc) +
      Number(tuThien) +
      Number(baoHiem) +
      Number(huuTri);
    $("#tongGiamTru").val(tongGiamTru);
    var thuNhapTinhThue =
      Number(thuNhapChiuThue) - Number(mienGiam) - Number(tongGiamTru);
    if (thuNhapTinhThue <= 0) {
      $("#thuNhapTinhThue").val(0);
      $("#thueThuNhapCaNhan").val(0);
    } else {
      if (kyTinhThue == "Tháng") {
        $("#thuNhapTinhThue").val(thuNhapTinhThue);
        var thueThuNhapCaNhan;
        if (thuNhapTinhThue <= 5000000)
          thueThuNhapCaNhan = ((thuNhapTinhThue * 5) / 100).toFixed(0);
        else if (thuNhapTinhThue <= 10000000)
          thueThuNhapCaNhan = ((thuNhapTinhThue * 10) / 100 - 250000).toFixed(
            0
          );
        else if (thuNhapTinhThue <= 18000000)
          thueThuNhapCaNhan = ((thuNhapTinhThue * 15) / 100 - 750000).toFixed(
            0
          );
        else if (thuNhapTinhThue <= 32000000)
          thueThuNhapCaNhan = ((thuNhapTinhThue * 20) / 100 - 1650000).toFixed(
            0
          );
        else if (thuNhapTinhThue <= 52000000)
          thueThuNhapCaNhan = ((thuNhapTinhThue * 25) / 100 - 3250000).toFixed(
            0
          );
        else if (thuNhapTinhThue <= 80000000)
          thueThuNhapCaNhan = ((thuNhapTinhThue * 30) / 100 - 5850000).toFixed(
            0
          );
        else
          thueThuNhapCaNhan = ((thuNhapTinhThue * 35) / 100 - 9850000).toFixed(
            0
          );

        $("#thueThuNhapCaNhan").val(thueThuNhapCaNhan);
      } else {
        $("#thuNhapTinhThue").val(thuNhapTinhThue);
        var thueThuNhapCaNhan;
        if (thuNhapTinhThue <= 15000000)
          thueThuNhapCaNhan = ((thuNhapTinhThue * 5) / 100).toFixed(0);
        else if (thuNhapTinhThue <= 30000000)
          thueThuNhapCaNhan = (
            (thuNhapTinhThue * 10) / 100 -
            250000 * 3
          ).toFixed(0);
        else if (thuNhapTinhThue <= 54000000)
          thueThuNhapCaNhan = (
            (thuNhapTinhThue * 15) / 100 -
            750000 * 3
          ).toFixed(0);
        else if (thuNhapTinhThue <= 96000000)
          thueThuNhapCaNhan = (
            (thuNhapTinhThue * 20) / 100 -
            1650000 * 3
          ).toFixed(0);
        else if (thuNhapTinhThue <= 156000000)
          thueThuNhapCaNhan = (
            (thuNhapTinhThue * 25) / 100 -
            3250000 * 3
          ).toFixed(0);
        else if (thuNhapTinhThue <= 240000000)
          thueThuNhapCaNhan = (
            (thuNhapTinhThue * 30) / 100 -
            5850000 * 3
          ).toFixed(0);
        else
          thueThuNhapCaNhan = (
            (thuNhapTinhThue * 35) / 100 -
            9850000 * 3
          ).toFixed(0);

        $("#thueThuNhapCaNhan").val(thueThuNhapCaNhan);
      }
    }
  }

  if ($("#khongCuTru").is(":checked")) {
    var thuNhapTinhThue = $("#thuNhapTinhThueKCT").val();
    if (!thuNhapTinhThue || thuNhapTinhThue < 0 || BigInt(thuNhapTinhThue) > largeNumber) {
//      thuNhapTinhThue = 0;
//      $("#thuNhapTinhThueKCT").val(0);
//      $("#loiThuNhapKCT").hide();
        return;
    }
    var thue = ((thuNhapTinhThue * 20) / 100).toFixed(0);
    $("#thueThuNhapCaNhanKCT").val(thue);
  }
}

// district
window.onload = function () {
  var kyTinhThue = $("#kyTinhThue option:selected").val();
  localStorage.setItem("kyTinhThue", kyTinhThue);

  if ((address_2 = localStorage.getItem("address_2_saved"))) {
    $('select[name="quanHuyen"] option').each(function () {
      if ($(this).text() == address_2) {
        $(this).attr("selected", "");
      }
    });
  }
  if ((district = localStorage.getItem("district"))) {
    $('select[name="quanHuyen"]').html(district);
    $('select[name="quanHuyen"]').on("change", function () {
      var target = $(this).children("option:selected");
      target.attr("selected", "");
      $('select[name="quanHuyen"] option').not(target).removeAttr("selected");
      address_2 = target.text();
      district = $('select[name="quanHuyen"]').html();
      localStorage.setItem("district", district);
      localStorage.setItem("address_2_saved", address_2);
    });
  }
  $('select[name="tinhThanh"]').each(function () {
    var $this = $(this),
      stc = "";
    c.forEach(function (i, e) {
      e += +1;
      stc += '<option value="' + i + '">' + i + "</option>";
      $this.html('<option value="">Tỉnh / Thành phố</option>' + stc);
      if ((address_1 = localStorage.getItem("address_1_saved"))) {
        $('select[name="tinhThanh"] option').each(function () {
          if ($(this).text() == address_1) {
            $(this).attr("selected", "");
          }
        });
      }
      $this.on("change", function (i) {
        i = $this.children("option:selected").index() - 1;
        var str = "",
          r = $this.val();
        if (r != "") {
          arr[i].forEach(function (el) {
            str += '<option value="' + el + '">' + el + "</option>";
            $('select[name="quanHuyen"]').html(
              '<option value="">Quận / Huyện</option>' + str
            );
          });
          var address_1 = $this.children("option:selected").text();
          var district = $('select[name="quanHuyen"]').html();
          localStorage.setItem("address_1_saved", address_1);
          localStorage.setItem("district", district);
          $('select[name="quanHuyen"]').on("change", function () {
            var target = $(this).children("option:selected");
            target.attr("selected", "");
            $('select[name="quanHuyen"] option')
              .not(target)
              .removeAttr("selected");
            var address_2 = target.text();
            district = $('select[name="quanHuyen"]').html();
            localStorage.setItem("district", district);
            localStorage.setItem("address_2_saved", address_2);
          });
        } else {
          $('select[name="quanHuyen"]').html(
            '<option value="">Quận / Huyện</option>'
          );
          district = $('select[name="quanHuyen"]').html();
          localStorage.setItem("district", district);
          localStorage.removeItem("address_1_saved", address_1);
        }
      });
    });
  });
  if ((address_4 = localStorage.getItem("address_4_saved"))) {
    $('select[name="quanHuyenDLT"] option').each(function () {
      if ($(this).text() == address_4) {
        $(this).attr("selected", "");
      }
    });
  }
  if ((district2 = localStorage.getItem("district2"))) {
    $('select[name="quanHuyenDLT"]').html(district2);
    $('select[name="quanHuyenDLT"]').on("change", function () {
      var target = $(this).children("option:selected");
      target.attr("selected", "");
      $('select[name="quanHuyenDLT"] option')
        .not(target)
        .removeAttr("selected");
      address_4 = target.text();
      district2 = $('select[name="quanHuyenDLT"]').html();
      localStorage.setItem("district2", district2);
      localStorage.setItem("address_4_saved", address_4);
    });
  }
  $('select[name="tinhThanhDLT"]').each(function () {
    var $this = $(this),
      stc = "";
    c.forEach(function (i, e) {
      e += +1;
      stc += "<option value=" + i + ">" + i + "</option>";
      $this.html('<option value="">Tỉnh / Thành phố</option>' + stc);
      if ((address_3 = localStorage.getItem("address_3_saved"))) {
        $('select[name="tinhThanhDLT"] option').each(function () {
          if ($(this).text() == address_3) {
            $(this).attr("selected", "");
          }
        });
      }
      $this.on("change", function (i) {
        i = $this.children("option:selected").index() - 1;
        var str = "",
          r = $this.val();
        if (r != "") {
          arr[i].forEach(function (el) {
            str += '<option value="' + el + '">' + el + "</option>";
            $('select[name="quanHuyenDLT"]').html(
              '<option value="">Quận / Huyện</option>' + str
            );
          });
          var address_3 = $this.children("option:selected").text();
          var district2 = $('select[name="quanHuyenDLT"]').html();
          localStorage.setItem("address_3_saved", address_3);
          localStorage.setItem("district2", district2);
          $('select[name="quanHuyenDaiLy"]').on("change", function () {
            var target = $(this).children("option:selected");
            target.attr("selected", "");
            $('select[name="quanHuyenDLT"] option')
              .not(target)
              .removeAttr("selected");
            var address_4 = target.text();
            district2 = $('select[name="quanHuyenDLT"]').html();
            localStorage.setItem("district2", district2);
            localStorage.setItem("address_4_saved", address_4);
          });
        } else {
          $('select[name="quanHuyenDLT"]').html(
            '<option value="">Quận / Huyện</option>'
          );
          district2 = $('select[name="quanHuyenDLT"]').html();
          localStorage.setItem("district2", district2);
          localStorage.removeItem("address_3_saved", address_3);
        }
      });
    });
  });
};

function loadTinhThue() {
  var kyTinhThue = localStorage.getItem("kyTinhThue");
  if (kyTinhThue == "Tháng") {
    $("#giamTruBanThan").val(11000000);
    $("#tongGiamTru").val(11000000);
  } else {
    $("#giamTruBanThan").val(33000000);
    $("#tongGiamTru").val(33000000);
  }
}

async function validateToKhaiForm(form) {
  console.log(form)
  var nam = $("#namKeKhai").val();
  let year = new Date().getFullYear();
  if (!nam || nam < 2000 || nam > year) {
    $("#namKeKhai").focus();
    return false;
  }

  var hoTen = $("#hoTen").val();
  if (!hoTen) {
    $("#hoTen").focus();
    $("#loiTenNguoiNopThue").text("*Họ và tên không để trống");
    $("#loiTenNguoiNopThue").show();
    return false;
  }

  var maSoThue = $("#maSoThue").val();
  if (!maSoThue) {
    $("#maSoThue").focus();
    $("#loiMaSoThue").text("*Mã số thuế không để trống");
    $("#loiMaSoThue").show();
    return false;
  }
  if (!/^\d+$/.test(maSoThue)) {
    $("#loiMaSoThue").text("*Mã số thuế phải là số");
    $("#loiMaSoThue").show();
    return false;
  }

  var diaChi = $("#diaChi").val();
  if (!diaChi) {
    $("#diaChi").focus();
    $("#loiDiaChi").text("*Địa chỉ không để trống");
    $("#loiDiaChi").show();
    return false;
  }

  var tinhThanh = $("#tinhThanh option:selected").val();
  if (!tinhThanh) {
    $("#tinhThanh").focus();
    $("#loiTinhThanh").text("*Hãy lựa chọn Tỉnh/Thành phố");
    $("#loiTinhThanh").show();
    return false;
  }

  var quanHuyen = $("#quanHuyen").val();
  if (!quanHuyen) {
    $("#quanHuyen").focus();
    $("#loiQuanHuyen").text("*Hãy lựa chọn Quận/Huyện");
    $("#loiQuanHuyen").show();
    return false;
  }

  var fax = $("#fax").val();
  if (fax && !/^\d{10}$/.test(fax)) {
    $("#fax").focus();
    $("#loiFax").text("*Số fax phải gồm 10 số");
    $("#loiFax").show();
    return false;
  }

  var dienThoai = $("#dienThoai").val();
  if (dienThoai && !/^\d{10}$/.test(dienThoai)) {
    $("#loiSdt").text("*Số điện thoại phải là số");
    $("#loiSdt").show();
    return false;
  }

  var daiLyThue = $("#daiLyThue").prop("checked");
  if (daiLyThue) {
    var error = false;
    var tenDaiLyThue = $("#tenDaiLy").val();
    if (!tenDaiLyThue) {
      $("#tenDaiLy").focus();
      $("#loiTenDLT").text("*Tên đại lý thuế không để trống");
      $("#loiTenDLT").show();
      error = true;
    }

    var maSoThueDLT = $("#maSoThueDaiLy").val();
    if (!maSoThueDLT) {
      $("#maSoThueDaiLy").focus();
      $("#loiMstDLT").text("*Mã số thuế không để trống");
      $("#loiMstDLT").show();
      error = true;
    }
    if (!/^\d+$/.test(maSoThueDLT)) {
      $("#maSoThueDaiLy").focus();
      $("#loiMstDLT").text("*Mã số thuế phải là số");
      $("#loiMstDLT").show();
      error = true;
    }

    if (maSoThueDLT !== "" && tenDaiLyThue !== "") {
      try {
        const data = await getDaiLyThue(maSoThueDLT);
        console.log(data)
        if(!data) {
          $("#maSoThueDaiLy").focus();
          $("#loiMstDLT").text("*Mã số thuế của đai lý không tồn tại");
          $("#loiMstDLT").show();
          error = true;
        } else if(tenDaiLyThue !== data.ten) {
          $("#tenDaiLy").focus();
          $("#loiTenDLT").text("*Tên đại lý thuế không khớp với mã số thuế");
          $("#loiTenDLT").show();
          error = true;
        }
      } catch (e) {
        console.log(e)
        error = true;
      }
    }

    var diaChiDLT = $("#diaChiDaiLy").val();
    if (!diaChiDLT) {
      $("#diaChiDaiLy").focus();
      $("#loiDiaChiDLT").text("*Địa chỉ không để trống");
      $("#loiDiaChiDLT").show();
      error = true;
    }

    var tinhThanhDaiLy = $("#tinhThanhDaiLy option:selected").val();
    if (!tinhThanhDaiLy) {
      $("#tinhThanhDaiLy").focus();
      $("#loiTinhThanhDLT").text("*Hãy lựa chọn Tỉnh/Thành phố");
      $("#loiTinhThanhDLT").show();
      error = true;
    }

    var quanHuyenDaiLy = $("#quanHuyenDaiLy option:selected").val();
    if (!quanHuyenDaiLy) {
      $("#quanHuyenDaiLy").focus();
      $("#loiQuanHuyenDLT").text("*Hãy lựa chọn Quận/Huyện");
      $("#loiQuanHuyenDLT").show();
      error = true;
    }
    
    var dienThoai = $("#dienThoaiDaiLy").val();
    if (dienThoai && !/^\d{10}$/.test(dienThoai)) {
      $("#dienThoaiDaiLy").focus();
      $("#loiSdtDLT").text("*Số điện thoại phải gồm 10 số");
      $("#loiSdtDLT").show();
      error = true;
    }
    if (!dienThoai) {
      $("#dienThoaiDaiLy").focus();
      $("#loiSdtDLT").text("*Điện thoại không để trống");
      $("#loiSdtDLT").show();
      error = true;
    }
    
    var fax = $("#faxDaiLy").val();
    if (fax && !/^\d{10}$/.test(fax)) {
      $("#faxDaiLy").focus();
      $("#loiFaxDLT").text("*Số fax phải gồm 10 số");
      $("#loiFaxDLT").show();
      error = true;
    }

    var email = $("#emailDaiLy").val();
    if (!email) {
      $("#emailDaiLy").focus();
      $("#loiEmailDLT").text("*Email không để trống");
      $("#loiEmailDLT").show();
      error = true;
    }

    var soHopDong = $("#soHopDong").val();
    if (!soHopDong) {
      $("#soHopDong").focus();
      $("#loiSoHopDong").text("*Số hợp đồng không để trống");
      $("#loiSoHopDong").show();
      error = true;
    }
    if (!/^\d+$/.test(soHopDong)) {
      $("#soHopDong").focus();
      $("#loiSoHopDong").text("*Số hợp đồng là số");
      $("#loiSoHopDong").show();
      error = true;
    }

    var ngayHopDong = $("#ngayHopDong").val();
    var date = new Date(ngayHopDong);
    var dateNow = new Date();
    if (!ngayHopDong) {
      $("#ngayHopDong").focus();
      $("#loiNgayHopDong").text("*Ngày hợp đồng không để trống");
      $("#loiNgayHopDong").show();
      error = true;
    }
    if (dateNow < date){
      $("#ngayHopDong").focus();
      $("#loiNgayHopDong").text("*Ngày hợp đồng ngoài phạm vi");
      $("#loiNgayHopDong").show();
      error = true;
    }
    if(error) {
      return false;
    }
  }
  form.submit();
}

async function getDaiLyThue(id) {
  return $.ajax({
    url: `/dailythue?maSoThue=${id}`,
    type: 'GET',
  });
};

function validateTinhThueForm() {
//  var cuTru = $("#coCuTru").prop("checked");
//  console.log(cuTru);
//  if (cuTru) {
//    var thuNhapChiuThue = $("#thuNhapChiuThue").val();
//    if (thuNhapChiuThue <= 0) {
//      $("#thuNhapChiuThue").focus();
//      $("#loiThuNhap").text("*Thu nhập phải lớn hơn 0");
//      $("#loiThuNhap").show();
//      return false;
//    }
//    if (thuNhapChiuThue > 9223372036854775807){
//      $("#thuNhapChiuThue").focus();
//      $("#loiThuNhap").text("*Giá trị ngoài phạm vi");
//      $("#loiThuNhap").show();
//      return false;
//    }
//  } else {
//    var thuNhapTinhThue = $("#thuNhapTinhThueKCT").val();
//    if (thuNhapTinhThue <= 0) {
//      $("#thuNhapTinhThueKCT").focus();
//      $("#loiThuNhapKCT").text("*Thu nhập phải lớn hơn 0");
//      $("#loiThuNhapKCT").show();
//      return false;
//    }
//  }
    const largeNumber = BigInt('1000000000000000000');
    if ($("#coCuTru").is(":checked")) {
      var v = $("#thuNhapChiuThue").val();
      if (v <= 0) {
        $("#thuNhapChiuThue").focus();
        $("#loiThuNhap").text("* Thu nhập phải lớn hơn 0");
        $("#loiThuNhap").show();
        return false;
      }
      
      if (!v || BigInt(v) > largeNumber){
        $("#thuNhapChiuThue").focus();
        return false;
      }

      var v = $("#thuNhapChiuThueMienGiam").val();
      if (!v || v < 0 || BigInt(v) > largeNumber) {
        $("#thuNhapChiuThueMienGiam").focus();
        return false;
      }

      var v = $("#giamTruNguoiPhuThuoc").val();
      var kyTinhThue = localStorage.getItem("kyTinhThue");
      if (kyTinhThue == "Tháng") {
        if (!v || v < 0 || v % 4400000 !== 0 || BigInt(v) > largeNumber) {
          $("#giamTruNguoiPhuThuoc").focus();
          return false;
        }
      } else {
        if (!v || v < 0 || v % 13200000 != 0 || BigInt(v) > largeNumber) {
          $("#giamTruNguoiPhuThuoc").focus();
          return false;
        }
      }

      var v = $("#giamTruTuThien").val();
      if (!v || v < 0 || BigInt(v) > largeNumber) {
        $("#giamTruTuThien").focus();
        return false;
      }

      var v = $("#giamTruBaoHiem").val();
      if (!v || v < 0 || BigInt(v) > largeNumber) {
        $("#giamTruBaoHiem").focus();
        return false;
      }

      var v = $("#giamTruHuuTri").val();
      if (!v || v < 0 || BigInt(v) > largeNumber) {
        $("#giamTruHuuTri").focus();
        return false;
      }
    }

    if ($("#khongCuTru").is(":checked")) {
      var v = $("#thuNhapTinhThueKCT").val();
      if (!v || v <= 0 || BigInt(v) > largeNumber) {
        $("#thuNhapTinhThueKCT").focus();
        return false;
      }

      var v = $("#mucThueSuat").val();
      if (!v || v < 0 || v > 100) {
        $("#mucThueSuat").focus();
        return false;
      }
    }

  return true;
}

function validateDoiThongTinForm() {
  var diaChi = $('#diaChi').val();
  var coquanthue = $('#coquanthue').val();
  var sdt = $('#sdt').val();
  var email = $('#email').val();
  var error = false;

  if(!diaChi) {
    $("#diaChi").focus();
    $("#loiDiaChi").text("*Địa chỉ không được để trống");
    $("#loiDiaChi").show();
    error = true;
  }
  if(!coquanthue) {
    $("#coquanthue").focus();
    $("#loiCoQuanThue").text("*Cơ quan thuế không được để trống");
    $("#loiCoQuanThue").show();
    error = true;
  }
  if(!sdt) {
    $("#sdt").focus();
    $("#loiSdt").text("*Số điện thoại không được để trống");
    $("#loiSdt").show();
    error = true;
  } else if (!/^\d{10}$/.test(sdt)) {
    $("#sdt").focus();
    $("#loiSdt").text("*Số điện thoại phải gồm 10 số");
    $("#loiSdt").show();
    error = true;
  }
  if(!email) {
    $("#email").focus();
    $("#loiEmail").text("*Email không được để trống");
    $("#loiEmail").show();
    error = true;
  } else if (!/^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)$/.test(email)) {
    $("#email").focus();
    $("#loiEmail").text("*Email không hợp lệ");
    $("#loiEmail").show();
    error = true;
  }
  if (error) {
    return false;
  }
}


async function validateDangKyForm(form) {
  var maSoThue = $('#mst').val();
  var hoTen = $('#ten').val();
  var cccd = $('#cccd').val();
  var password = $('#matKhau').val();
  var rePassword = $('#nhapLaiMatKhau').val();
  var diaChi = $('#diaChi').val();
  var coquanthue = $('#coquanthue').val();
  var sdt = $('#sdt').val();
  var email = $('#email').val();
  var error = false;

  if(!maSoThue) {
    $("#mst").focus();
    $("#loiMst").text("*Mã số thuế không được để trống");
    $("#loiMst").show();
    error = true;
  }

  if(!hoTen) {
    $("#ten").focus();
    $("#loiHoTen").text("*Họ và tên không được để trống");
    $("#loiHoTen").show();
    error = true;
  }

  if(!cccd) {
    $("#cccd").focus();
    $("#loiCccd").text("*CCCD không được để trống");
    $("#loiCccd").show();
    error = true;
  } else if (!/^\d{12}$/.test(cccd)) {
    $("#cccd").focus();
    $("#loiCccd").text("*CCCD phải bao gồm 12 số");
    $("#loiCccd").show();
    error = true;
  }

  if(!diaChi) {
    $("#diaChi").focus();
    $("#loiDiaChi").text("*Địa chỉ không được để trống");
    $("#loiDiaChi").show();
    error = true;
  }
  if(!coquanthue) {
    $("#coquanthue").focus();
    $("#loiCoQuanThue").text("*Cơ quan thuế không được để trống");
    $("#loiCoQuanThue").show();
    error = true;
  }
  if(!sdt) {
    $("#sdt").focus();
    $("#loiSdt").text("*Số điện thoại không được để trống");
    $("#loiSdt").show();
    error = true;
  } else if (!/^\d{10}$/.test(sdt)) {
    $("#sdt").focus();
    $("#loiSdt").text("*Số điện thoại phải gồm 10 số");
    $("#loiSdt").show();
    error = true;
  }
  if(!email) {
    $("#email").focus();
    $("#loiEmail").text("*Email không được để trống");
    $("#loiEmail").show();
    error = true;
  } else if (!/^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)$/.test(email)) {
    $("#email").focus();
    $("#loiEmail").text("*Email không hợp lệ");
    $("#loiEmail").show();
    error = true;
  }

  if(!password) {
    $("#matKhau").focus();
    $("#loiMatKhau").text("*Mật khẩu không được để trống");
    $("#loiMatKhau").show();
    error = true;
  } else if (!/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,16}$/.test(password)) {
    $("#matKhau").focus();
    $("#loiMatKhau").text("*Mật khẩu từ 8-16 kí tự, chứa ít nhất một chữ cái và một số");
    $("#loiMatKhau").show();
    error = true;
  }

  if(!rePassword) {
    $("#nhapLaiMatKhau").focus();
    $("#loiNhapLaiMatKhau").text("*Nhập lại mật khẩu không được để trống");
    $("#loiNhapLaiMatKhau").show();
    error = true;
  } else if (!(password === rePassword)) {
    $("#nhapLaiMatKhau").focus();
    $("#loiNhapLaiMatKhau").text("*Nhập lại mật khẩu không khớp");
    $("#loiNhapLaiMatKhau").show();
    error = true;
  }

  if(cccd && hoTen && maSoThue) {
    try {
      const data = await getMaSoThue(maSoThue);
      console.log(data)
      if(!data) {
        $("#mst").focus();
        $("#loiMst").text("*Mã số thuế không tồn tại");
        $("#loiMst").show();
        error = true;
      } else if(hoTen !== data.hoTen) {
        $("#ten").focus();
        $("#loiHoTen").text("*Họ và tên không khớp với mã số thuế");
        $("#loiHoTen").show();
        error = true;
      } else if(cccd !== data.cccd) {
        $("#cccd").focus();
        $("#loiCccd").text("*CCCD không khớp với mã số thuế");
        $("#loiCccd").show();
        error = true;
      } else {
        const exist = await getTonTai(maSoThue);
        if(exist) {
          $("#mst").focus();
          $("#loiMst").text("*Mã số thuế đã đăng kí, vui lòng sử dụng mã số thuế khác hoặc chuyển tới trang đăng nhập!");
          $("#loiMst").show();
          error = true;
        }
      }
    } catch (e) {
      console.log(e)
      error = true;
    }
  }
  if (error) {
    return false;
  }
  form.submit();
}

async function getMaSoThue(id) {
  return $.ajax({
    url: `/masothue?maSoThue=${id}`,
    type: 'GET',
  });
};

async function getTonTai(id) {
  return $.ajax({
    url: `/masothue/ton-tai?maSoThue=${id}`,
    type: 'GET',
  });
};

function validateDoiMatKhau() {
  var newPass = $('#matKhauMoi').val();
  var rePassword = $('#nhapDoiLaiMatKhau').val();
  var error = false;

  if(!newPass) {
    $("#matKhauMoi").focus();
    $("#loiMatKhauMoi").text("*Mật khẩu không được để trống");
    $("#loiMatKhauMoi").show();
    error = true;
  } else if (!/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,16}$/.test(newPass)) {
    $("#matKhauMoi").focus();
    $("#loiMatKhauMoi").text("*Mật khẩu từ 8-16 kí tự, chứa ít nhất một chữ cái và một số");
    $("#loiMatKhauMoi").show();
    error = true;
  }

  if(!rePassword) {
    $("#nhapDoiLaiMatKhau").focus();
    $("#loiNhapDoiLaiMatKhau").text("*Nhập lại mật khẩu không được để trống");
    $("#loiNhapDoiLaiMatKhau").show();
    error = true;
  } else if (!(newPass === rePassword)) {
    $("#nhapDoiLaiMatKhau").focus();
    $("#loiNhapDoiLaiMatKhau").text("*Nhập lại mật khẩu không khớp");
    $("#loiNhapDoiLaiMatKhau").show();
    error = true;
  }
  console.log(newPass);
  console.log(rePassword);
  if (error) {
    return false;
  }
  return true;
}