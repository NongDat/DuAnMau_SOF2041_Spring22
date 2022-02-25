/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewDao;

import Helper.JdbcHelper;
import Models.HocVien;
import NewInterface.HocVienInterface;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HocVienDao implements HocVienInterface {

    private List<HocVien> list;
    String insert_sql = "INSERT INTO HocVien(MaKH,MaNH,Diem)VALUES (?,?,?)";
    String update_sql = "UPDATE HocVien SET Diem=? WHERE MaHV=?";
    String delete_sql = "DELETE FROM HocVien WHERE MaHV=?";
    String selectByID_sql = "SELECT * FROM HocVien WHERE MaHV=?";
    String selectAll_sql = "SELECT * FROM HocVien";
    String selectByKhoaHoc_sql = "SELECT * FROM HocVien WHERE MaKH=?";

    public HocVienDao() {
        this.list = new ArrayList<>();
    }

    @Override
    public void insert(HocVien hv) throws Exception {
        JdbcHelper.update(insert_sql, hv.getMaKH(), hv.getMaNH(),hv.getDiem());
    }

    @Override
    public void update(HocVien hv) throws Exception {
        JdbcHelper.update(update_sql, hv.getDiem(), hv.getMaHV());
    }

    @Override
    public void delete(int maHV) throws Exception {
        JdbcHelper.update(delete_sql, maHV);
    }

    @Override
    public HocVien selectById(int maHV) throws Exception {
        this.list.removeAll(list);
        ResultSet rs = JdbcHelper.query(selectByID_sql, maHV);
        while (rs.next()) {
            HocVien hv = new HocVien();
            hv.setMaHV(rs.getInt("MaHV"));
            hv.setMaKH(rs.getInt("MaKH"));
            hv.setMaNH(rs.getString("MaNH"));
            hv.setDiem(rs.getDouble("Diem"));
            this.list.add(hv);
        }
        //rs.getStatement().getConnection().close();
        return this.list.get(0);
    }

    @Override
    public List<HocVien> getList() throws Exception {
        this.list.removeAll(list);
        ResultSet rs = JdbcHelper.query(selectAll_sql);
        while (rs.next()) {
            HocVien hv = new HocVien();
            hv.setMaHV(rs.getInt("MaHV"));
            hv.setMaKH(rs.getInt("MaKH"));
            hv.setMaNH(rs.getString("MaNH"));
            hv.setDiem(rs.getDouble("Diem"));
            this.list.add(hv);
        }
      //  rs.getStatement().getConnection().close();
        return this.list;
    }

    @Override
    public List<HocVien> selectByKhoaHoc(int maKH) throws Exception {
        this.list.removeAll(list);
        ResultSet rs = JdbcHelper.query(selectByKhoaHoc_sql, maKH);
        while (rs.next()) {
            HocVien hv = new HocVien();
            hv.setMaHV(rs.getInt("MaHV"));
            hv.setMaKH(rs.getInt("MaKH"));
            hv.setMaNH(rs.getString("MaNH"));
            hv.setDiem(rs.getDouble("Diem"));
            this.list.add(hv);
        }
       // rs.getStatement().getConnection().close();
        return this.list;
    }

}
