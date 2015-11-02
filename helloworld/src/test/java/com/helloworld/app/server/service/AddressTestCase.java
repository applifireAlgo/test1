package com.helloworld.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.helloworld.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.helloworld.app.server.repository.AddressRepository;
import com.helloworld.app.shared.location.Address;
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
import com.helloworld.app.shared.location.AddressType;
import com.helloworld.app.server.repository.AddressTypeRepository;
import com.helloworld.app.shared.location.City;
import com.helloworld.app.server.repository.CityRepository;
import com.helloworld.app.shared.location.Country;
import com.helloworld.app.server.repository.CountryRepository;
import com.helloworld.app.shared.location.State;
import com.helloworld.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("eTPN47z6SoaOaMKjLjKZAex4Cw43Ed7HsPGJw8k8cB4KP3CQn8");
            addresstype.setAddressTypeDesc("Bjd87PSMpWnWbM3cMurdGUfhBfF8oFqffdPgtG68UrGExzDD7o");
            addresstype.setAddressTypeIcon("XkKrChjItlfPWlLnUdCU4l84GAFkYlY1UcHt9E3zrFMaUuB7G5");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("qEDV3qwymPVzNSAPMpbNpE2NsI5z2tfH");
            city.setCityDescription("KQFDV2agh35Iq6yg2V1MGVYF8ndOfgY8zkQSHmGS1v9DHBQb74");
            city.setCityFlag("PrYDVD291k9aA0ES8nKG8Sh9gx2jsE2fnjWpnrJUmKHvpssqks");
            city.setCityLatitude(0);
            city.setCityLongitude(11);
            city.setCityName("GPkUIHMV6uNjmmwBRfsFk9OJn6bZu8xF01fUlK4BdzHe42GSJ5");
            Country country = new Country();
            country.setCapital("vONQZrtQ4CrrgPX35pS1XXj31c44AsrS");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(4);
            country.setCountryCode1("2L3");
            country.setCountryCode2("tZL");
            country.setCountryFlag("YMxwz5ajcOFuz26BacOpY4fvZIdiqfKqfQZeFErIrLfZ5qQQA9");
            country.setCountryName("68WpXyBB85tMUhjdom42boSIis9tZZc0zmoJS0iGS0XxQK2Ieo");
            country.setCurrencyCode("pu4");
            country.setCurrencyName("OoYqcWugLJEkeIQbJkFxGtur073lzxWaH8x7D25s01VJbfA966");
            country.setCurrencySymbol("65K7eZtyOhm6ZvGiq1jl22vsGJqdXxsF");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("ciMzftmgyxj1xGbD1OphHvqMKYQGLkrDnsCh7DmECclxebciB6");
            state.setStateCapitalLatitude(11);
            state.setStateCapitalLongitude(2);
            state.setStateCode(0);
            state.setStateCodeChar2("IpgO1QaBQn2J0BHJHKoD1Qbq2Uz7QSBj");
            state.setStateCodeChar3("07figCHLoU8GfSva9XsL4Bj08y4Tetkq");
            state.setStateDescription("hp0JT0KQntp0LOjd8dnxTyTjqX89MkPf2uVSK3CMUQFszKQGbC");
            state.setStateFlag("zW3I5RWNF6poPmfQM47Qw8cxkrJpOzFw0eDgxvPpx6TxxgcNR5");
            state.setStateName("uYf0P70GVi3YAzs82YGFKpCRiAdAAP2UzIBsxJu4GYgAacRvTi");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("n2snqUmNST0VcnOsNzk3ZgRNvDvFtO2G");
            city.setCityDescription("pzSqlsKi28nC3ZZXaIgh5RqWre32xCC8SaKYaqd4AbeldfjZVp");
            city.setCityFlag("wUBbeIXH5fC7pJHWtTF9fE1XJe7fT4m1aIkApmC0hYaGUt3c2l");
            city.setCityLatitude(6);
            city.setCityLongitude(10);
            city.setCityName("DMnLe62nBIM8HDtUixsQITlrLTbMNkuYlL90nOWIaLWuVhpDGc");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("c576HjwtMeVb5wz01bPNdFxTjD8NteC3X6VaVTDhnT38Brz6Wg");
            address.setAddress2("IfGALBuWtyDqMtMUTtFSX2IST5u8cdmk5n0YCfB09RNnz57bGS");
            address.setAddress3("RKQHgvZxsnY9ooOH3gcnSbv0LqPfrSlJXxvBKQhUUu8amROibK");
            address.setAddressLabel("gajiUvczMGv");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("GslwLPyT2eorb1H80eaTaD7jd7xLryCN37Uo4CXfUFChAZsAxM");
            address.setLongitude("UvzWo36JASlwhNifhNyJnj8lC7X8dTUigNkaSJAGMqizqWWUN8");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("ee7L2h");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("BU3k5kzE2RHJJiYUtJYWqyypgZK4yvXn9IYoMipRdCdPVfN0pF");
            address.setAddress2("mQjOLiyURS7upiLWVAMeENNBPVYV0ydhsyyXnHFNUZmGlNVkPl");
            address.setAddress3("8evYYW1DSOXECpkvrmqmHjp0dblYZuYLD9jL9PhyvATKUl0139");
            address.setAddressLabel("tVgagBNCsfK");
            address.setLatitude("WxKN4nImuRf1MKC3sTBVNm5BuNdiuDBFsXpNJo2EthuiI1PPUT");
            address.setLongitude("o1DF8gucnnvLHCfUssfrpGH3WYKI7LlFl4zpiLomYV2Bhb8Cia");
            address.setVersionId(1);
            address.setZipcode("NHUEkp");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
