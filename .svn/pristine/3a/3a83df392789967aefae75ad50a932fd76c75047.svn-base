package com.care.KorTravel.dao;

import java.util.ArrayList;
import java.util.HashMap;


import org.apache.ibatis.annotations.Mapper;

import com.care.KorTravel.dto.Commun_commentDTO;
import com.care.KorTravel.dto.CommunityDTO;




@Mapper
public interface CommunityDAO {
	
	public void hitIncrease(int num) ;


	public String communityCount(HashMap<String, Object> map);


	public ArrayList<CommunityDTO> communityProc(int begin, int end, String select, String search);


	public CommunityDTO communityDetail(int num);


	public CommunityDTO movePage(int num1);


	public int community_write(CommunityDTO communityDto);



	public int getSequence();


	public void saveComment(Commun_commentDTO commentDTO);


	public ArrayList<Commun_commentDTO> getComment(int num);


	public int countComment(int num);


	public void insertReply(Commun_commentDTO commentDTO);


	public void updateReply(Commun_commentDTO commentDTO);


	public void ReplyDelete(String replyNo);


	public Commun_commentDTO selectReplyParent(String reparent);


	public void updateReplyOrder(Commun_commentDTO replyInfo);


	public int selectMaxOrder(String writeNo);


	public ArrayList<CommunityDTO> myLog(int begin, int end,String id);
	public String myLogCount(String id);

	public CommunityDTO edit(String num);


	public int community_edit(CommunityDTO dto);


	public int my_write_delete(int num);


	public void commentCount(Commun_commentDTO commentDTO);


	public String last_insert_num();


	public void insertReorder(String reorder);


	public Commun_commentDTO getCommentAll(String string);


	public void insertReorder2(String string, String reorder2);


	public void commentCountDelete(String writeNo);

}
