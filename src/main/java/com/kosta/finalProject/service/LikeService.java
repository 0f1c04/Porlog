package com.kosta.finalProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kosta.finalProject.model.LikeDTO;
import com.kosta.finalProject.model.PostDTO;
import com.kosta.finalProject.model.UserDTO;
import com.kosta.finalProject.repository.LikeRepository;
import com.kosta.finalProject.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class LikeService {
	@Autowired
	LikeRepository lrepo;
	@Autowired
	PostRepository prepo;
	
	public boolean addLike(UserDTO user, Long postID) {
        PostDTO post = prepo.findById(postID).orElseThrow();

        //중복 좋아요 방지
        if(isNotAlreadyLike(user, post)) {
            lrepo.save(new LikeDTO(post, user));
            return true;
        }
        return false;
    }

    //사용자가 이미 좋아요 한 게시물인지 체크
    private boolean isNotAlreadyLike(UserDTO user, PostDTO post) {
        return lrepo.findByUserAndPost(user, post).isEmpty();
    }
	
}
