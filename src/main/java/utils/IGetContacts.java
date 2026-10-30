package utils;

import dto.ContactsDto;
import dto.TokenDto;
import dto.UserDto;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static utils.PropertiesReader.getProperty;

public interface IGetContacts extends BaseApi {
    default int getContactCount()
    {
        UserDto user = UserDto.builder()
                .username(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();

        TokenDto tokenDto = given()
                .body(user)
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL + LOGIN_URL)
                .thenReturn()
                .getBody()
                .as(TokenDto.class);

        ContactsDto contacts = given()
                .contentType(ContentType.JSON)
                .header("Authorization", tokenDto.getToken())
                .when()
                .get(BASE_URL + GET_CONTACTS_URL)
                .then()
                .statusCode(200)
                .extract().as(ContactsDto.class);

        return contacts.getContacts().length;
    }
}
