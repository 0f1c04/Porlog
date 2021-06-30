package com.kosta.finalProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.kosta.finalProject.model.BlogDTO;
import com.kosta.finalProject.model.ReplyDTO;
import com.kosta.finalProject.model.UserDTO;
import com.kosta.finalProject.repository.BlogRepository;
import com.kosta.finalProject.repository.LikeRepository;
import com.kosta.finalProject.repository.PostRepository;
import com.kosta.finalProject.repository.ReplyRepository;
import com.kosta.finalProject.repository.UserRepository;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest
class FinalProjectApplicationTests {

	@Autowired
	UserRepository repo;
	
	@Autowired
	PostRepository prepo;
	
	@Autowired
	BlogRepository brepo;
	
	@Autowired
	ReplyRepository rrepo;
	
	@Autowired
	LikeRepository lrepo;
	
	@Autowired
	MockMvc mockMvc;
	
	//@Test
	public void insertUser() {
		UserDTO user = new UserDTO();
		user.setUserID("테스트ID(2)");
		user.setUserPW("1234");
		user.setEmail("테스트Email");
		user.setNickname("테스트닉넴");
		user.setAuthLV(1);
		repo.save(user);
	}
	
	//@Test
	/*
	 * public void insertPost() { brepo.findById(1L).ifPresent(b-> { List<PostDTO>
	 * posts = b.getPostlist(); PostDTO post = new PostDTO();
	 * post.setPostTitle("KOSTA TEAM PROJECT"); post.setPostDate(new Date());
	 * post.setViewCnt(5); post.setBlog(b); posts.add(post); prepo.save(post); }); }
	 */
	
	//@Test
	public void insertBlog() {
		repo.findById("테스트ID").ifPresent(b->{
			BlogDTO blog = BlogDTO.builder()
					.blogTitle("폴로그팀의 블로그")
					.user(b)
					.build();
			brepo.save(blog);
		});
	}
	
	@Test
	public void insertReply() {
		prepo.findById(44L).ifPresent(b->{
			repo.findById("테스트ID").ifPresent(u->{
				ReplyDTO reply = ReplyDTO.builder()
						.replyUser(u)
						.post(b)
						.reply("잘부탁드립니다.")
						.build();
				rrepo.save(reply);
			});
		});
	}
	
	/*
	 * @Test public void testLike() throws Exception { PostDTO post = addPost();
	 * mockMvc.perform(post("/like/"+post.getPostID())).andExpect(status().isOK());
	 * 
	 * LikeDTO like = lrepo.findAll().get(0);
	 * 
	 * assertNotNull(like); }
	 */
}
