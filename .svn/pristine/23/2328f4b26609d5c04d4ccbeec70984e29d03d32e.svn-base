package com.care.KorTravel.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class PageService {
	public static String getNavi(Model model, String url, int currentPage, int pageBlock, String totalCount1) {
		String result = "";
		int countPage = 10;
		int totalCount = Integer.parseInt(totalCount1);
		int totalPage = totalCount / pageBlock;
		if(totalCount % pageBlock > 0)
			totalPage++;
			
		if(totalPage<currentPage){
			currentPage = totalPage;
		}
		int startPage = ((currentPage-1)/countPage)*countPage+1;
		int endPage = startPage + countPage-1;
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		if(startPage>1) {
			result+=" "+"<a class='otherpage' href='"+url+"1'><<</a>";
		}
		if(currentPage>1) {
			result+=" "+"<a class='otherpage' href ='"+url + (currentPage-1)+"'><</a>";

		}
		for(int icount = startPage; icount<=endPage; icount++) {
			if(icount==currentPage) {
				result += " "+"<a class='cursor_box'>"+"&nbsp;&nbsp;" + icount + "&nbsp;&nbsp;"+"</a>"+" ";
			}else {
				result += " "+"<a class='otherpage' href='"+url + icount+"'> " + "&nbsp;&nbsp;" + icount + "&nbsp;&nbsp;" + " </a>"+" ";}
			}
	
	if(currentPage<totalPage) {
		result+=" "+"<a class='otherpage' href ='"+url + (currentPage+1)+"'>></a>";
	}
	if(endPage<totalPage) {
		result+=" "+"<a class='otherpage' href ='"+url + totalPage+"'>>></a>";

	}
		model.addAttribute("totalPage",totalPage);
		return result;
	}
}
