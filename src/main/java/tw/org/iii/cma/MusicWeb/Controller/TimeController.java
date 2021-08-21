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

import tw.org.iii.cma.MusicWeb.Service.TimeInfoService;
import tw.org.iii.cma.MusicWeb.domain.TimeInfoBean;

@Controller
public class TimeController {
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private TimeInfoService timeInfoService;

	@InitBinder
	public void initMethod(WebDataBinder webDataBinder) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor customerDateEditor = new CustomDateEditor(sFormat, true);
		webDataBinder.registerCustomEditor(java.util.Date.class, customerDateEditor);
	}
	@RequestMapping(path = { "/pages/timeinfo.controller" })
	public String handlerMethod(TimeInfoBean timeInfoBean, BindingResult bindingResult, String timeInfo, Model model,
			Locale locale) {		
//接收資料
//轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);

		if (bindingResult != null && bindingResult.hasFieldErrors()) {
			if (bindingResult.hasFieldErrors("id")) {
				errors.put("id", messageSource.getMessage("timeinfo.id.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("showdate")) {
				errors.put("showdate", messageSource.getMessage("timeinfo.showdate.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("entertime")) {
				errors.put("entertime", messageSource.getMessage("timeinfo.entertime.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("showtime")) {
				errors.put("showtime", messageSource.getMessage("timeinfo.showtime.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("showtotaltime")) {
				errors.put("showtotaltime", messageSource.getMessage("timeinfo.showtotaltime.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("activityid")) {
				errors.put("activityid", messageSource.getMessage("timeinfo.activityid.format", null, locale));
			}
		}

//驗證資料
		if ("Insert".equals(timeInfo) || "Update".equals(timeInfo) || "Delete".equals(timeInfo)) {
			if (timeInfoBean == null || timeInfoBean.getId() == null) {
				errors.put("id", messageSource.getMessage("timeinfo.id.required", new String[] { timeInfo }, locale));
			}
		}

		if (errors != null && !errors.isEmpty()) {
			return "/pages/timeinfo";
		}

//呼叫Model
//根據Model執行結果導向View	
		if (timeInfo != null && timeInfo.equals("Select")) {
			List<TimeInfoBean> result = timeInfoService.select(timeInfoBean);
			model.addAttribute("select", result);
			return "/pages/timeinfodisplay";	} 
		else if (timeInfo != null && timeInfo.equals("Insert")) {
			TimeInfoBean result = timeInfoService.insert(timeInfoBean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "/pages/timeinfo";
		} else if (timeInfo != null && timeInfo.equals("Update")) {
			TimeInfoBean result = timeInfoService.update(timeInfoBean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "/pages/timeinfo";
		} else if (timeInfo != null && timeInfo.equals("Delete")) {
			boolean result = timeInfoService.delete(timeInfoBean);
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "/pages/timeinfo";
		} else {
			errors.put("action", "Unknown Action:" + timeInfo);
			return "/pages/timeinfo";
		}

	}

}
