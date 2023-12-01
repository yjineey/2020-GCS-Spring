package com.example.spring02;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)			//테스트 동작코드, 스프링 실행역할을 표시 @RunWith
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
//지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록
public class Test {

    @Inject
    private DataSource ds;
       
    @Inject
    private SqlSessionFactory sqlFactory;
 
    @org.junit.Test
    public void test() throws Exception{
        try(Connection conn = ds.getConnection()){
            System.out.println(conn);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
   
    @org.junit.Test
    public void factoryTest() {
        System.out.println(sqlFactory);
    }
  
    @org.junit.Test
    public void sessionTest() throws Exception{
        try(SqlSession session = sqlFactory.openSession()) {
            System.out.println(session);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}