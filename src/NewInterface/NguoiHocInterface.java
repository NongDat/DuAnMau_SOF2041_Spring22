/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewInterface;

import Models.NguoiHoc;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface NguoiHocInterface {
    public void insert(NguoiHoc nh)throws Exception;
    public void update(NguoiHoc nh)throws Exception;
    public void delete(String maNH)throws Exception;
    public NguoiHoc selectByID(String maNH)throws Exception;
    public List<NguoiHoc> getList()throws Exception;
    public List<NguoiHoc> selectByKeyWord(String keyWord)throws Exception;
    List<NguoiHoc> selectNotinCourse(int maKH,String hoTen)throws Exception;
}
