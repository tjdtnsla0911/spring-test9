package com.aruerue.shop.controller.myController;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aruerue.shop.controller.dto.CommonRespDto;
import com.aruerue.shop.controller.dto.ShopRespDto;
import com.aruerue.shop.controller.dto.notice.NoticeDetailsRespDto;
import com.aruerue.shop.controller.dto.notice.NoticeRespDto;
import com.aruerue.shop.controller.dto.qnA.CommentOnQnARespDto;
import com.aruerue.shop.controller.dto.qnA.QnARespDto;
import com.aruerue.shop.controller.dto.review.ReviewDetailRespDto;
import com.aruerue.shop.controller.dto.review.ReviewRespDto;
import com.aruerue.shop.model.qnA.Qna;
import com.aruerue.shop.model.review.Review;
import com.aruerue.shop.repository.Repository;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@Profile("moon")
public class QnAController {
	private final Repository repository;

	@GetMapping("/qna")
	public List<QnARespDto> qna() {
		List<QnARespDto> qnARespDto = repository.findQnAs();
		return qnARespDto;
	}

	@GetMapping("/qna_detail/{id}")
	public CommentOnQnARespDto qnaDetail(@PathVariable int id) {
		CommentOnQnARespDto mypageQnaDetailRespDto = repository.findQnADetailById(id);
		return mypageQnaDetailRespDto;
	}

	//insert
	@PostMapping("/qna")
	public CommonRespDto<?> saveQnA(@RequestBody Qna qna){
		System.out.println("review : "+qna);
		repository.saveQnA(qna);
		return new CommonRespDto<String>();
	}

	//update
		@PutMapping("/qna")
		public CommonRespDto<?> updateReview(@RequestBody Qna qna){
			System.out.println("qna : "+qna);
			repository.updateQna(qna);
			return new CommonRespDto<String>();
		}

	//delete
	@DeleteMapping("/qna/{id}")
	public CommonRespDto<?> deleteQna(@PathVariable int id){
		System.out.println(" id : "+ id);
		repository.deleteQna(id);
		return new CommonRespDto<String>();
	}



}
