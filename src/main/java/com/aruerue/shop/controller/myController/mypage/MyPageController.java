package com.aruerue.shop.controller.myController.mypage;




import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aruerue.shop.controller.dto.CommonRespDto;
import com.aruerue.shop.controller.dto.mypage.MypageCancleRespDto;
import com.aruerue.shop.controller.dto.mypage.MypageCouponRespDto;
import com.aruerue.shop.controller.dto.mypage.MypageOrdersResponseDto;
import com.aruerue.shop.controller.dto.mypage.MypagePointRespDto;
import com.aruerue.shop.controller.dto.mypage.MypageUpdateRespDto;
import com.aruerue.shop.repository.MyPageRepository;

import lombok.RequiredArgsConstructor;
@Profile("moon")
@RequiredArgsConstructor
@RestController
public class MyPageController {



	private final MyPageRepository myPageRepository;

	@PostMapping("/shop_mypage/{userId}/order")
	public List<MypageOrdersResponseDto> mypageOrder(@PathVariable int userId) {
		List<MypageOrdersResponseDto> mypageOrdersResponseDto = (List<MypageOrdersResponseDto>) myPageRepository
				.findOrdersById(userId);
		return mypageOrdersResponseDto;
	}

	//결제 추가
	//insert
	//@PostMapping("/payment/{id}")
	//	public CommonRespDto<?> payment(@RequestBody C){
	//		System.out.println("saveCart: "+cart);
	//		myPageRepository.saveCart(cart);
	//		return new CommonRespDto<String>();
	//	}


	@PostMapping("/shop_mypage/{userId}/cancle")
	public String mypageCancle(@PathVariable int userId) {
		List<MypageCancleRespDto> mypageCancleRespDto = (List<MypageCancleRespDto>) myPageRepository
				.findCancleById(userId);
		return mypageCancleRespDto + "마이페이지  취소/교환/반품 화면 입니다.";
	}

	@PostMapping("/shop_mypage/{userId}/coupon")
	public String mypageCoupon(@PathVariable int userId) {
		List<MypageCouponRespDto> mypageCouponRespDto = (List<MypageCouponRespDto>) myPageRepository
				.findCouponById(userId);
		return mypageCouponRespDto+ "마이페이지 쿠폰화면 입니다.";
	}

	@PostMapping("/shop_mypage/{userId}/point")
	public List<MypagePointRespDto> mypagePoint(@PathVariable int userId) {
		List<MypagePointRespDto> mypagePointRespDto = (List<MypagePointRespDto>) myPageRepository
				.findPointById(userId);
		return mypagePointRespDto;
	}

	@PostMapping("/shop_mypage/{userId}/update")
	public MypageUpdateRespDto mypageUpdate(@PathVariable int userId) {
		MypageUpdateRespDto mypageUpdateRespDto = myPageRepository
				.findUserById(userId);
		return mypageUpdateRespDto;
	}

	@PostMapping("/shop_mypage/{userId}/withdrawal")
	public CommonRespDto<?> mypageWithdrawal(@PathVariable int userId) {
		myPageRepository.deleteByid(userId);
		if(myPageRepository.findUserById(userId) == null) {
			System.out.println("회원탈퇴가 잘 진행 되었습니다.");
		};
		return new CommonRespDto<String>(1, "회원탈퇴가 잘 진행되었습니다.");
	}

}