- [Tagging and Filtering JUnit Tests](https://www.baeldung.com/junit-filtering-tests)

show h2 usage in spring framework

#spring-test  
if use autowired like this in test class:  
@Autowired  
private EmployeeDAO employeeDao;
you should use the following annotaion  
@ExtendWith(SpringExtension.class)  
@ContextConfiguration(classes = { SpringJdbcConfig.class }, loader = AnnotationConfigContextLoader.class)    