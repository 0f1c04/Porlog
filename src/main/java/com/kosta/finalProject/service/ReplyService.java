package com.kosta.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.finalProject.model.PostDTO;
import com.kosta.finalProject.model.ReplyDTO;
import com.kosta.finalProject.repository.ReplyRepository;

@Service
public class ReplyService {
	
	@Autowired
	ReplyRepository repo;
	
	// 댓글전체조회
	public List<ReplyDTO> selectAll(PostDTO post) {
		return (List<ReplyDTO>)repo.findByPost(post);
	}
	
	// 댓글상세보기
	public ReplyDTO selectByNo(Long replyNO) {
		return repo.findById(replyNO).get();
	}
	
	// 댓글입력
	public ReplyDTO insertReply(ReplyDTO reply) {
		return repo.save(reply);
	}
	
	// 댓글수정
	public ReplyDTO updateReply(ReplyDTO reply) {
		return repo.save(reply);
	}
	
	// 댓글삭제
	public int deleteReply(Long replyNO) {
		int result = 0;
		try {
			repo.deleteById(replyNO);
		} catch (Exception e) {
			
		}
		return result;
	}
}
