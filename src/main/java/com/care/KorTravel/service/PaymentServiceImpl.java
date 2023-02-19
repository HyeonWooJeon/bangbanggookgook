package com.care.KorTravel.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.KorTravel.dao.PaymentDAO;

@Service
public class PaymentServiceImpl implements IPaymentService {
	@Autowired private HttpSession session;
	@Autowired private PaymentDAO paymentDao;
	
	public String sessionCheck() {
		String id = (String)session.getAttribute("id");

		if(id == null || id.isEmpty()) {
			return "다시 로그인 해주세요"; 
		}
		return"";
	}
	/*public String emptyCheck(RouteDAO routeDao) {
		RouteDTO routeDto = routeDao.selectRoute(id);
		if(routeDto==null){
		return "선택 확인후 이용해주세요";
		}
	}
*/
}
