//package hjp.givemeideas.infra.cors
//
//import org.springframework.context.annotation.Configuration
//import org.springframework.web.servlet.config.annotation.CorsRegistry
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
//
//
//@Configuration
//class WebConfig : WebMvcConfigurer {
//
//    // CORS 설정 추가
//    override fun addCorsMappings(registry: CorsRegistry) {
//        registry.addMapping("/**")  // 모든 경로에 대해 CORS 허용
//            .allowedOrigins(
//                "http://localhost:3000",
//                "http://localhost:63342/GiveMeIdeas/front/html/planner_html.html?_ijt=tkius74jd4gdsdsou5adplgg5s&_ij_reload=RELOAD_ON_SAVE"
//            )  // 허용할 출처 (프론트엔드 도메인)
//            .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")  // 허용할 HTTP 메서드
//            .allowedHeaders("*")  // 모든 헤더 허용
//            .allowCredentials(true)  // 쿠키 전송 허용
//    }
//}