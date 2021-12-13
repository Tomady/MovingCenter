package co.MovingCenter.ViewDongSan.ej.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.MovingCenter.ViewDongSan.ej.service.ImgsService;
import co.MovingCenter.ViewDongSan.ej.service.ImgsVO;
import co.MovingCenter.ViewDongSan.ej.service.ReviewService;
import co.MovingCenter.ViewDongSan.ej.service.ReviewVO;
import co.MovingCenter.ViewDongSan.ej.service.RoomsService;
import co.MovingCenter.ViewDongSan.ej.service.RoomsVO;
import co.MovingCenter.ViewDongSan.ej.service.ViewReservationpasService;
import co.MovingCenter.ViewDongSan.ej.service.ViewReservationpasVO;

@Controller
public class GuestController {
	
	@Autowired
	public RoomsService roomsDao;
	@Autowired
	public ViewReservationpasService reservationDao;
	@Autowired
	public ImgsService imgsDao;
	@Autowired
	public ReviewService reviewDao;
	
	ViewReservationpasVO vo = new ViewReservationpasVO();
	RoomsVO roomsvo = new RoomsVO();
	ImgsVO imgsvo = new ImgsVO();
	ReviewVO reviewvo = new ReviewVO();

	@RequestMapping(value = "/guestMain.do")
	public String test() {
		return "GUEST/main";
	}
	
	//main_여행지 입력시
	@RequestMapping(value = "/selectAreaRoomList.do")
	@ResponseBody
	public List<ViewReservationpasVO> selectAreaRoomList(@RequestParam("area") String area,
									@RequestParam("checkindate") String checkin,
									@RequestParam("checkoutdate") String checkout) {
		String in = checkin.substring(2).replace('-', '/');
		String out = checkout.substring(2).replace('-', '/');
		
		vo.setCheckIn(in);
		vo.setCheckOut(out);
		List<ViewReservationpasVO> value = new ArrayList<ViewReservationpasVO>(); //사용자검색한지역숙소만담을리스트
		List<ViewReservationpasVO> list = reservationDao.selectRoomList(vo); //사용자일정에맞는숙소리스트
		for(ViewReservationpasVO val : list) {
			if(val.getRoomAddress().contains(area)) {
				value.add(val);
			}
		}
		System.out.println(value);
		
		return value;
	}
	
	//main_여행지 미입력시
	@RequestMapping(value = "/selectRoomList.do")
	@ResponseBody
	public List<ViewReservationpasVO> selectRoomList(@RequestParam("checkindate") String checkin,
								@RequestParam("checkoutdate") String checkout,
								Model model) {
		String in = checkin.substring(2).replace('-', '/');
		String out = checkout.substring(2).replace('-', '/');

		vo.setCheckIn(in);
		vo.setCheckOut(out);
		List<ViewReservationpasVO> list = reservationDao.selectRoomList(vo);
		
		return list;
	}
	
	//main->roomDetails
	@GetMapping(value = "/roomDetails.do")
	public String roomDetails(@RequestParam("roomid") int roomid,
							  @RequestParam("checkin") String checkin,
							  @RequestParam("checkout") String checkout,
								Model model) {		
		roomsvo.setRoomId(roomid);
		imgsvo.setRoomId(roomid);
		reviewvo.setRoomId(roomid);
		model.addAttribute("selectRoom",roomsDao.selectRoomDetails(roomsvo));
		model.addAttribute("selectRoomImg",imgsDao.selectRoomImgs(imgsvo));
		model.addAttribute("selectRoomReview",reviewDao.selectRoomReview(reviewvo));
		
		model.addAttribute("checkin",checkin);
		model.addAttribute("checkout",checkout);
		
		return "GUEST/roomDetails";
	}
	
	@GetMapping(value = "/roomBooking.do")
	public String roomBooking(@RequestParam("roomid") int roomid,
							  @RequestParam("in") String checkin,
							  @RequestParam("out") String checkout,
							  Model model) {
		roomsvo.setRoomId(roomid);
		model.addAttribute("roomBooking",roomsDao.selectRoomDetails(roomsvo));
		model.addAttribute("checkin",checkin);
		model.addAttribute("checkout",checkout);
		
	
		return "GUEST/roomBooking";
	}
	
	@RequestMapping(value = "/myPage.do")
	public String myPage(){
		return "GUEST/myPage";
	}
}
