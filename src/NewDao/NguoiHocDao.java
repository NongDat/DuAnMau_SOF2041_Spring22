/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewDao;

import Helper.JdbcHelper;
import Helper.XDate;
import Models.NguoiHoc;
import NewInterface.NguoiHocInterface;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NguoiHocDao implements NguoiHocInterface {

    private List<NguoiHoc> list;
    String insert_SQL = "INSERT INTO NguoiHoc(MaNH,HoTen,NgaySinh,GioiTinh,DienThoai,Email,GhiChu,MaNV,NgayDK) VALUES(?,?,?,?,?,?,?,?,?)";
    String update_SQL = "UPDATE NguoiHoc SET HoTen=?,NgaySinh=?,GioiTinh=?,DienThoai=?,Email=?,GhiChu=?,MaNV=?,NgayDK=? WHERE MaNH=?";
    String delete_SQL = "DELETE FROM NguoiHoc WHERE MaNH=?";
    String selectById_SQL = "SELECT * FROM NguoiHoc WHERE MANH = ?";
    String selectAll_SQL = "select * from NguoiHoc";
    String selectByKeyWord_SQL = "SELECT * FROM NguoiHoc WHERE HoTen LIKE ?";
    String selectNotInCourse ="SELECT * FROM NguoiHoc WHERE HoTen LIKE ? AND MaNH NOT IN(SELECT MaNH FROM HocVien WHERE MaKH = ?)";
    
    public NguoiHocDao() {
        this.list = new ArrayList<>();
    }
    
    @Override
    public void insert(NguoiHoc nh) throws Exception {
        JdbcHelper.update(insert_SQL,new Object[]{ nh.getMaNH(), nh.getHoTen(), XDate.toString(nh.getNgaySinh(), "MM/dd/yyyy"), nh.isGioiTinh(), nh.getDienThoai(), nh.getEmail(),
                nh.getGhiChu(), nh.getMaNV(),XDate.toString(nh.getNgayDK(), "MM/dd/yyyy")});
    }

    @Override
    public void update(NguoiHoc nh) throws Exception {
        JdbcHelper.update(update_SQL, nh.getHoTen(), XDate.toString(nh.getNgaySinh(), "MM/dd/yyyy"), nh.isGioiTinh(), nh.getDienThoai(), nh.getEmail(),
                nh.getGhiChu(), nh.getMaNV(), XDate.toString(nh.getNgayDK(), "MM/dd/yyyy"), nh.getMaNH());
    }

    @Override
    public void delete(String maNH) throws Exception {
        JdbcHelper.update(delete_SQL, maNH);
    }

    @Override
    public NguoiHoc selectByID(String maNH) throws Exception {
        this.list.removeAll(list);
        ResultSet rs = JdbcHelper.query(selectById_SQL, maNH);
        while (rs.next()) {
            NguoiHoc nh = new NguoiHoc();
            nh.setMaNH(rs.getString("MaNH"));
            nh.setHoTen(rs.getString("HoTen"));
            nh.setNgaySinh(rs.getDate("NgaySinh"));
            nh.setGioiTinh(rs.getBoolean("GioiTinh"));
            nh.setDienThoai(rs.getString("DienThoai"));
            nh.setEmail(rs.getString("Email"));
            nh.setGhiChu(rs.getString("GhiChu"));
            nh.setMaNV(rs.getString("MaNV"));
            nh.setNgayDK(rs.getDate("NgayDK"));
            this.list.add(nh);
        }
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NguoiHoc> getList() throws Exception {
        this.list.removeAll(list);
        ResultSet rs = JdbcHelper.query(selectAll_SQL);
        while (rs.next()) {
            NguoiHoc nh = new NguoiHoc();
            nh.setMaNH(rs.getString("MaNH"));
            nh.setHoTen(rs.getString("HoTen"));
            nh.setNgaySinh(rs.getDate("NgaySinh"));
            nh.setGioiTinh(rs.getBoolean("GioiTinh"));
            nh.setDienThoai(rs.getString("DienThoai"));
            nh.setEmail(rs.getString("Email"));
            nh.setGhiChu(rs.getString("GhiChu"));
            nh.setMaNV(rs.getString("MaNV"));
            nh.setNgayDK(rs.getDate("NgayDK"));
            this.list.add(nh);
        }
        if (list.isEmpty()) {
            return null;
        }
        rs.getStatement().getConnection().close();
        return list;
    }

    @Override
    public List<NguoiHoc> selectByKeyWord(String keyWord) throws Exception {
        this.list.removeAll(list);
        ResultSet rs = JdbcHelper.query(selectByKeyWord_SQL,
                "%" + keyWord + "%");
        while (rs.next()) {
            NguoiHoc nh = new NguoiHoc();
            nh.setMaNH(rs.getString("MaNH"));
            nh.setHoTen(rs.getString("HoTen"));
            nh.setNgaySinh(rs.getDate("NgaySinh"));
            nh.setGioiTinh(rs.getBoolean("GioiTinh"));
            nh.setDienThoai(rs.getString("DienThoai"));
            nh.setEmail(rs.getString("Email"));
            nh.setGhiChu(rs.getString("GhiChu"));
            nh.setMaNV(rs.getString("MaNV"));
            nh.setNgayDK(rs.getDate("NgayDK"));
            this.list.add(nh);
        }
//        if (list.isEmpty()) {
//            return null;
//        }
        return list;
    }

    @Override
    public List<NguoiHoc> selectNotinCourse(int maKH, String hoTen) throws Exception {
        this.list.removeAll(list);
        ResultSet rs =JdbcHelper.query(selectNotInCourse, "%"+hoTen+"%",maKH);
       while(rs.next()){
           NguoiHoc nh = new NguoiHoc();
           nh.setMaNH(rs.getString("MaNH"));
           nh.setHoTen(rs.getString("HoTen"));
           nh.setNgaySinh(rs.getDate("NgaySinh"));
           nh.setGioiTinh(rs.getBoolean("GioiTinh"));
           nh.setDienThoai(rs.getString("DienThoai"));
           nh.setEmail(rs.getString("Email"));
           nh.setGhiChu(rs.getString("GhiChu"));
           nh.setMaNV(rs.getString("MaNV"));
           nh.setNgayDK(rs.getDate("NgayDK"));
           this.list.add(nh);
       }
        rs.getStatement().getConnection().close();
        return list;
    }

}
