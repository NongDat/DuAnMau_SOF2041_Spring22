/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewDao;

import Helper.JdbcHelper;
import Models.ChuyenDe;
import NewInterface.ChuyenDeInterface;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ChuyenDeDao implements ChuyenDeInterface{
    private List<ChuyenDe> list;
    String insert_SQL = "INSERT INTO ChuyenDe(MaCD,tenCD,HocPhi,ThoiLuong,Hinh,MoTa) values(?,?,?,?,?,?)";
    String update_SQL = "UPDATE ChuyenDe set tenCD=?,HocPhi=?,ThoiLuong=?,Hinh=?,MoTa=? WHERE MaCD=?";
    String delete_SQL = "DELETE FROM ChuyenDe WHERE MaCD=?";
    String selectAll_SQL = "select * from ChuyenDe";
    String selectBy_ID_SQL = "SELECT * FROM ChuyenDe WHERE MaCD=?";
    public ChuyenDeDao(){
        this.list = new ArrayList<>();
    }

    @Override
    public void insert(ChuyenDe cd) throws RuntimeException { 
        JdbcHelper.update(insert_SQL, cd.getMaCD(),cd.getTenCD(),cd.getHocPhi(),cd.getThoiLuong(),cd.getHinh(),cd.getMoTa());
    }

    @Override
    public void update(ChuyenDe cd) throws RuntimeException {
        JdbcHelper.update(update_SQL,cd.getTenCD(),cd.getHocPhi(),cd.getThoiLuong(),cd.getHinh(),cd.getMoTa(), cd.getMaCD());
    }

    @Override
    public void delete(String maCD) throws RuntimeException {
        JdbcHelper.update(delete_SQL, maCD);
    }

    @Override
    public ChuyenDe selectByID(String maCD) throws RuntimeException {
        try {
            list.removeAll(list);
            ResultSet rs = JdbcHelper.query(selectBy_ID_SQL, maCD);
            while(rs.next()){
                ChuyenDe cd = new ChuyenDe();
                cd.setMaCD(rs.getString("MaCD"));
                cd.setTenCD(rs.getString("tenCD"));
                cd.setHocPhi(rs.getFloat("HocPhi"));
                cd.setThoiLuong(rs.getInt("ThoiLuong"));
                cd.setHinh(rs.getString("Hinh"));
                cd.setMoTa(rs.getString("MoTa"));
                list.add(cd);
            }
            rs.getStatement().getConnection().close();
            return list.get(0);
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<ChuyenDe> getList() throws RuntimeException {
        try {
            list.removeAll(list);
            ResultSet rs = JdbcHelper.query(selectAll_SQL);
            while(rs.next()){
                ChuyenDe cd = new ChuyenDe();
                cd.setMaCD(rs.getString("MaCD"));
                cd.setTenCD(rs.getString("tenCD"));
                cd.setHocPhi(rs.getFloat("HocPhi"));
                cd.setThoiLuong(rs.getInt("ThoiLuong"));
                cd.setHinh(rs.getString("Hinh"));
                cd.setMoTa(rs.getString("MoTa"));
                list.add(cd);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
    
}
