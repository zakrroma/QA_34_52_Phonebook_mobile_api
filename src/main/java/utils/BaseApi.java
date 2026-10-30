package utils;

import static utils.PropertiesReader.getProperty;

public interface BaseApi {
    // Authentication Controller
    String BASE_URL = getProperty("api.properties", "backendBaseUrl");
    String REG_URL = getProperty("api.properties", "backendRegUrl");
    String LOGIN_URL = getProperty("api.properties", "backendLoginUrl");

    // Contact Controller
    String GET_CONTACTS_URL = getProperty("api.properties", "backendGetContactsUrl");
    String POST_CONTACT_URL = getProperty("api.properties", "backendPostContactUrl");
    String PUT_CONTACT_URL = getProperty("api.properties", "backendPutContactUrl");
    String DELETE_CONTACT_URL = getProperty("api.properties", "backendDeleteContactUrl");
    String CLEAR_CONTACTS_URL = getProperty("api.properties", "backendClearContactsUrl");
}
