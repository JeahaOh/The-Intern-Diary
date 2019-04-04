package egovframework.menu.web;

import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import egovframework.menu.service.MenuService;
import egovframework.menu.vo.Menu;

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
  
  @ResponseBody
  @RequestMapping(value="/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public List<Menu> getMenuList(int rst_no) throws Exception {
    logger.info("\n\t/menu/mnLst rst_no : {}", rst_no);
    List<Menu> list = menuService.getMenuList(rst_no);
    logger.info("\n\t/menu/mnList return \n{}", list.toString() );
    return list;
  }

}
