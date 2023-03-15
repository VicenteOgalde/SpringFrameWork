package com.vicoga.config;

import com.vicoga.model.Customer;
import com.vicoga.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankUserDetails implements UserDetailsService {

    @Autowired
    CustomerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName,password=null;
        List<GrantedAuthority> authorities=null;
        List<Customer> customers=repository.findByEmail(username);
        if(customers.size()==0){
            throw new UsernameNotFoundException("user details not found for the user:"+username);

        }else {
            userName=customers.get(0).getEmail();
            password=customers.get(0).getPass();
            authorities=new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
        }
        return new User(username,password,authorities);



    }
}
