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

import tw.org.iii.cma.MusicWeb.Service.LocationInfoService;
import tw.org.iii.cma.MusicWeb.domain.LocationInfoBean;


	@Controller
	public class LocationInfoController {
		@Autowired
		private MessageSource messageSource;

		@Autowired
		private LocationInfoService locationInfoService;


		@RequestMapping(path = { "/pages/locationinfo.controller" })
		public String handlerMethod(LocationInfoBean locationInfoBean, BindingResult bindingResult, String locationInfo, Model model,
				Locale locale) {		
	//接收資料
	//轉換資料
			Map<String, String> errors = new HashMap<String, String>();
			model.addAttribute("errors", errors);

			if (bindingResult != null && bindingResult.hasFieldErrors()) {
				if (bindingResult.hasFieldErrors("locationid")) {
					errors.put("locationid", messageSource.getMessage("locationinfo.locationid.format", null, locale));
				}
				if (bindingResult.hasFieldErrors("showaddr")) {
					errors.put("showaddr", messageSource.getMessage("locationinfo.showaddr.format", null, locale));
				}
				if (bindingResult.hasFieldErrors("showplace")) {
					errors.put("showplace", messageSource.getMessage("locationinfo.showplace.format", null, locale));
				}
				
			}

	//驗證資料
			if ("Insert".equals(locationInfo) || "Update".equals(locationInfo) || "Delete".equals(locationInfo)) {
				if (locationInfoBean == null || locationInfoBean.getLocationid() == null) {
					errors.put("locationid", messageSource.getMessage("locationinfo.locationid.required", new String[] { locationInfo }, locale));
				}
			}

			if (errors != null && !errors.isEmpty()) {
				return "/pages/locationinfo";
			}

	//呼叫Model
	//根據Model執行結果導向View	
			if (locationInfo != null && locationInfo.equals("Select")) {
				List<LocationInfoBean> result = locationInfoService.select(locationInfoBean);
				model.addAttribute("select", result);
				return "/pages/locationinfodisplay";	} 
			else if (locationInfo != null && locationInfo.equals("Insert")) {
				LocationInfoBean result = locationInfoService.insert(locationInfoBean);
				if (result == null) {
					errors.put("action", "Insert fail");
				} else {
					model.addAttribute("insert", result);
				}
				return "/pages/locationinfo";
			} else if (locationInfo != null && locationInfo.equals("Update")) {
				LocationInfoBean result = locationInfoService.update(locationInfoBean);
				if (result == null) {
					errors.put("action", "Update fail");
				} else {
					model.addAttribute("update", result);
				}
				return "/pages/locationinfo";
			} else if (locationInfo != null && locationInfo.equals("Delete")) {
				boolean result = locationInfoService.delete(locationInfoBean);
				if (!result) {
					model.addAttribute("delete", 0);
				} else {
					model.addAttribute("delete", 1);
				}
				return "/pages/locationinfo";
			} else {
				errors.put("action", "Unknown Action:" + locationInfo);
				return "/pages/locationinfo";
			}

		}

	}


