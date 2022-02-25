/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewInterface;

import Models.KhoaHoc;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface KhoaHocInterface {
    void insert(KhoaHoc kh)throws Exception;
    void update(KhoaHoc kh)throws Exception;
    void delete(int maKH)throws Exception;
    List<KhoaHoc> getList()throws Exception;
    KhoaHoc selectById(int maKH)throws Exception;
    List<KhoaHoc> selectByChuyenDe(String maCD)throws Exception;
    List<Integer> selectYears()throws Exception;
}
