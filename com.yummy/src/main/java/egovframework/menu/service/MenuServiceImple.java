package egovframework.menu.service;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import egovframework.menu.DAO.MenuDAO;

/**
 * @Class Name  : MenuServiceImple.java
 * @Discription : MembService Implement Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.04.03 최초생성
 *
 * @author 제하
 * @since 2019. 04.03
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */
@Service("menuService")
@Component
public class MenuServiceImple implements MenuService {
  
  private static final Logger logger = LoggerFactory.getLogger(MenuServiceImple.class);
  
  @Resource(name="menuDao")
  private MenuDAO menuDao;
  
}
