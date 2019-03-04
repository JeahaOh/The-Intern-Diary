package egovframework.rst.service;

import java.util.List;
import egovframework.rst.vo.Rst;

/**
 * @Class Name  : RstService.java
 * @Discription : RstService Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.04 최초생성
 *
 * @author 제하
 * @since 2019. 03.04
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */

public interface RstService {
  /**
   * 관리자 로그인을 한다.
   * 
   * @param id  - 회원의 id
   * @param pwd - 회원의 pwd
   * @return  로그인 한 회원
   * @throws Exception
   */
  List<Rst> getList() throws Exception;

}
