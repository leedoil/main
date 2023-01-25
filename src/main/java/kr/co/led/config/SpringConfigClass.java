package kr.co.led.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/*
public class SpringConfigClass implements WebApplicationInitializer {

   @Override
   public void onStartup(ServletContext servletContext) throws ServletException {
      
       404error ï¿½ë¤†? ï¿?   ï¿½ë¤ƒ? ï¿? ? ?„?…•? ?™?˜™  ? ?„??? ?„?„­? ?„?ƒ¹ ï¿½êµ¢? ï¿? onStartup ? ?ˆ?‰²? ?ˆì¸Šå ?Œì¡? ç­Œëƒ?˜™  ? ?„ê»? ? ?Œê¶? Spring MVC ? ?ˆ?„ ? ?ˆ?„„? ?ˆ??? ?Œ?’§? ?Œëª å ?ˆ?¨? ?™?˜™   ç¤–ï¿½?™’Î»ï¿½ç­Œë¥…ì˜™ setting ï¿½ë‡¡? ?™?˜™? ï¿?   ? ?ˆ?—¿ ? ?ˆì¸?  ?–«?ì˜™ ? ?™?˜™ ? ?ˆ?„„?™²ï¿½å ï¿? 
       WebApplicationInitializer? ?ˆ?”  ? ?ˆì¨¨å ?ˆë¿?å¯ƒï¿½ ï¿½ë‡¡? ?™?˜™? ï¿?   ? ?ˆ?—¿ ? ?ˆì¸?  ?‡ê»“ì˜™ ? ?Œêµ? ? ?ˆì¸©ï¿½ë¤†å ï¿?   ? ?ˆ?—¿ ? ?ˆ?²?™²ï¿½å ï¿?   ? ?Œê²? ï¿½ë™´? ï¿? ? ?ˆ?•ï¿½ìŠ–? ï¿?   ? ?ˆë¹? ç­Œë¬•?˜™ ï¿½ëµ³?‡‰ê»‹ì¾µ ï¿½ìŠ–? ï¿?  ï¿½ì†»æ´¹ï½Œêµ¡å ?Œêµ? ? ?ˆì¸? web.xml ? ?ˆ?„„  ? ?ˆë¹? ç­Œë¬•?˜™ ï¿½ëµ³? ï¿? ï¿½ì †? ï¿? ï¿½ëœ®? ï¿?  ï¿½ë‡¡? ?™?˜™?”±ï¿? ? ?ˆë¦? 
        ï¦‡ë³©?˜™ ? ?ˆ?•äº?ê»“ì˜™ ï¿½ìŠ–? ï¿?  SpringConfigClassï¿½ë¤†? ï¿?   ? ?Œêµ? ï¿½ë™´? ï¿? ï¿½ëµ³?‡‰ê»‹ì¾µ ï¿½ìŠ–? ï¿?  404error ï¿½êµ¢? ï¿? ï¿½ë™´? ï¿? ? ?„??? ?„?„­? ?„?ƒ¹ ï¿½êµ¢? ï¿? ? ?ˆ?‰²? ?ˆì¸Šå ?Œì¡? ï¿½ëµ³? ï¿? ? ?ˆì¸ï¿½?‡¦?Œ¿?²?œ‘? ?ˆ?—® ->  ? ?Œê²±ï¿½?›¾ï¿½ë£†ï¿½ë¾¼? ?ˆì­? ?„ï¿½ï¿½?‘œï¿½ë¿‰  web.xml? ?ˆ?”  ? ?ˆì¨¨å ?ˆë¿?å¯ƒï¿½
       
      // (web.xml ï¿½êµ¢? ï¿? ï¿½ë•»? ï¿? <servlet> ? ?ˆì¨¨å ?ˆë¿?å¯ƒê¹?˜™å¯ƒï¿½    ï¿½ë¤†ï¿½ë£‡ï¿½ë“Œ? ?ˆì¾?)
      // Spring MVC  ï¿½ê±¡ï¿½ëœ½ï¿½ë¿‰? ?ˆì¸‹å ?Œ? ¾ ? ?ˆì½?  ï¿½ë•»? ï¿? ? ?Œ? § ? ?ˆêµ?  ? ?ˆì­? ï¿½ëœ®? ï¿?  ? ?Œêµ? ï¿½ë•»? ï¿? ï¿½ë‡¡? ï¿? ? ?ˆì¸?  ?‡ê»“ì˜™ ? ?Œêµ? ? ?ˆì¸? ? ?ˆêº? ï¿½ë¤†ï¿½ë£‡?®?„Š?™¼ï¿½ë®ï§ï¿½   ç¹¹ë¨²?˜™ ï¿½ë•»? ï¿? ï¿½ë‡¡? ï¿? ? ?ˆ?².
      AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
      servletAppContext.register(ServletAppContext.class);

      //  ? ?ˆë­µç™²?”‰?˜™  ï¿½ë›¾ï¿½ë£‡è£•ë‰‘?‹¦? ï¿?  ? ?ˆë»?  ? ?ˆë­µç™²?”‰?˜™  ? ?ˆêµ? ?™²?“Ÿ?‡¨?„¬? ?ˆ?‰´ ï¿½ë‡¡? ï¿? ? ?ˆì¸?  ï¿½ë•»ï¿½ìŠï¿½ë?ï¿½ê²«ï¿½ë»¹?¾ï¿½ ? ?ˆêµ? DispatcherServlet ? ?ˆ?•ï¿½ìŠ–? ï¿?   ï¿½ë•»? ï¿? ? ?Œ? § ï¿½ëœ®?™’?“ë­?  ? ?ˆ?².
      DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
      // ? ?ˆë¦°å ?ˆê±ï¿½?š¯ê¶˜ï¿½?¦  ? ?ˆë¹?ï¿½ìŠ–? ï¿?   ï¿½ë•»? ï¿? ï¿½ì †? ï¿? ç­Œëƒ?˜™ servletContextï¿½ë¤†ï¿½ë£‡?®?„Š?™¼ï¿½ë®ï§ï¿½   ? ?ˆ?„„ ? ?ˆë®? ï¿½ë‡¡? ï¿? ï¿½êµ¢? ï¿? servlet ? ?ˆ?‰²ï¿½ê²«? ï¿?  load-on
      ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);

      // ? ?„ê»? ï¿½ë¤†? ï¿?   ï¿½ë•»? ï¿? ? ?Œ? §
      servlet.setLoadOnStartup(1);// ï¿½ë¤†? ï¿?  ? ?Œê¶‹å ?Œ?„‚? ?ˆ?‹”  ï¿½ë›¾ï¿½ë£‡?Œ·?‰”?‡¡? ï¿? ?„ï¿½å ï¿? ? ?ˆ?„„ï¿½ë‡¦?Œ¿?—­ìªšå ?ˆ?² ? ?ˆì¸?  ? ?ˆ?”
      servlet.addMapping("/");

      // ==================================================================
      // (web.xml ï¿½êµ¢? ï¿? ï¿½ë•»? ï¿? <context-param>? ?ˆì¨¨å ?ˆë¿?å¯ƒê¹?˜™å¯ƒï¿½    ï¿½ë¤†ï¿½ë£‡ï¿½ë“Œ? ?ˆì¾?)
      // Bean ? ?ˆêµ?  ? ?Œ? § ? ?ˆêº? ï¿½ë‡¡? ï¿? ? ?ˆì¸?  ?‡ê»“ì˜™ ? ?Œêµ? ? ?ˆì¸©å ?ˆ?”  ? ?ˆ?”“  ? ?Œ? § ï¿½ë‡¡? ï¿? ? ?ˆ?²
      AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
      rootAppContext.register(RootAppContext.class);
      // (web.xml ï¿½êµ¢? ï¿? ï¿½ë•»? ï¿? <listener>? ?ˆì¨¨å ?ˆë¿?å¯ƒê¹?˜™å¯ƒï¿½    ï¿½ë¤†ï¿½ë£‡ï¿½ë“Œ? ?ˆì¾?)
      ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
      servletContext.addListener(listener);
      // (web.xml ï¿½êµ¢? ï¿? ï¿½ë•»? ï¿? <filter>? ?ˆì¨¨å ?ˆë¿?å¯ƒê¹?˜™å¯ƒï¿½    ï¿½ë¤†ï¿½ë£‡ï¿½ë“Œ? ?ˆì¾?)
      //  ? ?Œ?ƒ± ? ?ˆ?„äº?ê»‹ê¼¶ï§?ë©±ë•»? ï¿?  ? ?ˆ?°? ?„??ï¿½ê²«ï¿½ë¼”ï¿½ëŸ   ï¿½ë•»? ï¿? ? ?Œ? §
      FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
      filter.setInitParameter("encoding", "UTF-8");
      // dispatcher ï¿½êµ¢? ï¿?  ? ?ˆêº? ï¿½ëœ®? ï¿? ï¿½ë•»? ï¿? ? ?ˆ?‰²ï¿½ê²«? ï¿?  ç­Œëƒ?˜™ Servlet ï¿½êµ¢? ï¿? UTF-8ï¿½ìŠ–? ï¿?  encoding ï¿½ë‡¡? ?½?‡¦?Œ¿?—­ìªšå ?ˆ?² ? ?ˆì¸? ? ?ˆì¨¨å ?ˆë¿?å¯ƒê¹?˜™å¯ƒï¿½ 
      filter.addMappingForServletNames(null, false, "dispatcher");

   }*/
   
	public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer {
		   // DispatcherServletï¿½ë¿‰ ï§ã…½ë¸¨ï¿½ë¸? ï¿½ìŠ‚ï§£ï¿½ äºŒì‡±?ƒ¼?‘œï¿? ï¿½ë?‘ï¿½?˜¿ï¿½ë¸³ï¿½ë–.
		   @Override
		   protected String[] getServletMappings() {
		      // TODO Auto-generated method stub
		      return new String[] { "/" };
		   }

		   // Spring MVC ï¿½ë´½æ¿¡ì’–? ¥ï¿½ë“ƒ ï¿½ê½•ï¿½ì ™ï¿½ì“£ ï¿½ìï¿½ë¸³ ï¿½ê²¢ï¿½ì˜’ï¿½ë’ª?‘œï¿? ï§ï¿½ï¿½ì ™ï¿½ë¸³ï¿½ë–.
		   @Override
		   protected Class<?>[] getServletConfigClasses() {
		      // TODO Auto-generated method stub
		      return new Class[] { ServletAppContext.class };
		   }

		   // ï¿½ë´½æ¿¡ì’–? ¥ï¿½ë“ƒï¿½ë¿‰ï¿½ê½Œ ï¿½ê¶—ï¿½ìŠœï¿½ë¸· Beanï¿½ë±¾ï¿½ì“£ ï¿½ì ™ï¿½ì“½æ¹²ï¿½ ï¿½ìï¿½ë¸³ ï¿½ê²¢ï¿½ì˜’ï¿½ë’ª?‘œï¿? ï§ï¿½ï¿½ì ™ï¿½ë¸³ï¿½ë–.
		   @Override
		   protected Class<?>[] getRootConfigClasses() {
		      // TODO Auto-generated method stub
		      return new Class[] { RootAppContext.class };
		   }

		   // ï¿½ë™†ï¿½ì”ªèª˜ëª…ê½? ï¿½ì”¤?‚„ë¶¾ëµ« ï¿½ë¸˜ï¿½ê½£ ï¿½ê½•ï¿½ì ™
		   @Override
		   protected Filter[] getServletFilters() {
		      // TODO Auto-generated method stub
		      CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		      encodingFilter.setEncoding("UTF-8");
		      return new Filter[] {encodingFilter};
		   }
   
 //ï¿½ì ™ï¿½ìŸ»ï¿½ëœ²ï¿½ì” ï¿½ê½£ï¿½ì“½ ï¿½ì†šå¯ƒìŒê½•ï¿½? ™ : ï¿½ìŠœï¿½ì›¾
   //null: ï¿½ê¶—ï¿½ìŠœï¿½ì˜„åª›ï¿½ ï¿½ì—¯ï¿½ì °ï¿½ë¸³ ï¿½ê¶¡ï¿½ìŠœï¿½ì“£ ï¿½ì—«ï¿½ë–†æ¹²ê³—ë¼²ï¿½ë¸? ï¿½ë¸˜ï¿½ë™†ç§»ì„‘?„±?³ë³¦ë¿‰ï¿½ê½? ï¿½ì £?¨ë“¯ë¸?ï¿½ë’— ï¿½ê½Œè¸°ê¾©?“½ ï¿½ì—«ï¿½ë–†æ¹²ê³—ë¼²ï¿½?˜£ï¿½ëƒ¼
   //52428800 :  ï¿½ë¾½æ¿¡ì’•ë±? ï¿½ëœ²ï¿½ì” ï¿½ê½£ï¿½ì“½ ï¿½ìŠœï¿½ì›¾ (1024*50) 50Mæ¿¡ï¿½ ï¿½ê½•ï¿½ì ™
   //524288000 : ï¿½ë™†ï¿½ì”ªï¿½ëœ²ï¿½ì” ï¿½ê½£?‘œï¿? ï¿½ë£·ï¿½ë¸¿ï¿½ë¸³ ï¿½ìŸ¾ï§£ëŒ?Šœï¿½ì›¾ 500M ï¿½ê½•ï¿½ì ™
   //0 : ï¿½ë™†ï¿½ì”ªï¿½ì“½ ï¿½ì—«?¨ê¾§ì»?(ï¿½ëœ²ï¿½ì” ï¿½ê½£?‘œï¿? è«›ì†ë¸˜ï¿½ê½? ï¿½ì˜„ï¿½ë£ï¿½ì‘æ¿¡ï¿½ ï¿½ï¿½ï¿½ì˜£)
   @Override
   protected void customizeRegistration(Dynamic registration) {
	   super.customizeRegistration(registration);
	   MultipartConfigElement config1 = new MultipartConfigElement(null,52428800, 524288000, 0 );
	   registration.setMultipartConfig(config1);
   }

}