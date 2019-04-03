package egovframework.menu.web;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import egovframework.menu.service.MenuService;

/**
 * @Class Name  : MenuController.java
 * @Discription : Menu Controller Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.04.03 최초생성
 *
 * @author 제하
 * @since 2019. 04.03
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
  private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
  
  @Resource(name="menuService")
  private MenuService menuService;

}
