package br.com.presentes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public LinkDiscoverers discoverers() {
		List<LinkDiscoverer> plugins = new ArrayList<>();
		plugins.add(new CollectionJsonLinkDiscoverer());
		return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
	}

	/*
	 * @Bean public Docket productApi() { return new
	 * Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any
	 * ()) .paths(PathSelectors.any()).build().enable(true).apiInfo(metaInfo())
	 * .securityContexts(Lists.newArrayList(securityContext())).securitySchemes(
	 * Lists.newArrayList(apiKey())); }
	 * 
	 * private ApiInfo metaInfo() {
	 * 
	 * ApiInfo apiInfo = new ApiInfo("Presentes", "DESCRI��O DO PROJETO", "1.0",
	 * "Terms of Service", new Contact("#########################",
	 * "###########################", "jhondonavan@gmail.com"),
	 * "Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0",
	 * Collections.emptyList());
	 * 
	 * return apiInfo; }
	 * 
	 * private SecurityContext securityContext() { return
	 * SecurityContext.builder().securityReferences(defaultAuth()).forPaths(
	 * PathSelectors.ant("/api/**")) .build(); }
	 * 
	 * List<SecurityReference> defaultAuth() { AuthorizationScope authorizationScope
	 * = new AuthorizationScope("global", "accessEverything"); AuthorizationScope[]
	 * authorizationScopes = new AuthorizationScope[1]; authorizationScopes[0] =
	 * authorizationScope; return Arrays.asList(new
	 * SecurityReference("AUTHORIZATION", authorizationScopes)); }
	 * 
	 * private ApiKey apiKey() { return new ApiKey("AUTHORIZATION", "api_key",
	 * "header"); }
	 * 
	 * 
	 * 
	 * // for @EnableWebMvc
	 * 
	 * public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * registry.addResourceHandler("swagger-ui.html").addResourceLocations(
	 * "classpath:/META-INF/resources/");
	 * 
	 * registry.addResourceHandler("/webjars/**").addResourceLocations(
	 * "classpath:/META-INF/resources/webjars/"); }
	 * 
	 */
}
