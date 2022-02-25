Create database EduSys
go
use EduSys
go
Create table NhanVien
(
	MaNV nvarchar(50) not null primary key,
	MatKhau nvarchar(50) not null,
	HoTen nvarchar(50) not null,
	VaiTro BIT not null
)
go
Create table ChuyenDe
(
	MaCD nvarchar(5) not null primary key,
	tenCD nvarchar(50) not null,
	HocPhi float not null,
	ThoiLuong int not null,
	Hinh nvarchar(50) not null,
	MoTa nvarchar(255) not null,
)
go
Create table KhoaHoc
(
	MaKH int identity(1,1)not null primary key,
	MaCD nvarchar(5) not null foreign key references ChuyenDe(MaCD) ON DELETE NO ACTION ON UPDATE CASCADE,
	HocPhi float not null,
	ThoiLuong int not null,
	NgayKG date not null,
	GhiChu nvarchar(50) not null,
	MaNV nvarchar(50) not null foreign key references NhanVien(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE,
	NgayTao date not null
)
go
Create table NguoiHoc
(
	MaNH nchar(7)not null primary key,
	HoTen nvarchar(50) not null,
	NgaySinh date not null,
	GioiTinh BIT not null,
	DienThoai varchar(15) not null,
	Email nvarchar(50) not null,
	GhiChu nvarchar(max) not null,
	MaNV nvarchar(50) not null foreign key references NhanVien(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE,
	NgayDK date not null
)
go
Create table HocVien
(
	MaHV int identity(1,1)not null primary key,
	MaKH int not null,
	MaNH nchar(7)not null,
	Diem float not null,
	foreign key(MaNH) references NguoiHoc(MaNH) On DELETE NO ACTION ON UPDATE CASCADE,
	foreign key(MaKH) references KhoaHoc(MaKH) ON DELETE CASCADE ON UPDATE NO ACTION
)
go
drop table HocVien
select * from NguoiHoc
select * from ChuyenDe
select * from KhoaHoc
select * from NhanVien
select * from HocVien
