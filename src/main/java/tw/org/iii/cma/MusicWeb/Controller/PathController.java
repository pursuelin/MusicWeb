package tw.org.iii.cma.MusicWeb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PathController {
	@GetMapping("/")
	public String method1() {
		return "/index";
	}
	@GetMapping("/secure/login.page")
	public String method2() {
		return "/secure/login";
	}
	@GetMapping("/pages/product.page")
	public String method3() {
		return "/pages/product";
	}
	//後臺管理首頁
	@GetMapping("/pages/display.page")
	public String method4() {
		return "/pages/display";
	}
	//Memberinfo 會員資訊
	@GetMapping("/pages/memberinfodisplay.page")
	public String method5() {
		return "/pages/memberinfodisplay";
	}
	@GetMapping("/pages/memberinfo.page")
	public String method6() {
		return "/pages/memberinfo";
	}
	//Llocationinfo 場地資訊
	@GetMapping("/pages/locationinfodisplay.page")
	public String method7() {
		return "/pages/locationinfodisplay";
	}
	@GetMapping("/pages/locationinfo.page")
	public String method8() {
		return "/pages/locationinfo";
	}
	// Aactivityinfo 活動資訊
	@GetMapping("/pages/activityinfodisplay.page")
	public String method9() {
		return "/pages/activityinfodisplay";
	}
	@GetMapping("/pages/activityinfo.page")
	public String method10() {
		return "/pages/activityinfo";
	}
	// CollectInfo 收藏資訊
	@GetMapping("/pages/collectinfodisplay.page")
	public String method11() {
		return "/pages/collectinfodisplay";
	}

	@GetMapping("/pages/collectinfo.page")
	public String method12() {
		return "/pages/collectinfo";
	}
	// TagInfo 標籤資訊
	@GetMapping("/pages/taginfodisplay.page")
	public String method13() {
		return "/pages/taginfodisplay";
	}
	@GetMapping("/pages/taginfo.page")
	public String method14() {
		return "/pages/taginfo";
	}	
	// TicketSetting 票券資訊
	@GetMapping("/pages/ticketsettingdisplay.page")
	public String method15() {
		return "/pages/taginfodisplay";
	}
	@GetMapping("/pages/ticketsetting.page")
	public String method16() {
		return "/pages/ticketsetting";
	}	
	// TimeInfo 時間資訊
	@GetMapping("/pages/timeinfodisplay.page")
	public String method17() {
		return "/pages/timeinfoinfodisplay";
	}
	@GetMapping("/pages/timeinfo.page")
	public String method18() {
		return "/pages/timeinfo";
	}
}