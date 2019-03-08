package egovframework.rvw.service;

import java.util.List;
import egovframework.rvw.vo.Rvw;

/**
 * @Class Name  : RvwService.java
 * @Discription : RvwService Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.07 최초생성
 *
 * @author 제하
 * @since 2019. 03.07
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */

public interface RvwService {
  Boolean save(Rvw rvw) throws Exception;
  List<Rvw> getRvwList(int rst_no) throws Exception;
}
