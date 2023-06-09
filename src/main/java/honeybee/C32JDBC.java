package honeybee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C32JDBC {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        /* EMPDAOImpl는 불필요하게 인스턴스 객체로 생성되지 않게 함
        * 따러서, singleton 패턴을 이용해서 단일 객체로만 만들어지도록 함
        */
        //EMPDAO empdao = new EMPDAOImpl();
        EMPDAO empdao = EMPDAOImpl.getInstance();

        // 사원등록
//        System.out.println("사원 등록을 진행합니다.");
//
//        System.out.print("사원번호는? ");
//        int empno = sc.nextInt();
//        System.out.print("LastName? ");
//        String fname = sc.next();
//        System.out.print("firstName? ");
//        String lname = sc.next();
//        System.out.print("이메일은? ");
//        String email = sc.next();
//        System.out.print("전화번호는? ");
//        String phone = sc.next();
//        System.out.print("고용일은? ");
//        String hdate = sc.next();
//        System.out.print("직무는? ");
//        String jobid = sc.next();
//        System.out.print("연봉은? ");
//        int sal = sc.nextInt();
//        System.out.print("추가금은? ");
//        double comm = sc.nextDouble();
//        System.out.print("상사는? ");
//        int mgrid = sc.nextInt();
//        System.out.print("담당과는? ");
//        int deptno = sc.nextInt();
//
//        EMPVO emp = new EMPVO(empno,fname,lname,email,phone,hdate,jobid,sal,comm
//                ,mgrid,deptno);
//        int cnt = empdao.insertEmp(emp);
//        if (cnt >0) System.out.println("정보 등록 성공");
        // 사원조회
        List<EMPVO> empdata = empdao.selectEmp();

        String fmt = "%d %s %s %s %d\n";
        for(EMPVO emp : empdata) {
            System.out.printf(fmt, emp.getEmpno(),emp.getFname(),emp.getEmail(),emp.getJobid(),emp.getDeptno());
        }
        // 사원상세조회
//        System.out.println("조회할 사원번호는?");
//        int empno1 = sc.nextInt();
//
//        EMPVO emp2 = empdao.selectOneEmp(empno1);
//        if(emp2 != null)System.out.println(emp2);

        // 사원삭제
//        System.out.println("삭제할 사원번호는?");
//        int empno2 = sc.nextInt();
//
//        int cnt1 = empdao.deleteEmp(empno2);
//        if (cnt1 >0) System.out.println("사원정보 삭제 성공");

        // 사원수정

        System.out.print("수정이 필요한 사원번호는? ");
        int mempno = sc.nextInt();
        System.out.print("수정할 LastName? ");
        String mfname = sc.next();
        System.out.print("수정할 firstName? ");
        String mlname = sc.next();
        System.out.print("수정할 이메일은? ");
        String memail = sc.next();
        System.out.print("수정할 전화번호는? ");
        String mphone = sc.next();

        EMPVO emp3 = new EMPVO(mempno,mfname,mlname,memail,mphone);
        //,null,null,0,0.0,0,0);  따로 생성자를 만들지 않은경우
       int cnt2 = empdao.updateEmp(emp3);
        if (cnt2 >0) System.out.println("정보 수정 성공");

        // 전체 조회
        // List<EMPVO> empnoList = EMPDAO.selectEmp();

    }
}
// 이건 여기에서 필요한 정보만 출력되어야하기에
//
class EMPVO {
    private int empno;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String hdate;
    private String jobid;
    private int sal;
    private double comm;
    private int mgrid;
    private int deptno;
    public EMPVO() {};

    public EMPVO(int empno, String fname, String lname, String email, String phone, String hdate, String jobid, int sal, double comm, int mgrid, int deptno) {
        this.empno = empno;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.hdate = hdate;
        this.jobid = jobid;
        this.sal = sal;
        this.comm = comm;
        this.mgrid = mgrid;
        this.deptno = deptno;
    }


