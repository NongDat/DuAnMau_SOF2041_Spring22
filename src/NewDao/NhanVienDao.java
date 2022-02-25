/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewDao;

import Helper.JdbcHelper;
import Models.NhanVien;
import NewInterface.NhanVienInterface;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienDao implements NhanVienInterface {

    String insert_SQL = "insert into NhanVien(MaNV,MatKhau,HoTen,VaiTro) values(?,?,?,?)";
    String update_SQL = "update NhanVien set MatKhau=?, HoTen=?,VaiTro=? where MaNV=?";
    String delete_SQL = "delete from NhanVien where MaNV=?";
    String selectAll_SQL = "select * From NhanVien";
    String selectByID_SQL = "select * from NhanVien where MaNV = ?";
    private List<NhanVien> list;

    public NhanVienDao() {
        this.list = new ArrayList();
    }

    @Override
    public void insert(NhanVien nv) throws Exception {
        JdbcHelper.update(insert_SQL, nv.getMaNV(), nv.getMatKhau(), nv.getHoTen(), nv.getVaiTro());
    }

    @Override
    public void update(NhanVien nv) throws Exception {
        JdbcHelper.update(update_SQL,  nv.getMatKhau(),nv.getHoTen(), nv.getVaiTro(), nv.getMaNV());
    }

    @Override
    public void delete(String maNV) throws Exception {
        JdbcHelper.update(delete_SQL, maNV);
    }

    @Override
    public NhanVien selectById(String maNV) throws Exception {
        try {
            ResultSet rs = JdbcHelper.query(selectByID_SQL, maNV);
            list.removeAll(list);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setVaiTro(rs.getBoolean("VaiTro"));
                list.add(nv);
            }
            rs.getStatement().getConnection().close();
            return list.get(0);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<NhanVien> getList() throws Exception {
        list.removeAll(list);
        ResultSet rs = JdbcHelper.query(selectAll_SQL);
        while(rs.next()){
            NhanVien nv = new NhanVien();
            nv.setMaNV(rs.getString("MaNV"));
            nv.setMatKhau(rs.getString("MatKhau"));
            nv.setHoTen(rs.getString("HoTen"));
            nv.setVaiTro(rs.getBoolean("VaiTro"));
            list.add(nv);
        }
        rs.getStatement().getConnection().close();
        return list;
    }

}
