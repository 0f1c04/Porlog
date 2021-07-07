package com.kosta.finalProject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.finalProject.model.BlogDTO;
import com.kosta.finalProject.model.Item;
import com.kosta.finalProject.model.PostDTO;
import com.kosta.finalProject.service.BlogService;
import com.kosta.finalProject.service.PostService;

@RestController
@RequestMapping(value = "cart")
public class CartController {
	
	@Autowired
	PostService postService;
	@Autowired
	BlogService blogService;
	
	
	//같은 게시물 존재여부
	private int isExist(Long postID, HttpSession session) {
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getPost().getPostID().equals(postID)) {
                return i;
            }
        }
        return -1;
    }
    
	//cart에 없는 게시물 찾기
	public PostDTO findPost(Long postID, List<PostDTO> postlist) {
    	for(PostDTO post : postlist) {
    		if(post.getPostID().equals(postID)) {
    			return post;
    		}
    	}
    	return null;
    }
	
    
    @ResponseBody
    @GetMapping("buy/{postID}/{blogID}")
    public List<Item> buy(@PathVariable(value = "postID") Long postID, @PathVariable(value = "blogID")Long blogID, HttpSession session) {
    	BlogDTO blog = blogService.selectById(blogID);
    	List<PostDTO> postlist = postService.selectByBlog(blog);
    	//카트가 비어있을 경우
        if (session.getAttribute("cart") == null) {
            List<Item> cart = new ArrayList<Item>();
            System.out.println("찾은 post"+findPost(postID,postlist).getPostTitle());
            cart.add(new Item(findPost(postID,postlist), 1));
            session.setAttribute("cart", cart);

        } else { //비어있지 않은 경우
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = this.isExist(postID, session);
            if (index == -1) {
                cart.add(new Item(findPost(postID,postlist), 1));
            }
            session.setAttribute("cart", cart);         
        }
        
        return (List<Item>) session.getAttribute("cart");
    }
    
    
    
    
    
    
    @ResponseBody
    @GetMapping("delete/{postID}")
    public List<Item> delete(@PathVariable(value = "postID") Long postID, HttpSession session) {
    	System.out.println("들어온ID : " + postID);
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = isExist(postID, session);
        cart.remove(index);
        session.setAttribute("cart", cart);
        return (List<Item>) session.getAttribute("cart");
    }

}



