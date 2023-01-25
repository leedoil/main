package kr.co.led.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.led.beans.UserBean;
import kr.co.led.interceptor.CheckAdminInterceptor;
import kr.co.led.interceptor.CheckLoginInterceptor;
import kr.co.led.interceptor.TopMenuInterceptor;
import kr.co.led.mapper.AdminMapper;
import kr.co.led.mapper.AnswerMapper;
import kr.co.led.mapper.CartMapper;
import kr.co.led.mapper.NoticeMapper;
import kr.co.led.mapper.OrderMapper;
import kr.co.led.mapper.ProductMapper;
import kr.co.led.mapper.QuestionMapper;
import kr.co.led.mapper.ReviewMapper;
import kr.co.led.mapper.UserMapper;
import kr.co.led.mapper.WishListMapper;
import kr.co.led.service.NoticeService;
import kr.co.led.service.QuestionService;

//Spring MVC ������Ʈ�� ���õ� ������ �ϴ� Ŭ����
//(servlet-context���� <annotation-driven/>�� ����)
@Configuration 
//Controller ������̼��� ���õǾ� �ִ� Ŭ������ Controller�� ����Ѵ�.
@EnableWebMvc
//��ĵ�� ��Ű���� �����Ѵ�
@ComponentScan("kr.co.led.controller")
@ComponentScan("kr.co.led.dao")
@ComponentScan("kr.co.led.service")
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer {
   
   @Value("${db.classname}")
      private String db_classname;
   
      @Value("${db.url}")
      private String db_url;
   
      @Value("${db.username}")
      private String db_username;
   
      @Value("${db.password}")
      private String db_password;
   
      @Resource(name="loginUserBean")
      private UserBean loginUserBean;
   
      @Autowired
      private NoticeService noticeService;
   
      @Autowired
      private QuestionService questionService;

      @Autowired
      private UserBean adminBean;
   
    // Controller�� �޼��尡 ��ȯ�ϴ� jsp�� �̸� �յڿ� ��ο� Ȯ���ڸ� �����ֵ��� �����Ѵ�.
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
         // TODO Auto-generated method stub
         WebMvcConfigurer.super.configureViewResolvers(registry);
         registry.jsp("/WEB-INF/views/", ".jsp");
    }
      
    // ���� ������ ��θ� �����Ѵ�.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
         // TODO Auto-generated method stub
         WebMvcConfigurer.super.addResourceHandlers(registry);
         registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }
      
    @Bean
    public BasicDataSource dataSource() {
         BasicDataSource source = new BasicDataSource();
         source.setDriverClassName(db_classname);
         source.setUrl(db_url);
         source.setUsername(db_username);
         source.setPassword(db_password);
         
         return source;
    }
      
    // �������� ���� ������ �����ϴ� ��ü
    @Bean
    public SqlSessionFactory factory(BasicDataSource source) throws Exception{
         SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
         
         factoryBean.setDataSource(source);
         SqlSessionFactory factory = factoryBean.getObject();
         return factory;
    }
      
    // ������ ������ ���� ��ü(Mapper ����)
      
    @Bean
    public MapperFactoryBean<UserMapper> getUserMapper(SqlSessionFactory factory) throws Exception{
         MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<UserMapper>(UserMapper.class);
         factoryBean.setSqlSessionFactory(factory);
         return factoryBean;
      }
      
    @Bean
    public MapperFactoryBean<QuestionMapper> getQuestionMapper(SqlSessionFactory factory) throws Exception{
       MapperFactoryBean<QuestionMapper> factoryBean = new MapperFactoryBean<QuestionMapper>(QuestionMapper.class);
       factoryBean.setSqlSessionFactory(factory);
       return factoryBean;
      }
      
   @Bean
   public MapperFactoryBean<AnswerMapper> getAnswerMapper(SqlSessionFactory factory) throws Exception{
      MapperFactoryBean<AnswerMapper> factoryBean = new MapperFactoryBean<AnswerMapper>(AnswerMapper.class);
      factoryBean.setSqlSessionFactory(factory);
      return factoryBean;
   }
      
   @Bean
   public MapperFactoryBean<NoticeMapper> getNoticeMapper(SqlSessionFactory factory) throws Exception{
      MapperFactoryBean<NoticeMapper> factoryBean = new MapperFactoryBean<NoticeMapper>(NoticeMapper.class);
      factoryBean.setSqlSessionFactory(factory);
      return factoryBean;
   }
      
   @Bean
   public MapperFactoryBean<ProductMapper> getProductMapper(SqlSessionFactory factory) throws Exception {
       MapperFactoryBean<ProductMapper> factoryBean = new MapperFactoryBean<ProductMapper>(ProductMapper.class);
       factoryBean.setSqlSessionFactory(factory);
       return factoryBean;
    }

   @Bean
   public MapperFactoryBean<OrderMapper> getOrderMapper(SqlSessionFactory factory) throws Exception{
      MapperFactoryBean<OrderMapper> factoryBean = new MapperFactoryBean<OrderMapper>(OrderMapper.class);
      factoryBean.setSqlSessionFactory(factory);
      return factoryBean;
   }

   @Bean
   public MapperFactoryBean<CartMapper> getCartMapper(SqlSessionFactory factory) throws Exception{
      MapperFactoryBean<CartMapper> factoryBean = new MapperFactoryBean<CartMapper>(CartMapper.class);
      factoryBean.setSqlSessionFactory(factory);
      return factoryBean;
   }
      
    @Bean
     public MapperFactoryBean<WishListMapper> getWishListMapper(SqlSessionFactory factory) throws Exception{
        MapperFactoryBean<WishListMapper> factoryBean = new MapperFactoryBean<WishListMapper>(WishListMapper.class);
        factoryBean.setSqlSessionFactory(factory);
        return factoryBean;
     }

    @Bean
    public MapperFactoryBean<ReviewMapper> getReviewMapper(SqlSessionFactory factory) throws Exception{
       MapperFactoryBean<ReviewMapper> factoryBean = new MapperFactoryBean<ReviewMapper>(ReviewMapper.class);
       factoryBean.setSqlSessionFactory(factory);
       return factoryBean;
    }
    
    @Bean
    public MapperFactoryBean<AdminMapper> getAdminMapper(SqlSessionFactory factory) throws Exception{
    	MapperFactoryBean<AdminMapper> factoryBean = new MapperFactoryBean<AdminMapper>(AdminMapper.class);
    	factoryBean.setSqlSessionFactory(factory);
    	return factoryBean;
    }

   @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
         ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
         
         res.setBasenames("/WEB-INF/properties/error_message");
         return res; 
   }
       //Error
      //�ҽ�(MyBatis����̹� ����)�� �޼���(��ȿ�� �˻�)�� �и��ϴ� �ڵ�
   @Bean
    public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
      
    @Bean
   public StandardServletMultipartResolver multipartResolver() {
      return new StandardServletMultipartResolver();
   }
      //-----------------------------------------------------------------------------------------
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         
        WebMvcConfigurer.super.addInterceptors(registry);
         
        TopMenuInterceptor topMenuInterceptor=new TopMenuInterceptor(loginUserBean);
         
        InterceptorRegistration reg1=registry.addInterceptor(topMenuInterceptor);
         
        reg1.addPathPatterns("/**");//��� ��û �ּҿ� ���ؼ� ��ȯ
    //-----------------------------------------------------------------------------------------
         
        CheckLoginInterceptor checkLoginInterceptor=new CheckLoginInterceptor(loginUserBean);
        InterceptorRegistration reg2=registry.addInterceptor(checkLoginInterceptor);
         
        reg2.addPathPatterns("/user_modify", "/user_logout", "/board_answer", "/board_write", "/notice_delete", "/notice_write",
                        "/order");
        reg2.excludePathPatterns("/board_list", "/board_read", "/notice_list", "/notice_read"); //���� : �α������� �ʾƵ� �̿��� �� �ִ� ī�װ�
         
    
       CheckAdminInterceptor checkAdminInterceptor = new CheckAdminInterceptor(adminBean);
       InterceptorRegistration reg4 = registry.addInterceptor(checkAdminInterceptor);

       reg4.addPathPatterns("admin_userlist", "admin_siteInfo");
    }
}