/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewInterface;

import Models.ChuyenDe;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ChuyenDeInterface {
    public void insert(ChuyenDe cd) throws Exception;
    public void update(ChuyenDe cd) throws Exception;
    public void delete(String maCD) throws Exception;
    public ChuyenDe selectByID(String maCD) throws Exception;
    public List<ChuyenDe> getList() throws Exception;
}
