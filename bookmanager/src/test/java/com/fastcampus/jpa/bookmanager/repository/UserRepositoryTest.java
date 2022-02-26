package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    // 아래는 Repository Interface 메소드 실습 (1) 강의 내용
    @Test
    void crud(){
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        List<User> users2 = userRepository.findAllById(Lists.newArrayList(1L,3L,5L));

        User user1 = new User("jack", "jack@fastcampus.com");
        User user2 = new User("steve", "steve@fastcampus.com");
        userRepository.saveAll(Lists.newArrayList(user1,user2));
        userRepository.save(user1);
        users = userRepository.findAll();

        users.forEach(System.out::println);

        //User user = userRepository.getOne(1L);
        //System.out.println(user);

        User user = userRepository.findById(1L).orElse(null);
        System.out.println(user);
    }

    // 아래는 Repository Interface 메소드 실습 (2) 강의 내용
    @Test
    void crud1(){
        userRepository.saveAndFlush(new User("new martin", "martin@fastcampus.com"));

        userRepository.findAll().forEach(System.out::println);

        long count = userRepository.count();
        System.out.println(count);

        boolean exists = userRepository.existsById(1L);
        System.out.println(exists);

        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
        userRepository.deleteById(3L);

        userRepository.findAll().forEach(System.out::println);

        ////아래 deleteAll() 메서드는 전체 데이터 select를 수행한 후, 삭제 할 id별로 delete를 N번 수행한다.
        //userRepository.deleteAlluserRepository.findAllById(Lists.newArrayList(1L,3L));
        // 반면 아래 deleteInBatch 메서드는 deleteAll 메서드와 달리 전체 데이터를 select 하는 과정이 없고 where 조건문에
        // user0_.id in (
        //            ? , ?
        //        )
        // SQL문으로 삭제 할 data 조건을 한 번에 넣어서 DELETE sql을 한 번만 수행해서 속도가 더 빠르다.
        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L,3L)));
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void crud2(){
        // 한 페이지는 3(size)개로 구성되고 1번 index Page 가져오기
        Page<User> users = userRepository.findAll(PageRequest.of(1,3));

        System.out.println("page : " + users);
        // insert 5개 해서 5개
        System.out.println("totalElements : " + users.getTotalElements());
        // element 5개에 한 페이지 3개로 구성하니 전체 페이지는 2개
        System.out.println("totalPages : " + users.getTotalPages());
        // 두 번째 페이지 가져왔으니 해당 페이지에는 2개의 element만 존재함
        System.out.println("numberOfElements : " + users.getNumberOfElements());
        // sort는 적용 안해서 UNSORTED
        System.out.println("sort : " + users.getSort());
        // Page의 size는 3
        System.out.println("size : " + users.getSize());

        users.getContent().forEach(System.out::println);


    }
    @Test
    void crud3(){
        userRepository.save(new User("david", "david@fastcampus.com"));
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-updated@fastcampus.com");

        userRepository.save(user);
    }
}