    public EMPVO(int mempno, String mfname, String mlname, String memail, String mphone) {
        this.empno = mempno;
        this.fname = mfname;
        this.lname = mlname;
        this.email = memail;
        this.phone = mphone;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHdate() {
        return hdate;
    }

    public void setHdate(String hdate) {
        this.hdate = hdate;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public int getMgrid() {
        return mgrid;
    }

    public void setMgrid(int mgrid) {
        this.mgrid = mgrid;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
    @Override
    public String toString() {
        String fmt = "%d %s %s %s %s %s %s %d %.2f %d %d";
        return String.format(fmt,empno,fname,lname,email,phone,hdate,jobid, sal,comm,mgrid,deptno);
    }
}
interface EMPDAO {
    int insertEmp(EMPVO emp);
    List<EMPVO> selectEmp();
    EMPVO selectOneEmp(int empno);
    int updateEmp(EMPVO emp);
    int deleteEmp(int empno);

}
class EMPDAOImpl implements EMPDAO {
    private String insertSQL = "insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,department_id) values (?,?,?,?,?,? ,?,?,?,?,?)";
    private String selectSQL = "select EMPLOYEE_ID, FIRST_NAME, EMAIL, JOB_ID, department_id from EMPLOYEES ";
    private String selectOneSQL = "select * from EMPLOYEES where EMPLOYEE_ID = ? order by EMPLOYEE_ID desc ";
    private String deleteSQL = "delete from EMPLOYEES where EMPLOYEE_ID = ?";
    private String updateSQL = "update EMPLOYEES set FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PHONE_NUMBER = ? where EMPLOYEE_ID = ?";

    // 싱글톤 패턴을 위해 선언한 변수
    private static EMPDAO instance;

    private EMPDAOImpl() {
    }// 생성자 호출 금지 - 인스턴스 객체로 생성되지 못하게 막음

    public static EMPDAO getInstance() {
        if (instance == null) instance = new EMPDAOImpl();
        return instance;
    }

    public int insertEmp(EMPVO emp) {
        int result = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = C33JDBC.mkConn();
            pstmt = conn.prepareStatement(insertSQL);

            pstmt.setInt(1, emp.getEmpno());
            pstmt.setString(2, emp.getFname());
            pstmt.setString(3, emp.getLname());
            pstmt.setString(4, emp.getEmail());
            pstmt.setString(5, emp.getPhone());
            pstmt.setString(6, emp.getHdate());
            pstmt.setString(7, emp.getJobid());
            pstmt.setInt(8, emp.getSal());
            pstmt.setDouble(9, emp.getComm());
            pstmt.setInt(10, emp.getMgrid());
            pstmt.setInt(11, emp.getDeptno());

            result = pstmt.executeUpdate();
            System.out.println("데이터 입력확인 : " + result);
        } catch (SQLException e) {
            System.out.println("insertEmp에서 오류 발생");
            System.out.println(e.getMessage());
        } finally {
            C33JDBC.clConn(null,pstmt,conn);
        }

        return result;
    };
    public List<EMPVO> selectEmp() {
        List<EMPVO> empdata = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = C33JDBC.mkConn();
            pstmt = conn.prepareStatement(selectSQL);
            rs = pstmt.executeQuery();

            while(rs.next()){
                EMPVO emp1 = new EMPVO(rs.getInt(1),rs.getString(2),""
                        ,rs.getString(3),"","",rs.getString(4),0,0.0,0,rs.getInt(5));
                empdata.add(emp1);
            }
        } catch (SQLException e) {
            System.out.println("selectEmp에서 오류 발생");
            System.out.println(e.getMessage());
        }finally {
            C33JDBC.clConn(rs,pstmt,conn);
        }
        for (EMPVO e : empdata) {
            System.out.println(e);
        }

        return empdata;
    };
    public EMPVO selectOneEmp(int empno) {
        EMPVO emp = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try {
            conn = C33JDBC.mkConn();
            pstmt = conn.prepareStatement(selectOneSQL);
            pstmt.setInt(1,empno);

            rs = pstmt.executeQuery();
            if(rs.next()){
                emp = new EMPVO(rs.getInt(1),rs.getString(2),rs.getString(3)
                        ,rs.getString(4),rs.getString(5),rs.getString(6)
                        ,rs.getString(7),rs.getInt(8), rs.getDouble(9),rs.getInt(10),rs.getInt(11));
            }
        } catch (SQLException e) {
            System.out.println("selectOneEmp에서 오류 발생");
            System.out.println(e.getMessage());
        }finally {
            C33JDBC.clConn(rs,pstmt,conn);
        }

        return emp;
    };

    public int deleteEmp(int empno) {
        int result =0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = C33JDBC.mkConn();
            pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setInt(1,empno);

            result = pstmt.executeUpdate();
            System.out.println("데이터 삭제확인 : "+ result);

        } catch (SQLException e) {
            System.out.println("deleteEmp에서 오류 발생");
            System.out.println(e.getMessage());
        }finally {
            C33JDBC.clConn(null,pstmt,conn);
        }

        return result;
    };

    public int updateEmp(EMPVO emp) {
        int result = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = C33JDBC.mkConn();
            pstmt = conn.prepareStatement(updateSQL);


            pstmt.setString(1, emp.getFname());
            pstmt.setString(2, emp.getLname());
            pstmt.setString(3, emp.getEmail());
            pstmt.setString(4, emp.getPhone());
            pstmt.setInt(5, emp.getEmpno());

            result = pstmt.executeUpdate();  // DML 실행시 사용
            System.out.println("데이터 수정확인 : "+ result);

        } catch (SQLException e) {
            System.out.println("updateEmp에서 오류 발생");
            System.out.println(e.getMessage());
        }finally {
            C33JDBC.clConn(null,pstmt,conn);
        }

        return result;
    };

}