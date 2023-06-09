package honeybee;

import java.util.Arrays;
import java.util.Scanner;

public class C11OOP {
    public static void main(String[] args) {
        // 입력한 정보(문자열)를 배열로 바꾸고
        // 다시 클래스에 정보(배열)를 넘기는 방식
        Scanner sc = new Scanner(System.in);

        System.out.println("학생 수 입력");
        int num = sc.nextInt();
        Person2[] students = new Person2[num];
        for (int i = 0; i < num; i++) {
            System.out.println("이름, 직업,나이, 성별,전화번호,주소를 입력하세요");
            String input = sc.next(); // 데이터 타입을 나누기가 어려워서 String으로 통일(하나뺴고)
            String[] info = input.split(",");  // 문자열을 한줄로 적는데 ,를 기준으로 나눔
            students[i] = new Person2(); // 설정한 학생수에 따른 정보 저장
            students[i].setPerson(info[0], info[1], Integer.parseInt(info[2]), info[3], info[4], info[5],info);
            System.out.println(Arrays.toString(info));  // 값이 배열로 전달되었는지 확인
        }
        // Arrays.copyOfRange(info, 6, info.length)
        for (Person2 student : students) {
            System.out.println(student);  // student에 값이 들어갔는지 확인용
            System.out.println(student.toString());  // student에 값이 들어갔는지 확인용
            System.out.println(Arrays.toString(student.getInfo())); // 배열타입의 멤버변수에 들어갔는지 확인용
        }

        // 클래스 종류
        // VO/DTO : ValueObject, Data Transfer Object
        // 계층간 데이터교환을 위한 자바빈즈를 의미
        // 값만 저장하기 위해 생성하는 클래스
        // 주로 데이터베이스 테이블의 각 열과 연계해서 작성

        // p1.setPerson("문동은","초등학교 교사",43,"여성","010-3225-0516","충청북도 청주 세명시 세명로154");

        // 객체 멤버변수 초기화
        // 작성된 생성자에 따라서 정보를 기입하면된다.
        // 자동화에 대한 힌트는 확인 되었다
        // 멤버 변수를 배열로 선언하고
        // 배열로 선언된 멤버 변수를 출력하는 메서드를 생성하고
        // 클래스에서 매개변수부분에 입력된 문자열의 변수를 작성
        // 클래스를 호출한다면 자동화가 될 듯 싶다.
        // 자동화라고 개념을 잘못 이해한 듯하다.
        // 자동화는 아닌거 같지만
        // 자동화보다는 편하게 작업하는 느낌

    }
}
class Person2 {
    // 멤버변수 캡슐화
    // 접근제한자를 이용해서 멤버변수의 직접 접근을 막음
    private String name;
    private String job;
    private int age;
    private String gender;
    private String phone;
    private String address;
    private String[] info;

    // getter / setter 선언
    // private으로 선언된 변수를 외부에 접근할 수 있도록
    // 정의한 특수 메서드
    // get만써도 자동생성자가 출력되니 사용하면 된다.
    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String[] getInfo() {return info; }

    // setXXX
    // 전부 따로 적지않아도 한번에 모아서 작성해도 된다. 좀 길어서 그렇지
    public void setPerson() {}
    public void setPerson(String name,String job,int age,String gender, String address, String phone,String[] info) {
        this.name = name;
        this.job = job;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.info = info;
    }
        // toString : 모든 멤버변수의 값을 출력할때 사용하는 메서드
        // 배열의 경우 형식 지정자로 나타낼 수 없기에 형변환을 해서 출력을 해야한다.
        @Override // Override를 명시적으로 표현한 방법이다.
        public String toString() {
            String fmt = "%s,%s,%d,%s,%s,%s\n";
            return String.format(fmt,name,job,age,gender,phone,address,info);
        }

}