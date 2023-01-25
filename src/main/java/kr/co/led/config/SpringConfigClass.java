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
      
       404error �뤆?���?   �뤃?���? ?��?��?��?��?��?��  ?��?��???��?��?��?��?��?�� �굢?���? onStartup ?��?��?��?��?��츊占?���? 筌랃?��  ?��?���? ?��?���? Spring MVC ?��?��?�� ?��?��?��?��?��???��?��?��?��?��몠占?��?��?��?��?��   礖�?��λ�筌륅옙 setting �뇡?��?��?��?���?   ?��?��?�� ?��?���?  ?��?�옙 ?��?��?�� ?��?��?��?���占�? 
       WebApplicationInitializer?��?��?��  ?��?��쨨占?���?寃� �뇡?��?��?��?���?   ?��?��?�� ?��?���?  ?��껓옙 ?��?���? ?��?��츩�뤆占�?   ?��?��?�� ?��?��?��?���占�?   ?��?���? �뙴?���? ?��?��?���슖?���?   ?��?���? 筌묕?�� �뵳?��껋쾵 �슖?���?  �솻洹ｌ굡占?���? ?��?���? web.xml ?��?��?��  ?��?���? 筌묕?�� �뵳?���? �젆?���? �뜮?���?  �뇡?��?��?��?���? ?��?���? 
        驪볩?�� ?��?��?���?껓옙 �슖?���?  SpringConfigClass�뤆?���?   ?��?���? �뙴?���? �뵳?��껋쾵 �슖?���?  404error �굢?���? �뙴?���? ?��?��???��?��?��?��?��?�� �굢?���? ?��?��?��?��?��츊占?���? �뵳?���? ?��?��츎�?��?��?��?��?��?��?�� ->  ?��?��겱�?���룆�뾼?��?���? ?����?���뿉  web.xml?��?��?��  ?��?��쨨占?���?寃�
       
      // (web.xml �굢?���? �땻?���? <servlet> ?��?��쨨占?���?寃깍?��寃�    �뤆�룇�듌?��?���?)
      // Spring MVC  �걡�뜽�뿉?��?��츋占?��?�� ?��?���?  �땻?���? ?��?��?�� ?��?���?  ?��?���? �뜮?���?  ?��?���? �땻?���? �뇡?���? ?��?���?  ?��껓옙 ?��?���? ?��?���? ?��?���? �뤆�룇?��?��?���뮁紐�   繹먲?�� �땻?���? �뇡?���? ?��?��?��.
      AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
      servletAppContext.register(ServletAppContext.class);

      //  ?��?��뭵癲?��?��  �뛾�룇裕뉑?��?���?  ?��?���?  ?��?��뭵癲?��?��  ?��?���? ?��?��?��?��?��?��?�� �뇡?���? ?��?���?  �땻�슞��?�겫�뻹?�� ?��?���? DispatcherServlet ?��?��?���슖?���?   �땻?���? ?��?��?�� �뜮?��?���?  ?��?��?��.
      DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
      // ?��?��린占?��걝�?��궘�?��  ?��?���?�슖?���?   �땻?���? �젆?���? 筌랃?�� servletContext�뤆�룇?��?��?���뮁紐�   ?��?��?�� ?��?���? �뇡?���? �굢?���? servlet ?��?��?���겫?���?  load-on
      ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);

      // ?��?���? �뤆?���?   �땻?���? ?��?��?��
      servlet.setLoadOnStartup(1);// �뤆?���?  ?��?��궋占?��?��?��?��?��  �뛾�룇?��?��?��?���? ?���占�? ?��?��?���뇦?��?��쪚占?��?�� ?��?���?  ?��?��?��
      servlet.addMapping("/");

      // ==================================================================
      // (web.xml �굢?���? �땻?���? <context-param>?��?��쨨占?���?寃깍?��寃�    �뤆�룇�듌?��?���?)
      // Bean ?��?���?  ?��?��?�� ?��?���? �뇡?���? ?��?���?  ?��껓옙 ?��?���? ?��?��츩占?��?��  ?��?��?��  ?��?��?�� �뇡?���? ?��?��?��
      AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
      rootAppContext.register(RootAppContext.class);
      // (web.xml �굢?���? �땻?���? <listener>?��?��쨨占?���?寃깍?��寃�    �뤆�룇�듌?��?���?)
      ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
      servletContext.addListener(listener);
      // (web.xml �굢?���? �땻?���? <filter>?��?��쨨占?���?寃깍?��寃�    �뤆�룇�듌?��?���?)
      //  ?��?��?�� ?��?��?���?껋꼶�?멱땻?���?  ?��?��?��?��?��??�겫�뼔�럠  �땻?���? ?��?��?��
      FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
      filter.setInitParameter("encoding", "UTF-8");
      // dispatcher �굢?���?  ?��?���? �뜮?���? �땻?���? ?��?��?���겫?���?  筌랃?�� Servlet �굢?���? UTF-8�슖?���?  encoding �뇡?��?��?��?��?��쪚占?��?�� ?��?���? ?��?��쨨占?���?寃깍?��寃� 
      filter.addMappingForServletNames(null, false, "dispatcher");

   }*/
   
	public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer {
		   // DispatcherServlet�뿉 留ㅽ븨��? �슂泥� 二쇱?��?���? ��?��?���븳�떎.
		   @Override
		   protected String[] getServletMappings() {
		      // TODO Auto-generated method stub
		      return new String[] { "/" };
		   }

		   // Spring MVC �봽濡쒖?���듃 �꽕�젙�쓣 �쐞�븳 �겢�옒�뒪?���? 吏��젙�븳�떎.
		   @Override
		   protected Class<?>[] getServletConfigClasses() {
		      // TODO Auto-generated method stub
		      return new Class[] { ServletAppContext.class };
		   }

		   // �봽濡쒖?���듃�뿉�꽌 �궗�슜�븷 Bean�뱾�쓣 �젙�쓽湲� �쐞�븳 �겢�옒�뒪?���? 吏��젙�븳�떎.
		   @Override
		   protected Class<?>[] getRootConfigClasses() {
		      // TODO Auto-generated method stub
		      return new Class[] { RootAppContext.class };
		   }

		   // �뙆�씪誘명�? �씤?��붾뵫 �븘�꽣 �꽕�젙
		   @Override
		   protected Filter[] getServletFilters() {
		      // TODO Auto-generated method stub
		      CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		      encodingFilter.setEncoding("UTF-8");
		      return new Filter[] {encodingFilter};
		   }
   
 //�젙�쟻�뜲�씠�꽣�쓽 �솚寃쎌꽕�?�� : �슜�웾
   //null: �궗�슜�옄媛� �엯�젰�븳 �궡�슜�쓣 �엫�떆湲곗뼲��? �븘�뙆移섑?��?�볦뿉��? �젣?�듯�?�뒗 �꽌踰꾩?�� �엫�떆湲곗뼲�?���냼
   //52428800 :  �뾽濡쒕�? �뜲�씠�꽣�쓽 �슜�웾 (1024*50) 50M濡� �꽕�젙
   //524288000 : �뙆�씪�뜲�씠�꽣?���? �룷�븿�븳 �쟾泥댁?���웾 500M �꽕�젙
   //0 : �뙆�씪�쓽 �엫?�꾧�?(�뜲�씠�꽣?���? 諛쏆븘��? �옄�룞�쑝濡� ���옣)
   @Override
   protected void customizeRegistration(Dynamic registration) {
	   super.customizeRegistration(registration);
	   MultipartConfigElement config1 = new MultipartConfigElement(null,52428800, 524288000, 0 );
	   registration.setMultipartConfig(config1);
   }

}