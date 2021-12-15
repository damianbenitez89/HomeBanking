package com.stark.homebanking.configurations;

import com.stark.homebanking.models.Cliente;
import com.stark.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    ClientRepository clientRepository;

    @Bean// genera un passwordEncoder en Application Context para que luego se pueda usar en cualquier lado de la aplicacion
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(inputName->{
            Cliente cliente = clientRepository.findByEmail(inputName);
            if(cliente !=null){
                return new User(cliente.getEmail(),cliente.getPassword(), AuthorityUtils.createAuthorityList("CLIENT"));//aca se pone una lista de autorizaciones en este caso es cliente , podria ser ADMINISTRATIVO, DOCENTE
            }else{
                throw new UsernameNotFoundException("Unknown user: "+inputName);
            }
        });
    }
}
