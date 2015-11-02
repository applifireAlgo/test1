package com.helloworld.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.helloworld.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.helloworld.app.server.repository.VillageRepository;
import com.helloworld.app.shared.location.Village;
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
import com.helloworld.app.shared.location.Country;
import com.helloworld.app.server.repository.CountryRepository;
import com.helloworld.app.shared.location.District;
import com.helloworld.app.server.repository.DistrictRepository;
import com.helloworld.app.shared.location.Region;
import com.helloworld.app.server.repository.RegionRepository;
import com.helloworld.app.shared.location.State;
import com.helloworld.app.server.repository.StateRepository;
import com.helloworld.app.shared.location.Taluka;
import com.helloworld.app.server.repository.TalukaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class VillageTestCase {

    @Autowired
    private VillageRepository<Village> villageRepository;

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
            Country country = new Country();
            country.setCapital("ruQOmo8QSh6Zm8p7wWVTcICnk9H4jjAr");
            country.setCapitalLatitude(8);
            country.setCapitalLongitude(11);
            country.setCountryCode1("sTl");
            country.setCountryCode2("dmd");
            country.setCountryFlag("bfaPmoWP5k8YZu06T9rvfv2dAbU7YwIQsh8k5JZr8F8xVukgMU");
            country.setCountryName("dlRe8jQpK91aYqqUBFvh33Y8ZecuRsnEz7BeMUWDL2fkSo19Bu");
            country.setCurrencyCode("Iql");
            country.setCurrencyName("pzREP174cjj5XWwEnvrKFnYnLdK6kzPCVmqUeSu3Mnj26rdEfl");
            country.setCurrencySymbol("y12g5l8GrhZTydCefgcfIvzDkYZI4gpc");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("Hx78JKIx8QMtkVnHMSAimzTc6m84wVup");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("PrpkV1AM7HJVrFSS11b7nyAIUwQeXan4mN5dJZtktdpMsrzFa7");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(1);
            state.setStateCode(0);
            state.setStateCodeChar2("CwhvkLSM9t2IoBRNoFMhhVIbmJpA0vb4");
            state.setStateCodeChar3("Gpe9RsQFCyY9zwt9CAiJU8V58uiPt6dC");
            state.setStateDescription("XCKrdRPM7xpGVO2Etud24gZ96AB7GHye89toBN5I0mvtB3nw7W");
            state.setStateFlag("xT1BL7HLk3nBae9FlNszni7LS4UYjmwysdCslwLAz4EKqIqdR0");
            state.setStateName("AHPGe5SWJchVDrZ5XMx4gnRcSH8sSL90JGs9PnkwiLfBqbyghb");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(0);
            region.setRegionCodeChar2("GqGtJRmwreEuc8gO188Ghdw7eRQs4NrV");
            region.setRegionDescription("HcT5sXcFawEhyTZKmmGWKBeqBIxGuY8PNK4J296ENIl8IT5v6h");
            region.setRegionFlag("tPKIpeNsJ2mENKMaJAjuUV6RXaoVPxVLQWDqqKElOfR6QAMtRx");
            region.setRegionLatitude(6);
            region.setRegionLongitude(8);
            region.setRegionName("mTSqIhwUTqt2kywWkgkXskkkCfpBmgSnr57ET8qvdCQOqab9QC");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("eL12wyg8nitJpuKvgD4E1jjLpL5YyvEu");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("8X5xFE7t7bwIsZfCVkvB8GtTDdhcjNdNTOZromWhcwjTmqAiGY");
            district.setDistrictFlag("QvwSrSAD7R56pfiSFpHDsAZynWE16gviTdO42SJGsuN7KYfj64");
            district.setDistrictLatitude(7);
            district.setDistrictLongitude(1);
            district.setName("vAvue7TAdqEsrOQwEdEFtTuJjbUUBnLoJQuuBeeWmQMBsZI9zK");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setTalukaCode("4P5YMohF2q7n8LQ0B5ginwXaXWrM2lxg");
            taluka.setTalukaDescription("mzfytJ2AhoxrLFQ0nM2L186UyZNHgmnKLkmvegs9fcLnQScTJn");
            taluka.setTalukaFlag("tOnmWQRQhKyy1bimwxDkpZpNmmwY2k68hFXw9wARLdgoUqlqBc");
            taluka.setTalukaLatitude(6);
            taluka.setTalukaLongitude(5);
            taluka.setTalukaName("BHPRtTIXQissZCVisuw1FQxSglx8nY2DAYNRzQnGCkD9iQnNu5");
            Taluka TalukaTest = talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
            Village village = new Village();
            village.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setTalukaaId((java.lang.String) TalukaTest._getPrimarykey());
            village.setVillageCode("RXvDFQh4AxRI6MXcg0i94xCLyiLXX04M");
            village.setVillageDescription("JpbauZuPi6AMHzp20SShUiagLWbytnQzpeK8fh0rAMjYRBsXEy");
            village.setVillageFlag("3GVhCXLxup7XkbDG0ZuP6b0n9xtau9Fbg9dtB9etKjZamvITwM");
            village.setVillageLatitude(3);
            village.setVillageLongtitude(9);
            village.setVillageName("bR24o2NVGU1DdHAkZi05pdeuaz8pMRCADnOhPco8GSvmqQYTfK");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            village.setEntityValidator(entityValidator);
            village.isValid();
            villageRepository.save(village);
            map.put("VillagePrimaryKey", village._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private DistrictRepository<District> districtRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            Village village = villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
            village.setVersionId(1);
            village.setVillageCode("nqn1O882gng2PGJBI8mWFKXes3LC7VFa");
            village.setVillageDescription("I3PZrFLFaiI01KV2ZEZPhvhwq5vxPyk2rvkn49toWQGvLG35eE");
            village.setVillageFlag("DjvLbRAi6FrWPWBtAQYdBHgFEV4WVSJt3cbHClxP7QhXsVyd3v");
            village.setVillageLatitude(10);
            village.setVillageLongtitude(8);
            village.setVillageName("MhUhDHf4DQYBdknn1VK2PcKI4hFDcUbvZNqLzv2Sz2XMyRrtu9");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            villageRepository.update(village);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Village> listofcountryId = villageRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBydistrictId() {
        try {
            java.util.List<Village> listofdistrictId = villageRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
            if (listofdistrictId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<Village> listofregionId = villageRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
            if (listofregionId.size() == 0) {
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
            java.util.List<Village> listofstateId = villageRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3findBytalukaaId() {
        try {
            java.util.List<Village> listoftalukaaId = villageRepository.findByTalukaaId((java.lang.String) map.get("TalukaPrimaryKey"));
            if (listoftalukaaId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.delete((java.lang.String) map.get("VillagePrimaryKey")); /* Deleting refrenced data */
            talukaRepository.delete((java.lang.String) map.get("TalukaPrimaryKey")); /* Deleting refrenced data */
            districtRepository.delete((java.lang.String) map.get("DistrictPrimaryKey")); /* Deleting refrenced data */
            regionRepository.delete((java.lang.String) map.get("RegionPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
