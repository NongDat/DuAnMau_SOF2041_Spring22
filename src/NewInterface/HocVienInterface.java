/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewInterface;

import Models.HocVien;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface HocVienInterface {
    void insert(HocVien hv)throws Exception;
    void update(HocVien hv)throws Exception;
    void delete(int maHV)throws Exception;
    HocVien selectById(int maHV)throws Exception;
    List<HocVien> getList()throws Exception;
    List<HocVien> selectByKhoaHoc(int maKH)throws Exception;
}
