package egovframework.menu.DAO;

import java.util.List;
import egovframework.menu.vo.Menu;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * menu에 대한 데이터 처리 mapper 클래스
 * 
 * @Class Name  : MenuDAO.java
 * @Discription : MenuDAO Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.04.03 최초생성
 *
 * @author 제하
 * @since 2019. 04.03
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */
@Mapper("menuDao")
public interface MenuDAO {
  
  List<Menu> getMenuList(int rst_no) throws Exception;
}
