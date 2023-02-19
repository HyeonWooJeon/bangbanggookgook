package com.care.KorTravel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfiguration implements WebMvcConfigurer {

//	// TilesViewResolver
//	@Bean
//	public TilesViewResolver tilesViewResolver() {
//		final TilesViewResolver tilesViewResolver = new TilesViewResolver();
//		
//		tilesViewResolver.setViewClass(TilesView.class);
//		// view 우선순위
//		tilesViewResolver.setOrder(1);
//		
//		return tilesViewResolver;
//	}
//	
//	// TilesConfigurer
//	@Bean
//	public TilesConfigurer tilesConfigurer() {
//		TilesConfigurer configurer = new TilesConfigurer();
//		
//		// tiles.xml 경로 명시
//		configurer.setDefinitions(new String[] {"/WEB-INF/tiles/tiles.xml"});
//		// Refresh 가능여부 설정
//		configurer.setCheckRefresh(true);
//		
//		return configurer;
//	}
	
	
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		
		tilesViewResolver.setOrder(0); // view에서 load될 우선순위 설정
		return tilesViewResolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		final TilesConfigurer configurer = new TilesConfigurer();
		
		// tiles 설정파일의 경로 지정z
		configurer.setDefinitions(new String[]{"/WEB-INF/layout/tiles/tiles.xml"});
		
		// Refresh 가능여부 설정
		configurer.setCheckRefresh(true);
		return configurer;
	}
}
