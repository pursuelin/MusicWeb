package tw.org.iii.cma.MusicWeb.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import tw.org.iii.cma.MusicWeb.Service.MemberInfoService;
import tw.org.iii.cma.MusicWeb.domain.MemberInfoBean;

@Controller
public class MemberInfoController {
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private MemberInfoService memberInfoService;


	@RequestMapping(path = { "/pages/memberinfo.controller" })
	public String handlerMethod(MemberInfoBean memberInfoBean, BindingResult bindingResult, String memberInfo, Model model,
			Locale locale) {		
//接收資料
//轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);

		if (bindingResult != null && bindingResult.hasFieldErrors()) {
			if (bindingResult.hasFieldErrors("memberid")) {
				errors.put("memberid", messageSource.getMessage("memberinfo.memberid.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("account")) {
				errors.put("account", messageSource.getMessage("memberinfo.account.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("email")) {
				errors.put("email", messageSource.getMessage("memberinfo.email.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("passwd")) {
				errors.put("passwd", messageSource.getMessage("memberinfo.passwd.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("name")) {
				errors.put("name", messageSource.getMessage("memberinfo.name.format", null, locale));
			}
		}

//驗證資料
		if ("Insert".equals(memberInfo) || "Update".equals(memberInfo) || "Delete".equals(memberInfo)) {
			if (memberInfoBean == null || memberInfoBean.getMemberid() == null) {
				errors.put("memberid", messageSource.getMessage("memberinfo.memberid.required", new String[] { memberInfo }, locale));
			}
		}

		if (errors != null && !errors.isEmpty()) {
			return "/pages/memberinfo";
		}

//呼叫Model
//根據Model執行結果導向View	
		if (memberInfo != null && memberInfo.equals("Select")) {
			List<MemberInfoBean> result = memberInfoService.select(memberInfoBean);
			model.addAttribute("select", result);
			return "/pages/memberinfodisplay";	} 
		else if (memberInfo != null && memberInfo.equals("Insert")) {
			MemberInfoBean result = memberInfoService.insert(memberInfoBean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "/pages/memberinfo";
		} else if (memberInfo != null && memberInfo.equals("Update")) {
			MemberInfoBean result = memberInfoService.update(memberInfoBean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "/pages/memberinfo";
		} else if (memberInfo != null && memberInfo.equals("Delete")) {
			boolean result = memberInfoService.delete(memberInfoBean);
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "/pages/memberinfo";
		} else {
			errors.put("action", "Unknown Action:" + memberInfo);
			return "/pages/memberinfo";
		}

	}

}
