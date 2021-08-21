package tw.org.iii.cma.MusicWeb;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang"); 
		//和jsp name一致
		registry.addInterceptor(interceptor);
	}
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver= new CookieLocaleResolver();
		resolver.setDefaultLocale(Locale.TAIWAN);
		resolver.setCookieMaxAge(86400);
		resolver.setCookieName("langCookie");
		return resolver;
	}
}
