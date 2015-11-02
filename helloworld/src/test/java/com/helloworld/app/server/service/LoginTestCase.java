package com.helloworld.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.helloworld.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.helloworld.app.server.repository.LoginRepository;
import com.helloworld.app.shared.authentication.Login;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.helloworld.app.shared.contacts.CoreContacts;
import com.helloworld.app.server.repository.CoreContactsRepository;
import com.helloworld.app.shared.contacts.Gender;
import com.helloworld.app.server.repository.GenderRepository;
import com.helloworld.app.shared.location.Language;
import com.helloworld.app.server.repository.LanguageRepository;
import com.helloworld.app.shared.location.Timezone;
import com.helloworld.app.server.repository.TimezoneRepository;
import com.helloworld.app.shared.contacts.Title;
import com.helloworld.app.server.repository.TitleRepository;
import com.helloworld.app.shared.authentication.User;
import com.helloworld.app.server.repository.UserRepository;
import com.helloworld.app.shared.authentication.UserAccessDomain;
import com.helloworld.app.server.repository.UserAccessDomainRepository;
import com.helloworld.app.shared.authentication.UserAccessLevel;
import com.helloworld.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(92);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("JySqIwivgJ9IROzhxWuvvvtTsNpQ76ZiAWYqe4eFDqInNCCSz1");
            corecontacts.setFirstName("Id0BN3t7LcEW1QttOJcLcLTvEZhq04nOxTuiaRQuiyVnwUgQ69");
            Gender gender = new Gender();
            gender.setGender("OI43jXn0q2GqZXZm7wS7ciEkRS7xNVgS3grTdQrjteKaYaq748");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("4I");
            language.setAlpha3("dNs");
            language.setAlpha4("PNiT");
            language.setAlpha4parentid(5);
            language.setLanguage("E4JgbqeLmp5JV33IJxPhrbZuGiEVwKGjRggqBYEk9xvmQcwkiF");
            language.setLanguageDescription("BnJJC29gmwMLdNozHnoM7WYrzhjLfdNKIBmBQ0w1leFxb7G8m9");
            language.setLanguageIcon("uyRueeCS1owmWaTHtL7ImMy0gJojHJwA8fMquOWJ9eE3ByZEeE");
            language.setLanguageType("rvY6JgGSCwXRjTTlWuOuLyDRRW4ANn6B");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("tFP4fOUs66AYuRbpis2JvqhFNSbUc2XGgLQPlskhXhSAgXhs8w");
            timezone.setCountry("DGtmHWHrQC3BqCPxYnPovGyndpxsthVmMvwdBQBEXlDxOzypqc");
            timezone.setGmtLabel("UbvVcUtE73jCyqyjOnShVRaYbtfTWktuPUqHqy9FQfyYlVIasT");
            timezone.setTimeZoneLabel("9xLkM5dzUeBHNrhee7glKmOYSNs6J0XlKOH91XGS7kHa9l0lzr");
            timezone.setUtcdifference(10);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("IXi3FUGdBvKUdkAppVOJ7UctvCewGFKZjisgFETLZ1NTlF4JK2");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(76);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("SKbn5yZbMsOThttlAi0k42kR8RFtTQvXOF89N1TtruyIOjp9z4");
            corecontacts.setFirstName("pqDSN4YAmBZ5L2lN9BPkc8QccwwkcFe6EtDSftg1GOrPlnGZzF");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("Q7AD5NzjzR76nCWBjVN1OhtyroaY2Hgo5wZkUgkUfSYpP0FZS7");
            corecontacts.setMiddleName("7fZMC4p305daVD35uGsfyb1e1tPFChKuWM87y2EtxHA4KCSJ1w");
            corecontacts.setNativeFirstName("8CA3rIrRCwEKHLtFcxi0ILTQtBX7HRALX1jyJJ4pZQyOzxO5Lr");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("kRRLmZlJIsh7VBRPtYlMweCicRU5YkeH84wIUzan0v1RRitTyW");
            corecontacts.setNativeMiddleName("CXHsBfQznqzPAhmRGRSNi3S39PU6sgTodtjoknybrlUXzRgUUw");
            corecontacts.setNativeTitle("QIqqIo2v4l4uybELOUtCJ5tMlNWeUpGYe4Yi0AOQGnIrfNkyAY");
            corecontacts.setPhoneNumber("fpxZe3UHNAbIyJMZnYbs");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("u4xr4RPaMGAnPDNzlhyJamiGVvKpQ3w6rcYbSkhV14kl8EwrGX");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3083);
            user.setUserAccessCode(0);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("cBjEJhzYnduZeNL5xIWGqKCP2DeYl7JgVzIfQQCSn2USrihF0y");
            useraccessdomain.setDomainHelp("wLyl3Bx4HMplv680p2roLdEjQUffqlIThu0oGmcwizeM1tUiH8");
            useraccessdomain.setDomainIcon("f06TjKqOBV0jJdtDn6KSlFEoOJfP9rZ0cjAmHTZGW9zsEsLx8p");
            useraccessdomain.setDomainName("sZXDZq8n5jTjAqPs8TucAWcklkWXxP9m0w2yefLYB7vxLrTg7A");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("uBgbxxbfl0Bx0XA68637pj8Q1zq5myGjn4s2REYeV20lXhnLzp");
            useraccesslevel.setLevelHelp("aBjrOhvESO9VFJtBRd1ZckpX0g5xLVZRj9mXfFKoWKzaRxRRRt");
            useraccesslevel.setLevelIcon("NdKFbbqdGyAypd4gfmRHyqkB6tCxfq7KOxfZh7y8yTizAqIbsh");
            useraccesslevel.setLevelName("QAxYn3xLcX5xQR2mpznPn8GzlROerkH5daslBfXUjOgeHFYs5p");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("DAc12MZZZTVwZwCdoGzmpdDE3myA381Oq4EjE87tblXBK4jHFZ");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3273);
            user.setUserAccessCode(4);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(11);
            login.setIsAuthenticated(true);
            login.setLoginId("iVSMR3HF4hYDbMVn7L0eUnYmLyyxCmzRpAYP2bHS73vL6XnRuD");
            login.setServerAuthImage("eWiiyfz9u5aFSM0aI49Jxn04kwqeDQgq");
            login.setServerAuthText("HNh0GUro8CxIxTqV");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(9);
            login.setLoginId("xrw9fttsr0iiTDE3EIwo2fskkrbS9yIiC71o8ygmLqiVvSz1yl");
            login.setServerAuthImage("j9DgbqRvcYPP0ESUTKWJZWs9A2QLo2T5");
            login.setServerAuthText("Tc3WrQYsX8dutXh3");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<Login> listofcontactId = loginRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<Login> listofuserId = loginRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
