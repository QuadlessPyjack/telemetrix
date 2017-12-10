/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.UserRoles;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author bogdanv
 */
@Remote
public interface UserRolesFacadeRemote {

    void create(UserRoles userRoles);

    void edit(UserRoles userRoles);

    void remove(UserRoles userRoles);

    UserRoles find(Object id);

    List<UserRoles> findAll();

    List<UserRoles> findRange(int[] range);

    int count();
    
}
