/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewDao;

import Helper.JdbcHelper;
import Helper.XDate;
import Models.KhoaHoc;
import NewInterface.KhoaHocInterface;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhoaHocDao implements KhoaHocInterface{
    private List<KhoaHoc> list;
    String insert_SQL = "INSERT INTO KhoaHoc(MaCD,HocPhi,ThoiLuong,NgayKG,GhiChu,MaNV,NgayTao) VALUES(?,?,?,?,?,?,?)";
    String update_SQL = "UPDATE KhoaHoc SET NgayKG=?,GhiChu=? where MaKH=?";
    String delete_SQL = "DELETE FROM KhoaHoc WHERE MaKH=?";
    String selectAll_SQL = "SELECT * FROM KhoaHoc";
    String selectById_SQL = "SELECT * FROM KhoaHoc where MaKH =?";
    String selectMaChuyenDe_SQL = "SELECT * FROM KhoaHoc where MaCD =?";
    String selectYears = "select DISTINCT YEAR(NgayKG) YEAR from KhoaHoc order by YEAR desc";
    public KhoaHocDao() {
        this.list = new ArrayList<>();
    }

    @Override
    public void insert(KhoaHoc kh) throws Exception {
        JdbcHelper.update(insert_SQL,kh.getMaCD(),kh.getHocPhi(),kh.getThoiLuong(),XDate.toString(kh.getNgayKG(), "MM/dd/yyyy"),kh.getGhiChu(),kh.getMaNV(),XDate.toString(kh.getNgayTao(), "MM/dd/yyyy"));
    }

    @Override
    public void update(KhoaHoc kh) throws Exception {
        JdbcHelper.update(update_SQL, XDate.toString(kh.getNgayKG(), "MM/dd/yyyy"),kh.getGhiChu(),kh.getMaKH());
    }

    @Override
    public void delete(int maKH) throws Exception {
        JdbcHelper.update(delete_SQL, maKH);
    }

    @Override
    public List<KhoaHoc> getList() throws Exception {
        this.list.removeAll(list);
        ResultSet rs = JdbcHelper.query(selectAll_SQL);
        while(rs.next()){
            KhoaHoc kh = new KhoaHoc();
            kh.setMaKH(rs.getInt("maKH"));
            kh.setMaCD(rs.getString("MaCD"));
            kh.setHocPhi(rs.getDouble("HocPhi"));
            kh.setThoiLuong(rs.getInt("ThoiLuong"));
            kh.setNgayKG(rs.getDate("NgayKG"));
            kh.setGhiChu(rs.getString("GhiChu"));
            kh.setMaNV(rs.getString("MaNV"));
            kh.setNgayTao(rs.getDate("NgayTao"));
            this.list.add(kh);
        }
        return this.list;
    }

    @Override
    public KhoaHoc selectById(int maKH) throws Exception {
        this.list.removeAll(list);
        ResultSet rs = JdbcHelper.query(selectById_SQL, maKH);
        while(rs.next()){
            KhoaHoc kh = new KhoaHoc();
            kh.setMaKH(rs.getInt("maKH"));
            kh.setMaCD(rs.getString("MaCD"));
            kh.setHocPhi(rs.getDouble("HocPhi"));
            kh.setThoiLuong(rs.getInt("ThoiLuong"));
            kh.setNgayKG(rs.getDate("NgayKG"));
            kh.setGhiChu(rs.getString("GhiChu"));
            kh.setMaNV(rs.getString("MaNV"));
            kh.setNgayTao(rs.getDate("NgayTao"));
            this.list.add(kh);
        }
        return this.list.get(0);
    }

    @Override
    public List<KhoaHoc> selectByChuyenDe(String maCD) throws Exception {
        this.list.removeAll(list);
        ResultSet rs = JdbcHelper.query(selectMaChuyenDe_SQL,maCD);
        while(rs.next()){
            KhoaHoc kh = new KhoaHoc();
            kh.setMaKH(rs.getInt("maKH"));
            kh.setMaCD(rs.getString("MaCD"));
            kh.setHocPhi(rs.getDouble("HocPhi"));
            kh.setThoiLuong(rs.getInt("ThoiLuong"));
            kh.setNgayKG(rs.getDate("NgayKG"));
            kh.setGhiChu(rs.getString("GhiChu"));
            kh.setMaNV(rs.getString("MaNV"));
            kh.setNgayTao(rs.getDate("NgayTao"));
            this.list.add(kh);
        }
        return this.list;
    }

    @Override
    public List<Integer> selectYears() throws Exception {
        List<Integer> list = new ArrayList<>();
        ResultSet rs = JdbcHelper.query(selectYears);
        while(rs.next()){
            list.add(rs.getInt(1));
        }
        rs.getStatement().getConnection().close();
        return list;
    }
    
}
