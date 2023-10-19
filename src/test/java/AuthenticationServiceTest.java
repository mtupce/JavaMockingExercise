/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import cz.upce.fei.inptp.databasedependency.business.AuthenticationService;
import cz.upce.fei.inptp.databasedependency.dao.PersonDAO;
import cz.upce.fei.inptp.databasedependency.entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author st58266
 */
public class AuthenticationServiceTest {
    
    AuthenticationService authenticationService;
    
    public AuthenticationServiceTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        PersonDAO mockedPersondao = mock(PersonDAO.class);
        
        when(mockedPersondao.load("name = 'user'")).thenReturn(new Person(1, "user", AuthenticationService.encryptPassword("pass")));
        
        authenticationService = new AuthenticationService(mockedPersondao);
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void authenticatePass() {
         assertEquals(true, authenticationService.Authenticate("user", "pass"));
     }
     
     @Test
     public void authenticateFail() {
         assertEquals(false, authenticationService.Authenticate("user", "invalid"));
     }
     
     @Test
     public void authenticateWrongUser() {
         assertEquals(false, authenticationService.Authenticate("non_user", "pass"));
     }
}
