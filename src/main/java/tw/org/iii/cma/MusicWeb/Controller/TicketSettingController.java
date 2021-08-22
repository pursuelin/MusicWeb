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
import tw.org.iii.cma.MusicWeb.Service.TicketSettingService;
import tw.org.iii.cma.MusicWeb.domain.TicketSettingBean;

@Controller
public class TicketSettingController {
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private TicketSettingService ticketSettingService;


	@RequestMapping(path = { "/pages/ticketsetting.controller" })
	public String handlerMethod(TicketSettingBean ticketSettingBean, BindingResult bindingResult, String ticketSetting, Model model,
			Locale locale) {		
//接收資料
//轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);

		if (bindingResult != null && bindingResult.hasFieldErrors()) {
			if (bindingResult.hasFieldErrors("id")) {
				errors.put("id", messageSource.getMessage("memberinfo.id.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("ticketKind")) {
				errors.put("ticketKind", messageSource.getMessage("ticketsetting.ticketKind.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("cost")) {
				errors.put("cost", messageSource.getMessage("ticketsetting.cost.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("storage")) {
				errors.put("storage", messageSource.getMessage("ticketsetting.storage.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("solddeadline")) {
				errors.put("solddeadline", messageSource.getMessage("ticketsetting.solddeadline.format", null, locale));
			}
			if (bindingResult.hasFieldErrors("activityid")) {
				errors.put("activityid", messageSource.getMessage("ticketsetting.activityid.format", null, locale));
			}
		}

//驗證資料
		if ("Insert".equals(ticketSetting) || "Update".equals(ticketSetting) || "Delete".equals(ticketSetting)) {
			if (ticketSettingBean == null || ticketSettingBean.getId() == null) {
				errors.put("id", messageSource.getMessage("ticketsetting.id.required", new String[] { ticketSetting }, locale));
			}
		}

		if (errors != null && !errors.isEmpty()) {
			return "/pages/ticketsetting";
		}

//呼叫Model
//根據Model執行結果導向View	
		if (ticketSetting != null && ticketSetting.equals("Select")) {
			List<TicketSettingBean> result = ticketSettingService.select(ticketSettingBean);
			model.addAttribute("select", result);
			return "/pages/ticketSettingdisplay";	} 
		else if (ticketSetting != null && ticketSetting.equals("Insert")) {
			TicketSettingBean result = ticketSettingService.insert(ticketSettingBean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "/pages/ticketSettinginfo";
		} else if (ticketSetting != null && ticketSetting.equals("Update")) {
			TicketSettingBean result = ticketSettingService.update(ticketSettingBean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "/pages/ticketsetting";
		} else if (ticketSetting != null && ticketSetting.equals("Delete")) {
			boolean result = ticketSettingService.delete(ticketSettingBean);
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "/pages/ticketsetting";
		} else {
			errors.put("action", "Unknown Action:" + ticketSetting);
			return "/pages/ticketsetting";
		}

	}

}
