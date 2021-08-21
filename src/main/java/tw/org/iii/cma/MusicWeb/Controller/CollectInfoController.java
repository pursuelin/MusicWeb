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

import tw.org.iii.cma.MusicWeb.Service.CollectInfoService;
import tw.org.iii.cma.MusicWeb.domain.CollectInfoBean;

@Controller
public class CollectInfoController {
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private CollectInfoService collectInfoService;


	@RequestMapping(path = { "/pages/CollectInfo.controller" })
	public String handlerMethod(CollectInfoBean collectInfoBean, BindingResult bindingResult, String collectInfo, Model model,
			Locale locale) {		
//接收資料
//轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);

		if (bindingResult != null && bindingResult.hasFieldErrors()) {
			if (bindingResult.hasFieldErrors("id")) {
				errors.put("id", messageSource.getMessage("CollectInfo.memberid.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("memberid")) {
				errors.put("memberid", messageSource.getMessage("CollectInfo.account.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("likeamt")) {
				errors.put("likeamt", messageSource.getMessage("CollectInfo.email.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("activityid")) {
				errors.put("activityid", messageSource.getMessage("CollectInfo.passwd.format", null, locale));
			}
			
		}

//驗證資料
		if ("Insert".equals(collectInfo) || "Update".equals(collectInfo) || "Delete".equals(collectInfo)) {
			if (collectInfoBean == null || collectInfoBean.getMemberid() == null) {
				errors.put("memberid", messageSource.getMessage("CollectInfo.memberid.required", new String[] { collectInfo }, locale));
			}
		}

		if (errors != null && !errors.isEmpty()) {
			return "/pages/CollectInfo";
		}

//呼叫Model
//根據Model執行結果導向View	
		if (collectInfo != null && collectInfo.equals("Select")) {
			List<CollectInfoBean> result = collectInfoService.select(collectInfoBean);
			model.addAttribute("select", result);
			return "/pages/collectinfodisplay";	} 
		else if (collectInfo != null && collectInfo.equals("Insert")) {
			CollectInfoBean result = collectInfoService.insert(collectInfoBean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "/pages/collectinfo";
		} else if (collectInfo != null && collectInfo.equals("Update")) {
			CollectInfoBean result = collectInfoService.update(collectInfoBean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "/pages/collectinfo";
		} else if (collectInfo != null && collectInfo.equals("Delete")) {
			boolean result = collectInfoService.delete(collectInfoBean);
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "/pages/collectinfo";
		} else {
			errors.put("action", "Unknown Action:" + collectInfo);
			return "/pages/collectinfo";
		}

	}

}
