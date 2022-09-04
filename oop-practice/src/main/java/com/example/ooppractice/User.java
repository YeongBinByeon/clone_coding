package com.example.ooppractice;

public class User {
    private String password;

    public void initPassword(PasswordGeneratePolicy passwordGeneratePolicy){

        //AS-IS : 내부에서 생성하는 높은 결합으로 테스트 코드 작성에 어려움
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
//        String password = randomPasswordGenerator.generatePassword();

        //TO-BE : 테스트하기 쉬운 코드를 작성하기 위하여 상위 인터페이스를 선언하고 인터페이스를 의존하도록 구현함
        // . 인터페이스를 통하여 로직을 주입받아서 낮은 결합도를 가진 설계를 얻고, 테스트 코드 개발도 용이하게 바뀜
        String password = passwordGeneratePolicy.generatePassword();

        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */
        if (password.length() >= 8 && password.length()<=12){
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
