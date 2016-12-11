package by.pvt.service;

import by.pvt.entity.Admin;
import by.pvt.entity.Client;
import by.pvt.entity.User;
import by.pvt.services.IAdminService;
import by.pvt.services.IClientService;
import by.pvt.services.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 12/11/2016.
 */
@Service("authService")
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private IClientService clientService;

    @Autowired
    private IAdminService adminService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userLogin)
            throws UsernameNotFoundException {
        try {
            List<User> listClient = clientService.getClientByLogin(userLogin);
            System.out.println("*******************listClient : " + listClient);
            List<User> listAdmin = adminService.getAdminByLogin(userLogin);
            System.out.println("*******************listAdmin : " + listAdmin);
            listClient.addAll(listAdmin);
            System.out.println("*******************listClient NEW : " + listClient);

            if (listClient.isEmpty() || listClient == null) {
                System.out.println("User not found");
                throw new UsernameNotFoundException("Username not found");
            }
            User user = listClient.get(0);
            return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                    true, true, true, true, getGrantedAuthorities(user));
        } catch (ServiceException e) {
            e.printStackTrace();
            return null;
        }

    }


    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        //get User Type (0-Client; 1-Admin)
        Integer typeUser = user.getUserType();
        String typeUserString = "CLIENT";
        if (typeUser == 0){
            typeUserString = "CLIENT";
        } else{
            if (typeUser == 1){
                typeUserString = "ADMIN";
            }
        }
            System.out.println("UserProfile : " + typeUserString );
            authorities.add(new SimpleGrantedAuthority("ROLE_" + typeUserString));

        System.out.print("authorities :" + authorities);
        return authorities;
    }

}
