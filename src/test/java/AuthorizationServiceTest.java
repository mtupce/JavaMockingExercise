/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import cz.upce.fei.inptp.databasedependency.business.AuthenticationService;
import cz.upce.fei.inptp.databasedependency.dao.PersonDAO;
import cz.upce.fei.inptp.databasedependency.dao.PersonRolesDAO;
import cz.upce.fei.inptp.databasedependency.entity.Person;
import cz.upce.fei.inptp.databasedependency.entity.PersonRole;
import cz.upce.fei.inptp.databasedependency.entity.Role;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author st58266
 */
public class AuthorizationServiceTest {
    
    Person person;
    
    public AuthorizationServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        //PersonDAO mockedPersondao = mock(PersonDAO.class);
        
        person = new Person(3, "user", "#&#&#&#");
        //when(mockedPersondao.getRoleWhereStringFor(person)).thenReturn("id = 3");
        
        PersonRolesDAO mockedPersonRolesdao = mock(PersonRolesDAO.class);
        List<Role> roles = new List<Role>();
        PersonRole returnedPersonRole = new PersonRole(person, roles);
        when(mockedPersonRolesdao.load("id = 3")).thenReturn(returnedPersonRole);
        
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void test1() {
         
     }
}
