package com.helloworld.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.helloworld.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.helloworld.app.server.repository.CoreContactsRepository;
import com.helloworld.app.shared.contacts.CoreContacts;
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
import com.helloworld.app.shared.contacts.Gender;
import com.helloworld.app.server.repository.GenderRepository;
import com.helloworld.app.shared.location.Language;
import com.helloworld.app.server.repository.LanguageRepository;
import com.helloworld.app.shared.location.Timezone;
import com.helloworld.app.server.repository.TimezoneRepository;
import com.helloworld.app.shared.contacts.Title;
import com.helloworld.app.server.repository.TitleRepository;
import com.helloworld.app.shared.location.Address;
import com.helloworld.app.server.repository.AddressRepository;
import com.helloworld.app.shared.location.AddressType;
import com.helloworld.app.server.repository.AddressTypeRepository;
import com.helloworld.app.shared.location.City;
import com.helloworld.app.server.repository.CityRepository;
import com.helloworld.app.shared.location.Country;
import com.helloworld.app.server.repository.CountryRepository;
import com.helloworld.app.shared.location.State;
import com.helloworld.app.server.repository.StateRepository;
import com.helloworld.app.shared.contacts.CommunicationData;
import com.helloworld.app.shared.contacts.CommunicationGroup;
import com.helloworld.app.server.repository.CommunicationGroupRepository;
import com.helloworld.app.shared.contacts.CommunicationType;
import com.helloworld.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("cD4Erf9bgzwHKt4qnf6wniuNpeMjasN7lyqAGiMUxIuoWaHGOH");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("e1");
            language.setAlpha3("gwC");
            language.setAlpha4("aGtv");
            language.setAlpha4parentid(11);
            language.setLanguage("fow5Jwtnjjdd065pKzCqr3SevRu3iihl2cKblNS4p6CUetSuls");
            language.setLanguageDescription("a4Csl90ZtdFZMIyKIcZwWkssDB5CSQCDLBmSNlF8ozI8PfPhTF");
            language.setLanguageIcon("CuNTSnnJIwUQfMbYv3PesVvAjrC0HOtFkEImW54S8KewmUQ9F8");
            language.setLanguageType("r5nUaqmPRyf6pwLEGpHxlXLx9wgZwrYC");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("2LtNJoFciOFB9fEvwfrwSHkNH4NnI71Wljpa2UVbgom9QwBATN");
            timezone.setCountry("GYeFEWFLHdhI4qphqRd8vNYwepLbgsN2kNKFy053ou69pK5ZIZ");
            timezone.setGmtLabel("PKGKCmkTgmgZiDsGkbuTKmNhAcWf9neepxPI5lY7m8yKOS0SKl");
            timezone.setTimeZoneLabel("zsYY0blNGfj4S898ZFu2fGRzrPyvRorprRMRK2FZlSgJUgPBxE");
            timezone.setUtcdifference(11);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("lLXlqVewssMx0Hx9jwhR7MgEv9OSef4B697G3CS9zPxWjPhbGr");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(116);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("cka4MvaS25uiHDNYtw9UjZzd5BcJyjZyNlK8jZuD8TdkRWOwZH");
            corecontacts.setFirstName("vBvWWhTMAahuWLj0EoyuDE2BRkaALhHIepNfTUHmLewO3KBJEa");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("NGQwNxNlUId12TWmsQU5nVUOllOhLww9TyCsiBjARS7jDFzfiz");
            corecontacts.setMiddleName("c0LdrLzjvUc63JWhDlHR9eZjCSDk7rI1TB82MdCqyYU8Kgi74E");
            corecontacts.setNativeFirstName("a1FuXMRSLXExGO5HAPeARZiHrrp0eec3jt20Dt2F5dHkFHrnEO");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("ts7rZob31bBjho9tafLcvXKMXYo7IDu58Ooa8uyWJZUnqvExQF");
            corecontacts.setNativeMiddleName("KfEzmlNKWK0zlLTiXh7yZOhI8GyKILH1ZsuDHiL8yk56rDSdPt");
            corecontacts.setNativeTitle("I8iqB2TZlwuGU3TI0yrKIufgt4etjO1c70rn2s4lFZvvUo2uBK");
            corecontacts.setPhoneNumber("SYOtDaI79zpLOxaN0phy");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("apcoxTgmwDTf80qZH5vNgX17aJlik6a0Y5k7omvgy6o5DqBsjN");
            address.setAddress2("9P5UqjNt9knLwWfICQkv59cL0moKyKN0JDRtxnednL3CtZL4bw");
            address.setAddress3("4g0eCnH9VqbdFSe9VJnXVSz8VukDEMrsdv2gq4MZdDsXpakw58");
            address.setAddressLabel("yNm1AQm1oJK");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("w5PTYlxa2zJ6rcLmtnGGMIMscRYEk1nQPJnLSWulKC0LeIAIKc");
            addresstype.setAddressTypeDesc("WcNxL9FWMdKTj06ONJU5QvstCCP0ih8FT17MgKKDaTAvnSMHrT");
            addresstype.setAddressTypeIcon("M4BHtbwZf4g6sZYnkQWAZ3FW7pBS8nij61xbSMx5YK1irDce6o");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("Vnvz3wVuahJGKXEs6MDBeoWNbCOMwZy0");
            city.setCityDescription("B1V0qvgYEUqkYhtEiPeRxKbpt75Ynvo423lotjJj0qLbZ3jO7p");
            city.setCityFlag("MaAL4FqFk9Ri0wK1RAdwFa6YPgEWEFhNcduCQFCzWFvHPAHwmM");
            city.setCityLatitude(4);
            city.setCityLongitude(10);
            city.setCityName("RGsVgNmnOU0l0hUzdhXFhIgt94iBB3bxiWIGuZtaqtnOaWzHRo");
            Country country = new Country();
            country.setCapital("fywkhDkV35lPtLONqYwJPIVcKiSpLVhg");
            country.setCapitalLatitude(0);
            country.setCapitalLongitude(3);
            country.setCountryCode1("VfB");
            country.setCountryCode2("xGn");
            country.setCountryFlag("3eKOOUSTW6n6ApX0UHVR0dh2CKjnUasngM1r8aEDT0QAHvPL0A");
            country.setCountryName("H0r1jRSN6eGQwnbEfNGRf8RO2aAnnupJ4KUTgmac82BUYEYbzP");
            country.setCurrencyCode("wBo");
            country.setCurrencyName("X39w0JxxSTA0SviaLMrEL9xAGkTyPElFpm3PcPgZuYROqiTe1u");
            country.setCurrencySymbol("VTjrtqTC7fXNXkk4fI0y7N0MIAKsVNFw");
            country.setIsoNumeric(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("ZOBFQiVsCOTbb5RfCEKqpTVflg5Gi7jYrQdOsq2oQGJn8gaStP");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(10);
            state.setStateCode(2);
            state.setStateCodeChar2("hasB2KcPKaS2j20KzRmYBhtFWNSWLg6i");
            state.setStateCodeChar3("v3HfCuYI9sx49vhDH4T4CY0oIPCpOTGl");
            state.setStateDescription("4jSziVXmhxrJCsWaXjaeKwnbXEAvb8SDzIQ0SZnOzt5dhR263Y");
            state.setStateFlag("9n4BC1PJKmwHSuKlNZnilOfeNOCycCG6gEnDNtfcN94z1HG6zy");
            state.setStateName("qQkaWvjjrpWPkipzPHDsRxW06lKbFGv6c9ZR6pAfRcRjLi11lK");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("UIHyX9yfr8tyW6xIlEGdHIVj7AdPYDin");
            city.setCityDescription("NcCcBjC4A75IDrLQ2r2oWMkwWegXvYbwmJUeyksK58AjZ8CTC5");
            city.setCityFlag("AUrzK1xZ37ADa4Odn6HTVDxPcf3xm25A6wgoSmPABf4KrW7O1Z");
            city.setCityLatitude(9);
            city.setCityLongitude(6);
            city.setCityName("oZKFlGNf3iKpCVL2HP1vXdyImcjuK9Ak2Lm2vUC26BFjVVhQgk");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("BmKyOOkNgK4sDcvzQKl36gvmWPLlznTdYbxdhjqct3nhSPERdg");
            address.setAddress2("qMwmcR4EOruOdhotAuC1u3VX3k1aRTPQsWWEVSUGIxrn4gucPy");
            address.setAddress3("wQmt3rqKewEZbQqVm37br669OU8WqFJ6NfJQPAzibHmFUfCKMn");
            address.setAddressLabel("O9MytwbyvUV");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("r2iDyb2XRZDpLHY4wFkwFymfgT56a2vNI3LSO4KUPmgxBjtAaS");
            address.setLongitude("FGSpLXVJ6IwsrUAipe5L5k5BVpvT17SXMOkzjwFwhDOGjbK6VY");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("WphBbz");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("Mhw");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("SY9kMCgbfQMcgk273mXH5Orkc94M4wwMHGRsbpzJlcRTIFIKa7");
            communicationgroup.setCommGroupName("KfOvqC7EdvFoeAuGokxUqCIISgoj3dX7oYwTcMHFtI0xP90Tcc");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("4bx9N5d6Xg8Pgg118gqMZd1333SuBXvBMLUOrBAaSO8mRXdGmv");
            communicationtype.setCommTypeName("k4x8nkzGHLvkDgBaRA2vmWI9NDu2lTpxCxTpVaqi99ZnrUYdlg");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("LDP");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(65);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("gKz8FRrmOCjNkmNMuOdurb9xxFl6uMK5n5ZiPl0MiH2z2YUCnA");
            corecontacts.setFirstName("Jq3ytd7VZ6tjHmihoHydBIqsPlFFXzLPVSvpsgPatMXGNhTK08");
            corecontacts.setLastName("PApMTD3zPfnb2avcFV4YwiF5G5hs2QcB1ou0b3rawFPnpsathu");
            corecontacts.setMiddleName("B7RLCDM5M5SGogrjOlR6rQhkovFOKUm0uBJAqoMAUn64YCXIK6");
            corecontacts.setNativeFirstName("GccaiQzS2ul9OUqk8SfVc5M6lM8qx98P9m6S1StFZOOsjQrmNS");
            corecontacts.setNativeLastName("tBAIntgdGTVX2RHFBkFDawvTuoCPOcdG2cX9TBZJTQH98ooCeB");
            corecontacts.setNativeMiddleName("ErRAnSny16gduRs8nJngbBNK6zBE8w7GGL9hxmC2GrEmdFijpM");
            corecontacts.setNativeTitle("XIXhs7vLXH4t3jh9jWR4t4ba7LTqMuTr48HQOOXBbARn5ooKSa");
            corecontacts.setPhoneNumber("c2iDQPcc5jkmFVIF3iHj");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBytimeZone() {
        try {
            java.util.List<CoreContacts> listoftimeZone = corecontactsRepository.findByTimeZone((java.lang.String) map.get("TimezonePrimaryKey"));
            if (listoftimeZone.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
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
