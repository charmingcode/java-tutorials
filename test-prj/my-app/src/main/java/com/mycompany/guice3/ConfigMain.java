package com.mycompany.guice3;

import static com.google.inject.name.Names.named;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Named;
//通过注解自动绑定依赖，且注入常量
public class ConfigMain {

    private static class Client {
        @Inject
        @Named("config.server.ip")
        private String IP;
        
        @Inject
        @Named("config.server.port")
        private int port;
        
        @Inject
        @Named("config.server.username")
        private String username;
        
        @Inject
        @Named("config.server.password")
        private String password;

        public void work() {
            System.out.println("ip=" + IP);
            System.out.println("port=" + port);
            System.out.println("username=" + username);
            System.out.println("password=" + password);
            //
        }
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module() {
            @SuppressWarnings("unchecked")
            public void configure(Binder binder) {
                Properties p = new Properties();
                try {
                    p.load(new InputStreamReader(this.getClass()
                            .getResourceAsStream("server.config.properties")));
                } catch (IOException e) {
                    e.printStackTrace();
                    assert false;
                }
                Enumeration e = p.keys();
                while(e.hasMoreElements()) {
                    String key = (String)e.nextElement();
                    String value = (String)p.get(key);
                    binder.bindConstant().annotatedWith(named("config." + key)).to(value);
                }
            }
        });
        
        Client client = injector.getInstance(Client.class);
        client.work();
    }
}