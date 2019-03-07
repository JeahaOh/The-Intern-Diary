package egovframework.catag.service;

import java.util.List;
import egovframework.catag.vo.Catag;

/**
 * @Class Name  : CatagService.java
 * @Discription : CatagService Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.06 최초생성
 *
 * @author 제하
 * @since 2019. 03.06
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */
public interface CatagService {
  
  /**
   * 모든 Catag List를 반환
   * @return
   * @throws Exception
   */
  List<Catag> getList() throws Exception;
  
  /**
   * 하위 catag에 대한 상위 catag List를 보내준다
   * @return catag List
   * @throws Exception
   */
  List<Catag> getRstUpperCatagList() throws Exception;
  
  /**
   * upper_no에 대한 하위 catag List를 보내준다
   * @param upper_no - catag의 부모 catag_no
   * @return catag List
   * @throws Exception
   */
  List<Catag> getRstLowerCatagList(int upper_no) throws Exception;
}
