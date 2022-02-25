/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewDao;

import Helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ThongKeDao {
    private List<Object[]> getListOfArray(String sql,String[] cols,Object...args)throws Exception{
            List<Object[]> list= new ArrayList<>();
            ResultSet rs = JdbcHelper.query(sql, args);
            while(rs.next()){
                Object[] vals = new Object[cols.length];
                for(int i=0;i<cols.length;i++){
                    vals[i]=rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
    }
    public List<Object[]> getBangDiem(int maKH)throws Exception{
        String sql = "{CALL sp_BangDiem(?)}";
        String[] cols= {"MaNH","HoTen","Diem"};
        return this.getListOfArray(sql, cols, maKH);
    }
    public List<Object[]> getLuongNguoiHoc()throws Exception{
        String sql = "{CALL sp_LuongNguoiHoc}";
        String[] cols= {"Nam","SoLuong","DauTien","CuoiCung"};
        return this.getListOfArray(sql, cols);
    }
    public List<Object[]> getDiemChuyenDe()throws Exception{
        String sql = "{CALL sp_DiemChuyenDe}";
         String[] cols= {"ChuyenDe","soHV","ThapNhat","CaoNhat","TrungBinh"};
        return this.getListOfArray(sql, cols);
    }
    public List<Object[]> getDoanhThu(int nam)throws Exception{
        String sql = "{CALL sp_DoanhThu(?)}";
       String[] cols= {"ChuyenDe","SoKH","SoHV","DoanhThu","ThapNhat","CaoNhat","TrungBinh"};
        return this.getListOfArray(sql, cols,nam);
    }
}
