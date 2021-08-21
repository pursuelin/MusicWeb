package tw.org.iii.cma.MusicWeb.Controller;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.org.iii.cma.MusicWeb.Service.ActivityInfoService;
import tw.org.iii.cma.MusicWeb.domain.ActivityInfoBean;


	@Controller
	public class ActivityInfoController {
		@Autowired
		private MessageSource messageSource;

		@Autowired
		private ActivityInfoService activityInfoService;
		@InitBinder
		public void initMethod(WebDataBinder webDataBinder) {
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
			CustomDateEditor customerDateEditor = new CustomDateEditor(sFormat, true);
			webDataBinder.registerCustomEditor(java.util.Date.class, customerDateEditor);
		}

		@RequestMapping(path = { "/pages/activityinfo.controller" })
		public String handlerMethod(ActivityInfoBean activityInfoBean, BindingResult bindingResult, String activityInfo, Model model,
				Locale locale) {		
	//接收資料
	//轉換資料
			Map<String, String> errors = new HashMap<String, String>();
			model.addAttribute("errors", errors);

			if (bindingResult != null && bindingResult.hasFieldErrors()) {
				if (bindingResult.hasFieldErrors("activityid")) {
					errors.put("activityid", messageSource.getMessage("activityinfo.activityid.format", null, locale));
				}
				if (bindingResult.hasFieldErrors("tagid")) {
					errors.put("tagid", messageSource.getMessage("activityinfo.tagid.format", null, locale));
				}
				if (bindingResult.hasFieldErrors("bandpost")) {
					errors.put("bandpost", messageSource.getMessage("activityinfo.bandpost.format", null, locale));
				}
				if (bindingResult.hasFieldErrors("host")) {
					errors.put("host", messageSource.getMessage("activityinfo.host.format", null, locale));
				}
				if (bindingResult.hasFieldErrors("player")) {
					errors.put("player", messageSource.getMessage("activityinfo.player.format", null, locale));
				}
				if (bindingResult.hasFieldErrors("theme")) {
					errors.put("theme", messageSource.getMessage("activityinfo.theme.format", null, locale));
				}
				if (bindingResult.hasFieldErrors("subtitle")) {
					errors.put("subtitle", messageSource.getMessage("activityinfo.subtitle.format", null, locale));
				}
				if (bindingResult.hasFieldErrors("activityintro")) {
					errors.put("activityintro", messageSource.getMessage("activityinfo.activityintro.format", null, locale));
				}
				if (bindingResult.hasFieldErrors("bandIntro")) {
					errors.put("bandIntro", messageSource.getMessage("activityinfo.bandIntro.format", null, locale));
				}
				if (bindingResult.hasFieldErrors("locationId")) {
					errors.put("locationId", messageSource.getMessage("activityinfo.locationId.format", null, locale));
				}
				if (bindingResult.hasFieldErrors("tape")) {
					errors.put("tape", messageSource.getMessage("activityinfo.tape.format", null, locale));
				}
				if (bindingResult.hasFieldErrors("uploadTime")) {
					errors.put("uploadTime", messageSource.getMessage("activityinfo.uploadTime.format", null, locale));
				}
				if (bindingResult.hasFieldErrors("purchaseWeb")) {
					errors.put("purchaseWeb", messageSource.getMessage("activityinfo.purchaseWeb.format", null, locale));
				}
				if (bindingResult.hasFieldErrors("memberId")) {
					errors.put("memberId", messageSource.getMessage("activityinfo.memberId.format", null, locale));
				}
				
			}

	//驗證資料
			if ("Insert".equals(activityInfo) || "Update".equals(activityInfo) || "Delete".equals(activityInfo)) {
				if (activityInfoBean == null || activityInfoBean.getActivityid() == null) {
					errors.put("activityid", messageSource.getMessage("activityinfo.activityid.required", new String[] { activityInfo }, locale));
				}
			}

			if (errors != null && !errors.isEmpty()) {
				return "/pages/activityinfo";
			}

	//呼叫Model
	//根據Model執行結果導向View	
			if (activityInfo != null && activityInfo.equals("Select")) {
				List<ActivityInfoBean> result = activityInfoService.select(activityInfoBean);
				model.addAttribute("select", result);
				return "/pages/activityinfodisplay";	} 
			else if (activityInfo != null && activityInfo.equals("Insert")) {
				ActivityInfoBean result = activityInfoService.insert(activityInfoBean);
				if (result == null) {
					errors.put("action", "Insert fail");
				} else {
					model.addAttribute("insert", result);
				}
				return "/pages/activityinfo";
			} else if (activityInfo != null && activityInfo.equals("Update")) {
				ActivityInfoBean result = activityInfoService.update(activityInfoBean);
				if (result == null) {
					errors.put("action", "Update fail");
				} else {
					model.addAttribute("update", result);
				}
				return "/pages/activityinfo";
			} else if (activityInfo != null && activityInfo.equals("Delete")) {
				boolean result = activityInfoService.delete(activityInfoBean);
				if (!result) {
					model.addAttribute("delete", 0);
				} else {
					model.addAttribute("delete", 1);
				}
				return "/pages/activityinfo";
			} else {
				errors.put("action", "Unknown Action:" + activityInfo);
				return "/pages/activityinfo";
			}

		}

	}


