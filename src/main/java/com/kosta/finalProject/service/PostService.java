package com.kosta.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.finalProject.model.BlogDTO;
import com.kosta.finalProject.model.PostDTO;
import com.kosta.finalProject.repository.BlogRepository;
import com.kosta.finalProject.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository repo;
	
	@Autowired
	BlogRepository repoB;

	// 조회
	public List<PostDTO> selectByBlog(BlogDTO blog) {
		return repo.findByBlog(blog);
	}
	
	//조회수증가
	public int HitCount(Long postID) {
		return repo.HitViewCount(postID);
	}
	
	// 좋아요 증가
	public int LikeUp(Long postID) {
		return repo.HitLikeUp(postID);
	}

	// 좋아요 감소
	public int LikeDown(Long postID) {
		return repo.HitLikeDown(postID);
	}
	
	public PostDTO selectByPostId(Long postID) {
		return repo.findById(postID).get();
	}
	
	// 입력
	public PostDTO insertPost(PostDTO post, Long blogID) {
		BlogDTO blog = repoB.findById(blogID).get();
		post.setBlog(blog);
		return repo.save(post);
	}
	
	// 삭제
	public int deletePost(Long postID) {
		int result = 0;
		try {
			repo.deleteById(postID);
			result = 1;
		} catch(Exception ex) {
			
		}
		return result;
	}
}
