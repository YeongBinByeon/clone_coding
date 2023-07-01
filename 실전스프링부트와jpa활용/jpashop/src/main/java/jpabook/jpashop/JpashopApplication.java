package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {

		SpringApplication.run(JpashopApplication.class, args);
	}

	// Entity를 직접 Response(외부 노출) 하는 경우는 지양해야 하는 방법임
	// 그러나 아래 member 변수 처럼
	//    @ManyToOne(fetch = FetchType.LAZY)
	//    @JoinColumn(name = "member_id")
	//    private Member member;
	// Jackson 라이브러리로 Response 위한 json 만들 때 LAZY 로딩이면 Member member에
	// 실제 데이터가 아닌 hibernate proxy 객체가 생성되어 저장되게되고, 해당 인스턴스를
	// jackson 라이브러리가 json으로 바꿀 수 없어서 에러 발생한다.
	// 이런 케이스 발생 시 proxy 객체는 null로 응답하도록 기능 지원하는 라이브러리가 아래 Hibernate5Module 이다.
	@Bean
	Hibernate5Module hibernate5Module(){
		Hibernate5Module hibernate5Module = new Hibernate5Module();
//		hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);
		return hibernate5Module;
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}
