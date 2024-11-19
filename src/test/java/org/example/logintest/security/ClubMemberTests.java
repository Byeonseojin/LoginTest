package org.example.logintest.security;

import org.example.logintest.entity.ClubMember;
import org.example.logintest.entity.ClubMemberRole;
import org.example.logintest.repository.ClubMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ClubMemberTests {
    @Autowired
    private ClubMemberRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertDummies(){
        // user1-user80:USER
        // USER81-USER90: USER, MANAGER
        // USER91-USER100: USER, MANAGER, ADMIN
        IntStream.rangeClosed(1,100).forEach(i->{
            ClubMember clubMember = ClubMember.builder()
                    .email("user"+i+"@kopo.ac.kr")
                    .name("사용자"+i)
                    .fromSocial(false)
                    .password(passwordEncoder.encode("1234"))
                    .build();
            clubMember.addMemberRole(ClubMemberRole.USER);
            if(i>80){
                clubMember.addMemberRole(ClubMemberRole.MANAGER);
            }
            if(i>90){
                clubMember.addMemberRole(ClubMemberRole.ADMIN);
            }
            repository.save(clubMember);
        });
    }

    @Test
    public void testRead() {
        Optional<ClubMember> result = repository.findByEmail("user1@kopo.ac.kr", false);
        ClubMember clubMember = result.get();
        System.out.println("❤❤❤" + clubMember);
    }
}
