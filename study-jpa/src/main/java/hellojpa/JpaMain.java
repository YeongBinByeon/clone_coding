package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){

        // EntityManagerFactory는 애플리케이션 로딩 시점에 딱 하나만 만들어놔야 한다.
        // = 하나만 생성해서 애플리케이션 전체에서 공유해서 사용한다.
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

       // DB 커넥션을 얻어서 쿼리를 날리고 종료되는 그런 일관적인 단위를 수행할때 마다 EntityManager 를 꼭 만들어 주어야 한다.
        // 엔티티 매니저는 쓰레드간에 공유 X ( 매번 요청시마다 새로 생성하고, 쓰고 나면 바로 버려야 한다.)
        EntityManager em = emf.createEntityManager();

        // 아래 같은 일련의 과정이 정석적인 코드이다, 다만 실 사용시 annotation을 붙이면 스프링이 알아서 다 해준다.
        // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다.
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{
            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            Team team = new Team();
            team.setName("TeamA");

            member.changeTeam(team);
            em.persist(team);



            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();
            
            for(Member m : members){
                System.out.println("m.getUsername() = " + m.getUsername());
            }



            // 커밋하는 순간 데이터베이스에 INSERT SQL을 보낸다.
            tx.commit();
            System.out.println("333");
        } catch (Exception e){
            tx.rollback();
        } finally {
            // entity manager가 내부적으로 데이터베이스 커넥션을 물고 동작하기 때문에 사용을 다 하고 나면 꼭 닫아줘야 한다.
            em.close();
        }



        emf.close();
    }
}
