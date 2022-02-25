----									Truy Vấn
--Nhân Viên
select * From NhanVien
insert into NhanVien(MaNV,MatKhau,HoTen,VaiTro) values(?,?,?,?)
update NhanVien set MatKhau=?, HoTen=?,VaiTro=? where MaNV=?
delete from NhanVien where MaNV=?
select * from NhanVien where MaNV = ?


---								Chuyên Đề
	select * from ChuyenDe
	INSERT INTO ChuyenDe(MaCD,tenCD,HocPhi,ThoiLuong,Hinh,MoTa) values('java1','java',12,12,'LyLX.png','OK')
	UPDATE ChuyenDe set tenCD=?,HocPhi=?,ThoiLuong=?,Hinh=?,MoTa=? WHERE MaCD=?
	DELETE FROM ChuyenDe WHERE MaCD=?
	SELECT * FROM ChuyenDe WHERE MaCD=?

---								Người Học
	select * from NguoiHoc
	SELECT * FROM NguoiHoc WHERE MANH = ?
	SELECT * FROM NguoiHoc WHERE HoTen LIKE '%Đ%'
	INSERT INTO NguoiHoc(MaNH,HoTen,NgaySinh,GioiTinh,DienThoai,Email,GhiChu,MaNV,NgayDK) VALUES('aaaaaa','a','11/11/1997',1,'0123123','asdasd','sadas','PH18618','2020-02-02')
	UPDATE NguoiHoc SET HoTen=?,NgaySinh=?,GioiTinh=?,DienThoai=?,Email=?,GhiChu=?,MaNV=?,NgayDK=? WHERE MaNH=?
	DELETE FROM NguoiHoc WHERE MaNH=?
	SELECT * FROM NguoiHoc WHERE HoTen LIKE ? AND MaNH NOT IN(SELECT MaNH FROM HocVien WHERE MaKH = ?)
	--					Khóa Học
	SELECT * FROM KhoaHoc
	INSERT INTO KhoaHoc(MaCD,HocPhi,ThoiLuong,NgayKG,GhiChu,MaNV,NgayTao) VALUES(?,?,?,?,?,?,?)
	UPDATE KhoaHoc SET MaCD=?,
	DELETE FROM KhoaHoc WHERE MaKH=?
	select DISTINCT YEAR(NgayKG) YEAR from KhoaHoc order by YEAR desc
	--													HOC VIEN
	SELECT * FROM HocVien
	SELECT * FROM HocVien WHERE MaHV=?
	SELECT * FROM HocVien WHERE MaKH=?
	INSERT INTO HocVien(MaKH,MaNH,Diem)VALUES (?,?,?)
	UPDATE HocVien SET Diem=9 WHERE MaHV=8
	DELETE FROM HocVien WHERE MaHV = 9
	

	--								THỐNG KÊ
	CREATE PROC sp_BangDiem(@maKH int)
	AS BEGIN
		SELECT nh.MaNH,nh.HoTen,hv.Diem from HocVien hv join NguoiHoc nh on nh.MaNH=hv.MaNH
		WHERE hv.MaKH = @maKH
		ORDER BY hv.Diem DESC
	END
	exec sp_BangDiem 12


	CREATE PROC sp_DiemChuyenDe
	AS BEGIN
		SELECT tenCD ChuyenDe, COUNT(MaHV) soHV,MIN(Diem) ThapNhat,MAX(Diem) CaoNhat,AVG(Diem) TrungBinh
		FROM KhoaHoc kh join HocVien hv on kh.MaKH=hv.MaKH
				join ChuyenDe cd on cd.MaCD=kh.MaCD
		GROUP BY tenCD

	END


	CREATE PROC sp_LuongNguoiHoc
	AS BEGIN
		SELECT YEAR(NgayDK) Nam,COUNT(*) SoLuong,MIN(NgayDK) DauTien,MAX(NgayDK) CuoiCung
		FROM NguoiHoc
		GROUP BY YEAR(NgayDK)
	END


	CREATE PROC sp_DoanhThu(@Year int)
	AS BEGIN
		SELECT tenCD ChuyenDe,COUNT(DISTINCT kh.MaKH) SoKH,COUNT(hv.MaHV) SoHV,SUM(kh.HocPhi) DoanhThu,MIN(kh.HocPhi) ThapNhat,
				MAX(kh.HocPhi) CaoNhat,AVG(kh.HocPhi) TrungBinh
		FROM KhoaHoc kh join HocVien hv on kh.MaKH=hv.MaKH
						join ChuyenDe cd on cd.MaCD=kh.MaCD
		WHERE YEAR(NgayKG) = @Year
		GROUP BY tenCD
	END

	select tenCD,COUNT(DISTINCT kh.MaKH) SoKH,SUM(kh.HocPhi) DoanhThu
	FROM KhoaHoc kh join HocVien hv on kh.MaKH=hv.MaKH
						join ChuyenDe cd on cd.MaCD=kh.MaCD
	WHERE YEAR(NgayKG) = 2022
		GROUP BY tenCD