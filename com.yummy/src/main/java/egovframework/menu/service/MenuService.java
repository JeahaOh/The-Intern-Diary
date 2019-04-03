package egovframework.menu.service;

import java.util.List;
import egovframework.menu.vo.Menu;

/**
 * @Class Name  : MenuService.java
 * @Discription : MenuService Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.04.03 최초생성
 *
 * @author 제하
 * @since 2019. 04.03
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */
public interface MenuService {
  List<Menu> getMenuList(int rst_no) throws Exception;
}
