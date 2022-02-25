/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewInterface;

import Models.NhanVien;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface NhanVienInterface {
    public void insert(NhanVien nv) throws Exception;
    public void update(NhanVien nv) throws Exception;
    public void delete(String maNV) throws Exception;
    public NhanVien selectById(String maNV) throws Exception;
    public List<NhanVien> getList()  throws Exception;
}
