package egovframework.rater.web;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import egovframework.rater.service.RaterService;
import egovframework.rater.vo.Rater;

/**
 * @Class Name  : RaterController.java
 * @Discription : RaterController Class
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2019.03.12 최초생성
 *
 * @author 제하
 * @since 2019. 03.12
 * @version 1.0
 * @see
 *
 *      Copyright (C) by JeahaOh All right reserved.
 */
@Controller
@RequestMapping("/rater")
public class RaterController {
  
  private static final Logger logger = LoggerFactory.getLogger(RaterController.class);
  
  @Resource(name = "raterService")
  private RaterService raterService;
  
  /**
   * rst_no에 해당하는 식당에 대한
   * 리뷰의 수와 평점의 합을 베이지안 확률과 평균에 대입하여
   * 평점을 구해 rater를 return함.
   * @param rst_no
   * @return
   * @throws Exception
   */
  @SuppressWarnings("null")
  @ResponseBody
  @RequestMapping(value = "/getRate", method = RequestMethod.POST)
  public Rater getRate(
      @RequestParam (value = "rst_no") int rst_no
        ) throws Exception {
    logger.debug("\n\t/rater/getRate recieve rst_no : {}\n", rst_no);
    Rater rater = raterService.getRate(rst_no);
    if( rater != null) {
      logger.debug("\n\t/rater/getRate return RATE : {}\n", rater.toString());
      return rater;
    }
    logger.debug("\n\t/rater/getRate return null RATE : {}\n", rater.toString());
    return new Rater();
  }
  
}
