package br.com.presentes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration{

	@Bean
	public LinkDiscoverers discoverers() {
		List<LinkDiscoverer> plugins = new ArrayList<>();
		plugins.add(new CollectionJsonLinkDiscoverer());
		return new LinkDiscoverers(SimplePluginRegistry.create(plugins));

	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	    }

	}


	/*
	 * 
	 * @Autowired private TypeResolver typeResolver;
	 * 
	 * @Value("${app.client.id}") private String clientId;
	 * 
	 * @Value("${app.client.secret}") private String clientSecret;
	 * 
	 * @Value("${info.build.name}") private String infoBuildName;
	 * 
	 * public static final String securitySchemaOAuth2 = "oauth2"; public static
	 * final String authorizationScopeGlobal = "global"; public static final String
	 * authorizationScopeGlobalDesc = "accessEverything";
	 * 
	 * @Bean public Docket api() {
	 * 
	 * List<ResponseMessage> list = new java.util.ArrayList<ResponseMessage>();
	 * list.add(new ResponseMessageBuilder() .code(500) .message("500 message")
	 * .responseModel(new ModelRef("JSONResult«string»")) .build()); list.add(new
	 * ResponseMessageBuilder() .code(401) .message("Unauthorized")
	 * .responseModel(new ModelRef("JSONResult«string»")) .build());
	 * 
	 * 
	 * return new Docket(DocumentationType.SWAGGER_2) .select()
	 * .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any()) .build()
	 * .securitySchemes(Collections.singletonList(securitySchema()))
	 * .securityContexts(Collections.singletonList(securityContext()))
	 * .pathMapping("/") .directModelSubstitute(LocalDate.class,String.class)
	 * .genericModelSubstitutes(ResponseEntity.class)
	 * .useDefaultResponseMessages(false) .apiInfo(apiInfo())
	 * .globalResponseMessage(RequestMethod.GET,list)
	 * .globalResponseMessage(RequestMethod.POST,list); }
	 * 
	 * 
	 * private OAuth securitySchema() {
	 * 
	 * List<AuthorizationScope> authorizationScopeList = new ArrayList();
	 * authorizationScopeList.add(new AuthorizationScope("global", "access all"));
	 * 
	 * List<GrantType> grantTypes = new ArrayList(); final TokenRequestEndpoint
	 * tokenRequestEndpoint = new
	 * TokenRequestEndpoint("http://server:port/oauth/token", clientId,
	 * clientSecret); final TokenEndpoint tokenEndpoint = new
	 * TokenEndpoint("http://server:port/oauth/token", "access_token");
	 * AuthorizationCodeGrant authorizationCodeGrant = new
	 * AuthorizationCodeGrant(tokenRequestEndpoint, tokenEndpoint);
	 * 
	 * grantTypes.add(authorizationCodeGrant);
	 * 
	 * OAuth oAuth = new OAuth("oauth", authorizationScopeList, grantTypes);
	 * 
	 * return oAuth; }
	 * 
	 * 
	 * private SecurityContext securityContext() { return
	 * SecurityContext.builder().securityReferences(defaultAuth())
	 * .forPaths(PathSelectors.ant("/api/**")).build(); }
	 * 
	 * private List<SecurityReference> defaultAuth() {
	 * 
	 * final AuthorizationScope authorizationScope = new
	 * AuthorizationScope(authorizationScopeGlobal, authorizationScopeGlobalDesc);
	 * final AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	 * authorizationScopes[0] = authorizationScope; return Collections
	 * .singletonList(new SecurityReference(securitySchemaOAuth2,
	 * authorizationScopes)); }
	 * 
	 * 
	 * 
	 * private ApiInfo apiInfo() { return new ApiInfoBuilder() .title("My rest API")
	 * .description(" description here … ")
	 * .termsOfServiceUrl("https://www.example.com/") .contact(new
	 * Contact("XXXX XXXX", "http://www.example.com", "xxxx@example.com"))
	 * .license("license here") .licenseUrl("https://www.example.com")
	 * .version("1.0.0") .build(); }
	 * 
	 */

