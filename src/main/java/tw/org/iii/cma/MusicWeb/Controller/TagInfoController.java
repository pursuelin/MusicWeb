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
import tw.org.iii.cma.MusicWeb.Service.TagInfoService;
import tw.org.iii.cma.MusicWeb.domain.TagInfoBean;

@Controller
public class TagInfoController {
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private TagInfoService tagInfoService;


	@RequestMapping(path = { "/pages/taginfo.controller" })
	public String handlerMethod(TagInfoBean tagInfoBean, BindingResult bindingResult, String tagInfo, Model model,
			Locale locale) {		
//接收資料
//轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);

		if (bindingResult != null && bindingResult.hasFieldErrors()) {
			if (bindingResult.hasFieldErrors("tagid")) {
				errors.put("tagid", messageSource.getMessage("taginfo.tagid.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("tagname")) {
				errors.put("tagname", messageSource.getMessage("taginfo.tagname.format", null, locale));
			}
		}

//驗證資料
		if ("Insert".equals(tagInfo) || "Update".equals(tagInfo) || "Delete".equals(tagInfo)) {
			if (tagInfoBean == null || tagInfoBean.getTagid() == null) {
				errors.put("tagid", messageSource.getMessage("taginfo.tagid.required", new String[] { tagInfo }, locale));
			}
		}

		if (errors != null && !errors.isEmpty()) {
			return "/pages/taginfo";
		}

//呼叫Model
//根據Model執行結果導向View	
		if (tagInfo != null && tagInfo.equals("Select")) {
			List<TagInfoBean> result = tagInfoService.select(tagInfoBean);
			model.addAttribute("select", result);
			return "/pages/taginfodisplay";	} 
		else if (tagInfo != null && tagInfo.equals("Insert")) {
			TagInfoBean result = tagInfoService.insert(tagInfoBean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "/pages/taginfo";
		} else if (tagInfo != null && tagInfo.equals("Update")) {
			TagInfoBean result = tagInfoService.update(tagInfoBean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "/pages/taginfo";
		} else if (tagInfo != null && tagInfo.equals("Delete")) {
			boolean result = tagInfoService.delete(tagInfoBean);
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "/pages/taginfo";
		} else {
			errors.put("action", "Unknown Action:" + tagInfo);
			return "/pages/taginfo";
		}

	}

}
